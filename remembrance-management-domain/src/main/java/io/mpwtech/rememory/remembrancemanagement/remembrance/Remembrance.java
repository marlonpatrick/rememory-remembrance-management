package io.mpwtech.rememory.remembrancemanagement.remembrance;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import io.mpwtech.rememory.remembrancemanagement.common.Entity;
import io.mpwtech.rememory.remembrancemanagement.outbox.OutboxHolder;
import io.mpwtech.rememory.remembrancemanagement.outbox.OutboxMessage;
import io.mpwtech.rememory.remembrancemanagement.outbox.OutboxMessagePayload;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder(access = AccessLevel.PACKAGE)
public class Remembrance implements Entity, OutboxHolder {

    @Id
    @Getter
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Getter
    @Setter(AccessLevel.PACKAGE)
    private ZonedDateTime createdAt;

    @Getter(AccessLevel.PACKAGE)
    private String text;

    @Builder.Default
    @Field(OutboxHolder.FIELD_NAME)
    private LinkedHashSet<OutboxMessage> outbox = new LinkedHashSet<>();

    @Override
    public int hashCode() {
        return this.defaultHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.defaultEquals(Remembrance.class, obj);
    }

    public void clearOutbox() {
        this.outbox = new LinkedHashSet<>();
    }

    @Override
    public boolean hasOutboxMessages() {
        return !this.outbox.isEmpty();
    }

    public boolean addOutboxMessage(OutboxMessagePayload outboxMessagePayload) {
        return this.outbox.add(new OutboxMessage(outboxMessagePayload));
    }
}
