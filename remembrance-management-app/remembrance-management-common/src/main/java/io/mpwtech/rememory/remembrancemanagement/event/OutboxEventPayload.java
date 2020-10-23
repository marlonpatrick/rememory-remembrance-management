package io.mpwtech.rememory.remembrancemanagement.event;

public interface OutboxEventPayload extends OutboxMessagePayload {

    default OutboxMessageType messageType() {
        return OutboxMessageType.EVENT;
    }
}
