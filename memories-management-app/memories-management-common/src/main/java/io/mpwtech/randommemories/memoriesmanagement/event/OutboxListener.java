package io.mpwtech.randommemories.memoriesmanagement.event;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class OutboxListener {

    @Value("${spring.application.name}")
    private String applicationName;

    private DomainMessagePublisher messagePublisher;

    private OutboxRepository outboxRepository;

    OutboxListener(DomainMessagePublisher messagePublisher, OutboxRepository outboxRepository) {
        this.messagePublisher = messagePublisher;
        this.outboxRepository = outboxRepository;
    }

    @EventListener
    void onOutboxMessage(GenericOutbox outbox) {
        outbox.setSourceApplication(this.applicationName);
        this.outboxRepository.save(outbox);
        this.messagePublisher.publish(outbox.getMessage().getPayloadObject());
    }
}
