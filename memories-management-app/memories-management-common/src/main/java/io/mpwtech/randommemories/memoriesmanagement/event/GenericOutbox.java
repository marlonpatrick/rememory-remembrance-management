package io.mpwtech.randommemories.memoriesmanagement.event;

import java.time.ZonedDateTime;
import java.util.UUID;

public interface GenericOutbox {

    UUID getId();

    void setCreatedAt(ZonedDateTime createdAt);

    void setSourceApplication(String sourceApplication);

    GenericOutboxMessage getMessage();
}
