package io.mpwtech.rememory.remembrancemanagement.event;

public interface OutboxCommandPayload extends OutboxMessagePayload {

    default OutboxMessageType messageType() {
        return OutboxMessageType.COMMAND;
    }
}
