package io.mpwtech.rememory.remembrancemanagement.remembrance;

import java.util.Optional;
import java.util.UUID;

public interface RemembranceRepository {

    Remembrance insert(Remembrance remembrance);

    Optional<Remembrance> findById(UUID id);
}
