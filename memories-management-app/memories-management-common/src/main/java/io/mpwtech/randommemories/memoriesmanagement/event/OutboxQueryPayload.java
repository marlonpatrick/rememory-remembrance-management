package io.mpwtech.randommemories.memoriesmanagement.event;

public interface OutboxQueryPayload extends OutboxMessagePayload {

    default OutboxMessageType messageType() {
        return OutboxMessageType.QUERY;
    }
}
