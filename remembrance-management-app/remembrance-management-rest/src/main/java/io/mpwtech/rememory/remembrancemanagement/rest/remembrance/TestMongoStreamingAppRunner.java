package io.mpwtech.rememory.remembrancemanagement.rest.remembrance;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.addFields;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.newAggregation;
import static org.springframework.data.mongodb.core.query.Criteria.matchingDocumentStructure;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.schema.JsonSchemaProperty.array;
import static org.springframework.data.mongodb.core.schema.JsonSchemaProperty.object;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.changestream.FullDocument;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.schema.JsonSchemaObject.Type;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;
import reactor.core.publisher.Flux;

public class TestMongoStreamingAppRunner implements ApplicationRunner {

        @Autowired
        private ReactiveMongoTemplate reactiveMongoTemplate;

        @Override
        public void run(ApplicationArguments args) throws Exception {
                System.out.println(getClass().getName() + " started...");

                // MongoJsonSchema mongoJsonSchema = MongoJsonSchema.builder()
                // .property(object("fullDocument")
                // .properties(array("outbox").minItems(1))
                // .required("outbox"))
                // .required("fullDocument").build();

                ChangeStreamOptions changeStreamOptions = ChangeStreamOptions.builder()
                                .filter(newAggregation(match(where("operationType").in("insert",
                                                "replace", "update"))
                                // ,match(matchingDocumentStructure(mongoJsonSchema)),
                                // match(where("fullDocument.outbox._id")
                                // .exists(true)),
                                // match(where("fullDocument.outbox.createdAt")
                                // .exists(true)),
                                // match(where("fullDocument.outbox.entityName")
                                // .exists(true)),
                                // match(where("fullDocument.outbox.entityId")
                                // .exists(true)),
                                // match(where("fullDocument.outbox.messageType")
                                // .exists(true)),
                                // match(where("fullDocument.outbox.messageName")
                                // .exists(true)),
                                // match(where("fullDocument.outbox.payload")
                                // .exists(true))

                                // ,
                                // match(where("updateDescription.updatedFields")
                                // .exists(true)),
                                // match(where("updateDescription.updatedFields")
                                // .type(Type.OBJECT)),
                                // match(where("updateDescription.updatedFields")
                                // .ne(new Document())),
                                // // match(where("updateDescription.updatedFields")
                                // // .regex("/^outbox/"))
                                // // Projections.computed("record", Filters
                                // // .eq("$objectToArray", "$record"))
                                // addFields().addFieldWithValueOf("teste", value)


                                // "outbox.1", "/outbox.1/", "/^outbox.1/", /^outbox/
                                )).fullDocumentLookup(FullDocument.DEFAULT).build();

                Flux<ChangeStreamEvent<Document>> flux = reactiveMongoTemplate.changeStream(null,
                                changeStreamOptions, Document.class);

                flux.doOnNext(event -> {
                        System.out.println();
                        System.out.println("CHANGE STREAM...");
                        System.out.println(event.getDatabaseName());
                        System.out.println(event.getCollectionName());
                        System.out.println(event.getOperationType());
                        System.out.println(event.getBody());
                        System.out.println();
                        System.out.println(event.getRaw());
                        System.out.println("#################################");
                }).subscribe();

                System.out.println(getClass().getName() + " finished...");
        }
}
