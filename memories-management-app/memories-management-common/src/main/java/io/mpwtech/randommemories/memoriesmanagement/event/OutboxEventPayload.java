package io.mpwtech.randommemories.memoriesmanagement.event;

public interface OutboxEventPayload extends OutboxMessagePayload {

    default OutboxMessageType messageType() {
        return OutboxMessageType.EVENT;
    }
}
