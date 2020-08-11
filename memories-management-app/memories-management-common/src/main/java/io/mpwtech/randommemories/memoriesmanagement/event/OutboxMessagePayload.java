package io.mpwtech.randommemories.memoriesmanagement.event;

import java.util.UUID;

public interface OutboxMessagePayload {

    Class<?> entityClass();

    UUID entityId();

    OutboxMessageType messageType();
}
