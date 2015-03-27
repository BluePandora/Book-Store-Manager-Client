package com.project.betelguese.utils.json.builders;

public class UpdateBookIdMessage extends ServiceMessage {

	private String maxBooksId;

	public UpdateBookIdMessage() {
	}

	public UpdateBookIdMessage(int done, String message) {
		this(done, message, null);
	}

	public UpdateBookIdMessage(int done, String message, String requestName) {
		this(done, message, requestName, "1");
	}

	public UpdateBookIdMessage(int done, String message, String requestName,
			String maxBooksId) {
		super(done, message, requestName);
		this.maxBooksId = maxBooksId;
	}

	/**
	 * @return the maxBooksId
	 */
	public String getMaxBooksId() {
		return maxBooksId;
	}

	/**
	 * @param maxBooksId
	 *            the maxBooksId to set
	 */
	public void setMaxBooksId(String maxBooksId) {
		this.maxBooksId = maxBooksId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateBookIdMessage [maxBooksId=" + maxBooksId + "]";
	}

}
