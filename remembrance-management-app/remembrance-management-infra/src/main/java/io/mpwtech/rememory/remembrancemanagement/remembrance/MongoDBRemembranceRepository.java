package io.mpwtech.rememory.remembrancemanagement.remembrance;

import java.util.UUID;
import org.springframework.data.repository.Repository;
import io.mpwtech.rememory.remembrancemanagement.remembrance.Remembrance;
import io.mpwtech.rememory.remembrancemanagement.remembrance.RemembranceRepository;

@org.springframework.stereotype.Repository
interface MongoDBRemembranceRepository extends RemembranceRepository, Repository<Remembrance, UUID> {

}
