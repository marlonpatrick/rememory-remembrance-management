package io.mpwtech.rememory.remembrancemanagement.outbox;

import java.util.UUID;

public interface OutboxMessagePayload {

    Class<?> entityClass();

    UUID entityId();
}
