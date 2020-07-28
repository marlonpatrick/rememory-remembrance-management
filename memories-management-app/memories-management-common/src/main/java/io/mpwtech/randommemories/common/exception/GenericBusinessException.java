package io.mpwtech.randommemories.common.exception;

import java.util.Collection;

public class GenericBusinessException extends GenericAppException {

    private static final long serialVersionUID = 1L;

    public GenericBusinessException(String message) {
        super(message);
    }

    public GenericBusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericBusinessException(Throwable cause) {
        super(cause);
    }

    public GenericBusinessException(Collection<String> messages) {
        super(messages == null ? null : messages.toString());
    }
}
