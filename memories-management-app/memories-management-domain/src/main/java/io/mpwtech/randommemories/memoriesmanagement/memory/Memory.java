package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import io.mpwtech.randommemories.memoriesmanagement.common.IEntity;
import io.mpwtech.randommemories.memoriesmanagement.common.OutboxMessage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder(access = AccessLevel.PACKAGE)
public class Memory implements IEntity {

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
    private LinkedHashSet<OutboxMessage> outbox = new LinkedHashSet<>();

    @Override
    public int hashCode() {
        return this.defaultHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.defaultEquals(Memory.class, obj);
    }

    boolean addOutboxMessage(OutboxMessage outboxMessage) {
        return this.outbox.add(outboxMessage);
    }
}
