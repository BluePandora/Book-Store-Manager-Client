package com.project.betelguese.utils.items;

import java.util.List;

public class TransactionInfo {

	private String customerName;
	private String customerNumber;
	private String transactionId;
	private String totalPaid;
	private String adminId;
	private List<TransactionBook> transactionBooks;

	public TransactionInfo() {
	}

	/**
	 * @param customerName
	 * @param customerNumber
	 * @param transactionId
	 * @param totalPaid
	 * @param adminId
	 * @param transactionBooks
	 */
	public TransactionInfo(String customerName, String customerNumber,
			String transactionId, String totalPaid, String adminId,
			List<TransactionBook> transactionBooks) {
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.transactionId = transactionId;
		this.totalPaid = totalPaid;
		this.adminId = adminId;
		this.transactionBooks = transactionBooks;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName
	 *            the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerNumber
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @param customerNumber
	 *            the customerNumber to set
	 */
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
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

	/**
	 * @return the totalPaid
	 */
	public String getTotalPaid() {
		return totalPaid;
	}

	/**
	 * @param totalPaid
	 *            the totalPaid to set
	 */
	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}

	/**
	 * @return the adminId
	 */
	public String getAdminId() {
		return adminId;
	}

	/**
	 * @param adminId
	 *            the adminId to set
	 */
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	/**
	 * @return the transactionBooks
	 */
	public List<TransactionBook> getTransactionBooks() {
		return transactionBooks;
	}

	/**
	 * @param transactionBooks
	 *            the transactionBooks to set
	 */
	public void setTransactionBooks(List<TransactionBook> transactionBooks) {
		this.transactionBooks = transactionBooks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionInfo [customerName=" + customerName
				+ ", customerNumber=" + customerNumber + ", transactionId="
				+ transactionId + ", totalPaid=" + totalPaid + ", adminId="
				+ adminId + ", transactionBooks=" + transactionBooks + "]";
	}

}
