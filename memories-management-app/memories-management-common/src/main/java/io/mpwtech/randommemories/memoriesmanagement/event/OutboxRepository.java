package io.mpwtech.randommemories.memoriesmanagement.event;

interface OutboxRepository {
    GenericOutbox save(GenericOutbox outbox);
}
