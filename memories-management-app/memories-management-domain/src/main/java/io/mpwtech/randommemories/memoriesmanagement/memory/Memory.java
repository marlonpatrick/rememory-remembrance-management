package io.mpwtech.randommemories.memoriesmanagement.memory;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(access = AccessLevel.PACKAGE)
public class Memory {

    @Getter
    @Setter(value = AccessLevel.PACKAGE)
    private UUID id;

    @Getter
    @Setter(value = AccessLevel.PACKAGE)
    private ZonedDateTime createdAt;

    @Getter
    private String text;

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            if (!(obj instanceof Memory)) {
                return false;
            }
        }

        Memory other = (Memory) obj;

        if (!Objects.equals(this.id, other.id)) {
            return false;
        }

        return true;
    }
}
