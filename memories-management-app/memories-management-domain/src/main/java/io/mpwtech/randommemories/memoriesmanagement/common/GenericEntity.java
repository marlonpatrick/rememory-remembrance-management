package io.mpwtech.randommemories.memoriesmanagement.common;

import java.util.Objects;
import java.util.UUID;

public interface GenericEntity {

    UUID getId();

    default int defaultHashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    default boolean defaultEquals(Class<?> clazz, Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return true;
        }

        if (clazz != obj.getClass()) {
            if (!clazz.isInstance(obj)) {
                return false;
            }
        }

        GenericEntity other = (GenericEntity) obj;

        if (!Objects.equals(this.getId(), other.getId())) {
            return false;
        }

        return true;
    }
}
