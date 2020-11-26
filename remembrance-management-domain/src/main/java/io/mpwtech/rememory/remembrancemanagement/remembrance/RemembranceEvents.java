package io.mpwtech.rememory.remembrancemanagement.remembrance;

import java.time.ZonedDateTime;
import java.util.UUID;
import org.springframework.data.annotation.Transient;
import io.mpwtech.rememory.remembrancemanagement.outbox.OutboxMessagePayload;

public final class RemembranceEvents {

    private RemembranceEvents() {
    }

    public final record RemembranceCreatedEvent(@Transient UUID entityId, ZonedDateTime createdAt,
            String text) implements OutboxMessagePayload {

        @Override
        public String entityName() {
            return Remembrance.class.getSimpleName();
        }

        @Override
        public String messageName() {
            return getClass().getSimpleName();
        }

        @Override
        public String targetTopicSufix() {
            return "public.event.remembrance";
        }


        static RemembranceCreatedEvent from(Remembrance remembrance) {
            return new RemembranceCreatedEvent(remembrance.getId(), remembrance.getCreatedAt(),
                    remembrance.getText());
        }
    }
}
