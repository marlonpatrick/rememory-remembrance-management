package io.mpwtech.rememory.remembrancemanagement.event;

public interface OutboxQueryPayload extends OutboxMessagePayload {

    default OutboxMessageType messageType() {
        return OutboxMessageType.QUERY;
    }
}
