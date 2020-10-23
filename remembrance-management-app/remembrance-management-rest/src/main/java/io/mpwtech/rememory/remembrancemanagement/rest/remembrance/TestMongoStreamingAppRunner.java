package io.mpwtech.rememory.remembrancemanagement.rest.remembrance;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.matchingDocumentStructure;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.schema.JsonSchemaProperty.array;
import static org.springframework.data.mongodb.core.schema.JsonSchemaProperty.object;
import com.mongodb.client.model.changestream.FullDocument;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;
import reactor.core.publisher.Flux;

public class TestMongoStreamingAppRunner implements ApplicationRunner {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(getClass().getName() + " started...");

        MongoJsonSchema mongoJsonSchema = MongoJsonSchema.builder()
                .property(object("fullDocument").properties(array("outbox").minItems(1)
                // CodecConfigurationException: Can't find a codec for class
                // org.springframework.data.mongodb.core.schema.TypedJsonSchemaObject$ObjectJsonSchemaObject.
                // .items(JsonSchemaObject.object().required("_id", "createdAt", "entityName",
                // "entityId", "messageType", "messageName", "payload"))
                ).required("outbox")).required("fullDocument").build();

        ChangeStreamOptions changeStreamOptions = ChangeStreamOptions.builder()
                .filter(newAggregation(
                        match(where("operationType").in("insert", "replace", "update")),
                        match(matchingDocumentStructure(mongoJsonSchema)),
                        match(where("fullDocument.outbox._id").exists(true)),
                        match(where("fullDocument.outbox.createdAt").exists(true)),
                        match(where("fullDocument.outbox.entityName").exists(true)),
                        match(where("fullDocument.outbox.entityId").exists(true)),
                        match(where("fullDocument.outbox.messageType").exists(true)),
                        match(where("fullDocument.outbox.messageName").exists(true)),
                        match(where("fullDocument.outbox.payload").exists(true))))
                .fullDocumentLookup(FullDocument.UPDATE_LOOKUP).build();

        Flux<ChangeStreamEvent<Document>> flux =
                reactiveMongoTemplate.changeStream(null, changeStreamOptions, Document.class);

        flux.doOnNext(event -> {
            System.out.println("CHANGE STREAM...");
            System.out.println(event.getDatabaseName());
            System.out.println(event.getCollectionName());
            System.out.println(event.getOperationType());
            System.out.println(event.getBody());
            System.out.println(event.getRaw());
        }).subscribe();

        System.out.println(getClass().getName() + " finished...");
    }
}
