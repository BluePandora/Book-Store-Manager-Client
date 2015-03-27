package com.project.betelguese.utils.json.builders;

public class TransactionIdMessage extends ServiceMessage {

	private String transactionId;

	/**
	 */
	public TransactionIdMessage() {
		this(0, null, null);
	}

	/**
	 * @param transactionId
	 */
	public TransactionIdMessage(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * 
	 * @param done
	 * @param message
	 * @param requestName
	 */
	public TransactionIdMessage(int done, String message, String requestName) {
		this(done, message, requestName, null);
	}

	/**
	 * 
	 * @param done
	 * @param message
	 * @param requestName
	 * @param transactionId
	 */
	public TransactionIdMessage(int done, String message, String requestName,
			String transactionId) {
		super(done, message, requestName);
		this.transactionId = transactionId;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId
	 *            the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}