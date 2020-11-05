package io.mpwtech.rememory.remembrancemanagement.remembrance;

import java.time.ZonedDateTime;
import java.util.UUID;
import io.mpwtech.rememory.remembrancemanagement.common.OutboxMessage;
import io.mpwtech.rememory.remembrancemanagement.event.OutboxMessagePayload;

public class RemembranceEvents {

    public record RemembranceCreatedEvent(UUID id, ZonedDateTime createdAt, String text)
            implements OutboxMessagePayload {

        @Override
        public UUID entityId() {
            return id();
        }

        @Override
        public Class<?> entityClass() {
            return Remembrance.class;
        }

        static OutboxMessage outboxMessage(Remembrance remembrance) {
            return new OutboxMessage(new RemembranceCreatedEvent(remembrance.getId(),
                    remembrance.getCreatedAt(), remembrance.getText()));
        }
    }
}
