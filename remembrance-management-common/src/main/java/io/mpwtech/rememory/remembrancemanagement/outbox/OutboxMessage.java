package io.mpwtech.rememory.remembrancemanagement.outbox;

import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.UUID;
import org.springframework.data.annotation.PersistenceConstructor;
import lombok.ToString;

@ToString
public final class OutboxMessage {

    /**
     * Populated by OutboxTargetTopicPrefixInitializer
     */
    static String TARGET_TOPIC_PREFIX = "";



    private final UUID id;

    private final ZonedDateTime createdAt;

    private final String entityName;

    private final UUID entityId;

    private final String messageName;

    private final String targetTopic;

    private final Object payload;


    public OutboxMessage(OutboxMessagePayload payload) {
        this.id = UUID.randomUUID();
        this.createdAt = ZonedDateTime.now();
        this.entityName = payload.entityName();
        this.entityId = payload.entityId();
        this.messageName = payload.messageName();
        this.targetTopic = TARGET_TOPIC_PREFIX + payload.targetTopicSufix();
        this.payload = payload;
    }

    @PersistenceConstructor
    OutboxMessage(UUID id, ZonedDateTime createdAt, String entityName, UUID entityId,
            String messageName, String targetTopic, LinkedHashMap<String, Object> payload) {

        this.id = id;
        this.createdAt = createdAt;
        this.entityName = entityName;
        this.entityId = entityId;
        this.messageName = messageName;
        this.payload = payload;
        this.targetTopic = targetTopic;
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

        return Objects.equals(this.id, other.id);
    }
}
