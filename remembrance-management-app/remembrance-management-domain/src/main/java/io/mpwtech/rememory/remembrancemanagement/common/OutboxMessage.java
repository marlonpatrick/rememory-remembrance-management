package io.mpwtech.rememory.remembrancemanagement.common;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;
import org.bson.Document;
import org.springframework.data.annotation.PersistenceConstructor;
import io.mpwtech.rememory.remembrancemanagement.event.OutboxMessagePayload;
import io.mpwtech.rememory.remembrancemanagement.event.OutboxMessageType;
import lombok.ToString;

@ToString
public final class OutboxMessage {


    private final UUID id;

    private final ZonedDateTime createdAt;

    private final String entityName;

    private final UUID entityId;

    private final OutboxMessageType messageType;

    private final String messageName;

    private final Object payload;

    public OutboxMessage(OutboxMessagePayload payload) {
        this.id = UUID.randomUUID();
        this.createdAt = ZonedDateTime.now();
        this.entityName = payload.entityClass().getSimpleName();
        this.entityId = payload.entityId();
        this.messageType = payload.messageType();
        this.messageName = payload.getClass().getSimpleName();
        this.payload = payload;
    }

    @PersistenceConstructor
    OutboxMessage(UUID id, ZonedDateTime createdAt, String entityName, UUID entityId,
            OutboxMessageType messageType, String messageName, Document payload) {

        this.id = id;
        this.createdAt = createdAt;
        this.entityName = entityName;
        this.entityId = entityId;
        this.messageType = messageType;
        this.messageName = messageName;
        this.payload = payload;
    }

    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return true;
        }

        if (OutboxMessage.class != obj.getClass()) {
            if (!OutboxMessage.class.isInstance(obj)) {
                return false;
            }
        }

        OutboxMessage other = (OutboxMessage) obj;

        if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return true;
    }
}
