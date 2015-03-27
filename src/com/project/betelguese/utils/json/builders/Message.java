package com.project.betelguese.utils.json.builders;

public class Message {

	private int done;
	private String message;

	public Message() {
		this(0, null);
	}

	public int getDone() {
		return done;
	}

	public void setDone(int done) {
		this.done = done;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param done
	 * @param message
	 */
	public Message(int done, String message) {
		this.done = done;
		this.message = message;
	}

}
