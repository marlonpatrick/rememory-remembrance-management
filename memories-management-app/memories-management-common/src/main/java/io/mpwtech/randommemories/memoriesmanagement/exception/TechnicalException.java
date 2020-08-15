package io.mpwtech.randommemories.memoriesmanagement.exception;

import java.util.Collection;

public class TechnicalException extends AbstractAppException {

    private static final long serialVersionUID = 1L;

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }

    public TechnicalException(Collection<String> messages) {
        super(messages);
    }
}
