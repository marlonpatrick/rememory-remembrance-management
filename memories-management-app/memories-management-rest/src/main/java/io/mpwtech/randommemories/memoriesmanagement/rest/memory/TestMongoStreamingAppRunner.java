package io.mpwtech.randommemories.memoriesmanagement.rest.memory;

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

        Flux<ChangeStreamEvent<String>> flux = reactiveMongoTemplate
                .changeStream("rm-memories-mngmt", null, ChangeStreamOptions.empty(), String.class);

        flux.doOnNext(event -> {
            System.out.println("CHANGE STREAM MARLON...");
            System.out.println(event.getRaw());
        }).subscribe();

        System.out.println(getClass().getName() + " finished...");
    }
}
