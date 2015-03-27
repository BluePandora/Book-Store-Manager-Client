package com.project.betelguese.utils.json.builders;

public class ServiceMessage extends Message {

	private String requestName;

	public ServiceMessage() {
		this(0, null);
	}

	/**
	 * 
	 * @param done
	 * @param message
	 */
	public ServiceMessage(int done, String message) {
		this(done, message, null);
	}

	/**
	 * 
	 * @param done
	 * @param message
	 * @param requestName
	 */
	public ServiceMessage(int done, String message, String requestName) {
		super(done, message);
		this.requestName = requestName;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
}
