package io.mpwtech.randommemories.memoriesmanagement.event;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
class InMemoryOutboxRepository implements OutboxRepository {

    private Map<UUID, GenericOutbox> outboxes = new HashMap<>();

    @Override
    public GenericOutbox save(GenericOutbox outbox) {
        outbox.setCreatedAt(ZonedDateTime.now());
        outboxes.put(outbox.getId(), outbox);
        return outbox;
    }

}
