package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.time.ZonedDateTime;
import java.util.UUID;
import io.mpwtech.randommemories.memoriesmanagement.common.OutboxMessage;
import io.mpwtech.randommemories.memoriesmanagement.event.OutboxEventPayload;

public class MemoryEvents {

    public record MemoryCreatedEvent(UUID id, ZonedDateTime createdAt, String text)
            implements OutboxEventPayload {

        @Override
        public UUID entityId() {
            return id();
        }

        @Override
        public Class<?> entityClass() {
            return Memory.class;
        }

        static OutboxMessage outboxMessage(Memory memory) {
            return new OutboxMessage(new MemoryCreatedEvent(memory.getId(), memory.getCreatedAt(),
                    memory.getText()));
        }
    }
}
