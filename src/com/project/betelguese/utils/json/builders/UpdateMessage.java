package com.project.betelguese.utils.json.builders;

public class UpdateMessage extends ServiceMessage {

	private String addBookMessage = "No add Query was executed";
	private String updateBookMessage = "No update Query was executed";

	public UpdateMessage() {
		this(0, null);
	}

	public UpdateMessage(int done, String message) {
		this(0, null, null);
		// TODO Auto-generated constructor stub
	}

	public UpdateMessage(int done, String message, String requestName) {
		this(done, message, requestName, "No add Query was executed",
				"No add Query was executed");
	}

	/**
	 * @param addBookMessage
	 * @param updateBookMessage
	 */
	public UpdateMessage(int done, String message, String requestName,
			String addBookMessage, String updateBookMessage) {
		super(done, updateBookMessage, requestName);
		this.addBookMessage = addBookMessage;
		this.updateBookMessage = updateBookMessage;
	}

	/**
	 * @return the addBookMessage
	 */
	public String getAddBookMessage() {
		return addBookMessage;
	}

	/**
	 * @param addBookMessage
	 *            the addBookMessage to set
	 */
	public void setAddBookMessage(String addBookMessage) {
		this.addBookMessage = addBookMessage;
	}

	/**
	 * @return the updateBookMessage
	 */
	public String getUpdateBookMessage() {
		return updateBookMessage;
	}

	/**
	 * @param updateBookMessage
	 *            the updateBookMessage to set
	 */
	public void setUpdateBookMessage(String updateBookMessage) {
		this.updateBookMessage = updateBookMessage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateMessage [addBookMessage=" + addBookMessage
				+ ", updateBookMessage=" + updateBookMessage + "]";
	}

}
