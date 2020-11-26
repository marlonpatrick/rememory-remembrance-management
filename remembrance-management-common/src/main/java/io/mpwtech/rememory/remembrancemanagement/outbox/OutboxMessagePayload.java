package io.mpwtech.rememory.remembrancemanagement.outbox;

import java.util.UUID;

public interface OutboxMessagePayload {

    UUID entityId();

    String entityName();

    String messageName();

    String targetTopicSufix();
}
