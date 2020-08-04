package io.mpwtech.randommemories.memoriesmanagement.exception;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GenericAppException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	private final List<String> messages = new ArrayList<>();

	public GenericAppException(String message) {
		super(message);
		this.messages.add(message);
	}

	public GenericAppException(String message, Throwable cause) {
		super(message, cause);
		this.messages.add(message);
	}

	public GenericAppException(Throwable cause) {
		super(cause);
		this.messages.add(this.getMessage());
	}

	public GenericAppException(Collection<String> messages) {
		super(messages == null ? null : messages.toString());
		this.messages.addAll(messages);
	}

	public List<String> getMessages() {
		return Collections.unmodifiableList(this.messages);
	}
}
