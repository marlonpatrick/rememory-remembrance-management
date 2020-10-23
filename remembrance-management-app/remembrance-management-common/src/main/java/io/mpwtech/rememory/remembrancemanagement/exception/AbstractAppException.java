package io.mpwtech.rememory.remembrancemanagement.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AbstractAppException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	private final List<String> messages = new ArrayList<>();

	public AbstractAppException(String message) {
		super(message);
		this.messages.add(message);
	}

	public AbstractAppException(String message, Throwable cause) {
		super(message, cause);
		this.messages.add(message);
	}

	public AbstractAppException(Throwable cause) {
		super(cause);
		this.messages.add(cause.getMessage());
	}

	public AbstractAppException(Collection<String> messages) {
		super(messages == null ? null : messages.toString());
		this.messages.addAll(messages);
	}

	public List<String> getMessages() {
		return Collections.unmodifiableList(this.messages);
	}
}
