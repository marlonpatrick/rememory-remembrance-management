package io.mpwtech.randommemories.memoriesmanagement.common;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;
import org.bson.Document;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Transient;
import io.mpwtech.randommemories.memoriesmanagement.event.OutboxMessagePayload;
import io.mpwtech.randommemories.memoriesmanagement.event.OutboxMessageType;
import io.mpwtech.randommemories.memoriesmanagement.json.JSONUtils;
import lombok.ToString;

@ToString
public final class OutboxMessage {


    private final UUID id;

    private final ZonedDateTime createdAt;

    private final String entityName;

    private final UUID entityId;

    private final OutboxMessageType messageType;

    private final String messageName;

    private final Document payload;

    @Transient
    @ToString.Exclude
    private final OutboxMessagePayload payloadObject;

    public OutboxMessage(OutboxMessagePayload payloadObject) {
        this.id = UUID.randomUUID();
        this.createdAt = ZonedDateTime.now();
        this.entityName = payloadObject.entityClass().getSimpleName();
        this.entityId = payloadObject.entityId();
        this.payloadObject = payloadObject;
        this.messageType = payloadObject.messageType();
        this.messageName = payloadObject.getClass().getSimpleName();
        this.payload = Document.parse(JSONUtils.toJSON(this.payloadObject));
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
        this.payloadObject = null;
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
