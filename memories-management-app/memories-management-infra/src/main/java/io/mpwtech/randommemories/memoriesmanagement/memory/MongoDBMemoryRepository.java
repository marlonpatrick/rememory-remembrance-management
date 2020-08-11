package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
interface MongoDBMemoryRepository extends MemoryRepository, MongoRepository<Memory, UUID> {

}
