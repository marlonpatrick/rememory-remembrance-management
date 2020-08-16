package io.mpwtech.randommemories.memoriesmanagement.rest.memory;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.ChangeStreamEvent;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Flux;

public class TestMongoStreamingAppRunner implements ApplicationRunner {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(getClass().getName() + " started...");

        reactiveMongoTemplate.getMongoDatabase()
                .doOnNext(e -> System.out.println("DATABASE NAME: " + e.getName())).subscribe();

        Flux<ChangeStreamEvent<Document>> flux = reactiveMongoTemplate.changeStream(null,
                ChangeStreamOptions.empty(), Document.class);

        flux.doOnNext(event -> {
            System.out.println("CHANGE STREAM MARLON...");
            System.out.println(event.getClass());
            System.out.println(event.getBody());
            System.out.println(event.getRaw());
            System.out.println(event.getDatabaseName());
            System.out.println(event.getCollectionName());
        }).subscribe();

        System.out.println(getClass().getName() + " finished...");
    }
}
