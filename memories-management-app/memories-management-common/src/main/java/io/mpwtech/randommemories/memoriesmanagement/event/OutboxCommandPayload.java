package io.mpwtech.randommemories.memoriesmanagement.event;

public interface OutboxCommandPayload extends OutboxMessagePayload {

    default OutboxMessageType messageType() {
        return OutboxMessageType.COMMAND;
    }
}
