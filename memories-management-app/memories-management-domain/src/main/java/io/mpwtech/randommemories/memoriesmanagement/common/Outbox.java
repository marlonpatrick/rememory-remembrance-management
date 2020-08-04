package io.mpwtech.randommemories.memoriesmanagement.common;

import java.time.ZonedDateTime;
import java.util.UUID;
import io.mpwtech.randommemories.memoriesmanagement.event.GenericOutbox;
import lombok.Getter;
import lombok.Setter;

public final class Outbox implements GenericEntity, GenericOutbox {

    @Getter
    private final UUID id = UUID.randomUUID();

    @Getter
    @Setter
    private ZonedDateTime createdAt;

    @Setter
    private String sourceApplication;

    private final String entity;

    private final UUID entityId;

    private final OutboxMessage message;

    private Outbox(GenericEntity entity, Object payloadObject, OutboxMessageType messageType) {
        this.entity = entity.getClass().getSimpleName();
        this.entityId = entity.getId();
        this.message = new OutboxMessage(messageType, payloadObject);
    }

    @Override
    public OutboxMessage getMessage() {
        return this.message;
    }

    public static Outbox event(GenericEntity entity, Object payloadObject) {
        return new Outbox(entity, payloadObject, OutboxMessageType.EVENT);
    }

    public static Outbox command(GenericEntity entity, Object payloadObject) {
        return new Outbox(entity, payloadObject, OutboxMessageType.COMMAND);
    }

    public static Outbox query(GenericEntity entity, Object payloadObject) {
        return new Outbox(entity, payloadObject, OutboxMessageType.QUERY);
    }
}
