package io.mpwtech.rememory.remembrancemanagement.remembrance;

import java.util.UUID;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
interface MongoDBRemembranceRepository
        extends RemembranceRepository, Repository<Remembrance, UUID> {

}
