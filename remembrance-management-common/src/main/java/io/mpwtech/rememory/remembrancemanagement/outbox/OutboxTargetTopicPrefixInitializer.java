package io.mpwtech.rememory.remembrancemanagement.outbox;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
class OutboxTargetTopicPrefixInitializer {

    @Bean
    ApplicationRunner initializeTargetTopicPrefixRunner(Environment environment) {

        return runner -> {
            String targetTopicPrefix = environment.getProperty("outbox.target-topic.prefix");

            if (targetTopicPrefix == null) {
                targetTopicPrefix = "";
            }

            OutboxMessage.TARGET_TOPIC_PREFIX = targetTopicPrefix;
        };
    }
}

