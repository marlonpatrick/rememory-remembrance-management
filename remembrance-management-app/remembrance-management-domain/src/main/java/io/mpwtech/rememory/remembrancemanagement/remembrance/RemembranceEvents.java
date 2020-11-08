package io.mpwtech.rememory.remembrancemanagement.remembrance;

import java.time.ZonedDateTime;
import java.util.UUID;
import io.mpwtech.rememory.remembrancemanagement.outbox.OutboxMessagePayload;

public final class RemembranceEvents {

    private RemembranceEvents() {
    }

    public final record RemembranceCreatedEvent(UUID id, ZonedDateTime createdAt, String text)
            implements OutboxMessagePayload {

        @Override
        public UUID entityId() {
            return id();
        }

        @Override
        public Class<?> entityClass() {
            return Remembrance.class;
        }

        static RemembranceCreatedEvent from(Remembrance remembrance) {
            return new RemembranceCreatedEvent(remembrance.getId(), remembrance.getCreatedAt(),
                    remembrance.getText());
        }
    }
}
