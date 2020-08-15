package io.mpwtech.randommemories.memoriesmanagement.exception;

import java.util.Collection;

public class BusinessException extends AbstractAppException {

    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(Collection<String> messages) {
        super(messages);
    }
}
