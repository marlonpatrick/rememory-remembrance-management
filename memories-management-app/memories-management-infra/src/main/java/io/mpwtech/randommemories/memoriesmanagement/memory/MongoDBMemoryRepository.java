package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.util.UUID;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
interface MongoDBMemoryRepository extends MemoryRepository, Repository<Memory, UUID> {

}
