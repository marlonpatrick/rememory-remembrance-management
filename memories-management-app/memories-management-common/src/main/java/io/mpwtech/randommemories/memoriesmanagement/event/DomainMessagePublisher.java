package io.mpwtech.randommemories.memoriesmanagement.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class DomainMessagePublisher {

    private final ApplicationEventPublisher eventPublisher;

    DomainMessagePublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publish(Object event) {
        eventPublisher.publishEvent(event);
    }
}
