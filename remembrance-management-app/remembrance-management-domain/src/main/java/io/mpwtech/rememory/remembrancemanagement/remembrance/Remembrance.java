package io.mpwtech.rememory.remembrancemanagement.remembrance;

import java.time.ZonedDateTime;
import java.util.LinkedHashSet;
import java.util.UUID;
import org.springframework.data.annotation.Id;
import io.mpwtech.rememory.remembrancemanagement.common.IEntity;
import io.mpwtech.rememory.remembrancemanagement.common.OutboxMessage;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder(access = AccessLevel.PACKAGE)
public class Remembrance implements IEntity {

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
        return this.defaultEquals(Remembrance.class, obj);
    }

    boolean addOutboxMessage(OutboxMessage outboxMessage) {
        return this.outbox.add(outboxMessage);
    }


}
