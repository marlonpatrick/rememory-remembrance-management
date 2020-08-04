package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.time.ZonedDateTime;
import java.util.UUID;
import io.mpwtech.randommemories.memoriesmanagement.common.GenericEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(access = AccessLevel.PACKAGE)
public class Memory implements GenericEntity {

    @Getter
    @Builder.Default
    private UUID id = UUID.randomUUID();

    @Getter
    @Setter(AccessLevel.PACKAGE)
    private ZonedDateTime createdAt;

    @Getter(AccessLevel.PACKAGE)
    private String text;

    @Override
    public int hashCode() {
        return this.defaultHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.defaultEquals(Memory.class, obj);
    }
}
