package io.mpwtech.rememory.remembrancemanagement.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    private final ApplicationEventPublisher eventPublisher;

    MessagePublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publish(Object event) {
        eventPublisher.publishEvent(event);
    }
}
