package io.mpwtech.rememory.remembrancemanagement.outbox;

public interface OutboxHolder {

    String FIELD_NAME = "outbox";

    boolean hasOutboxMessages();

    void clearOutbox();
}
