package io.mpwtech.rememory.remembrancemanagement.outbox;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.unset;
import com.mongodb.WriteConcern;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AfterConvertCallback;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveCallback;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@Component
class OutboxHolderMongoDBCallback
        implements AfterConvertCallback<OutboxHolder>, AfterSaveCallback<OutboxHolder> {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public OutboxHolder onAfterSave(OutboxHolder entity, Document document, String collection) {



        if (entity.hasOutboxMessages()) {
            entity.clearOutbox();

            this.reactiveMongoTemplate.getCollection(collection)
                    .map(mc -> mc.withWriteConcern(WriteConcern.W1.withJournal(false)))
                    .flatMap(mc -> Mono.from(mc.updateOne(eq("_id", document.get("_id")),
                            unset(OutboxHolder.FIELD_NAME))))
                    .subscribeOn(Schedulers.boundedElastic()).subscribe();

        }

        return entity;
    }

    @Override
    public OutboxHolder onAfterConvert(OutboxHolder entity, Document target, String collection) {

        if (entity.hasOutboxMessages()) {
            entity.clearOutbox();
        }

        return entity;
    }
}
