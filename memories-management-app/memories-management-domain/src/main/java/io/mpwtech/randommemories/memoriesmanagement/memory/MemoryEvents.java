package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.time.ZonedDateTime;
import java.util.UUID;

public class MemoryEvents {

    public record MemoryCreatedEvent(UUID id, ZonedDateTime createdAt, String text) {

        static MemoryCreatedEvent from(Memory memory) {
            return new MemoryCreatedEvent(memory.getId(), memory.getCreatedAt(), memory.getText());
        }
    }
}
