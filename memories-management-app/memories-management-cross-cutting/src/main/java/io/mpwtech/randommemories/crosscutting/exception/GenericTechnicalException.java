package io.mpwtech.randommemories.crosscutting.exception;

import java.util.Collection;

public class GenericTechnicalException extends GenericAppException {

    private static final long serialVersionUID = 1L;

    public GenericTechnicalException(String message) {
        super(message);
    }

    public GenericTechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public GenericTechnicalException(Throwable cause) {
        super(cause);
    }

    public GenericTechnicalException(Collection<String> messages) {
        super(messages == null ? null : messages.toString());
    }
}
