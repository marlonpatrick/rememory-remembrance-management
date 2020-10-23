package io.mpwtech.rememory.remembrancemanagement.event;

import java.util.UUID;

public interface OutboxMessagePayload {

    Class<?> entityClass();

    UUID entityId();

    OutboxMessageType messageType();
}
