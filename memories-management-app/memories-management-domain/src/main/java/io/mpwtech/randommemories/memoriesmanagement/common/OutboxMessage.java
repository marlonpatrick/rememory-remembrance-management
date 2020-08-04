package io.mpwtech.randommemories.memoriesmanagement.common;

import io.mpwtech.randommemories.memoriesmanagement.event.GenericOutboxMessage;
import lombok.Getter;

public class OutboxMessage implements GenericOutboxMessage {

    private OutboxMessageType type;

    private String name;

    private String payload;

    // Transient
    @Getter
    private Object payloadObject;

    public OutboxMessage(OutboxMessageType type, Object payloadObject) {
        this.type = type;
        this.payloadObject = payloadObject;
        this.name = payloadObject.getClass().getName();

        // TODO: json
        this.payload = payloadObject.toString();
    }
}
