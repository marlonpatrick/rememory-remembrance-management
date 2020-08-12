package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.util.Optional;
import java.util.UUID;

interface MemoryRepository {

    Memory insert(Memory memory);

    Optional<Memory> findById(UUID id);
}
