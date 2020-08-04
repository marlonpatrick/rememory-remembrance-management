package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
class InMemoryMemoryRepository implements MemoryRepository {

    private Map<UUID, Memory> memories = new HashMap<>();

    @Override
    public Memory save(Memory memory) {
        memory.setCreatedAt(ZonedDateTime.now());
        memories.put(memory.getId(), memory);
        return memory;
    }

}
