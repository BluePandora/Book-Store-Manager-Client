package com.project.betelguese.utils.items;

import java.util.List;

public class TransactionReport extends TransactionInfo {

	private String adminName;
	private String date;

	public TransactionReport() {
	}

	public TransactionReport(String customerName, String customerNumber,
			String transactionId, String totalPaid, String adminId,
			List<TransactionBook> transactionBooks, String adminName,
			String date) {
		super(customerName, customerNumber, transactionId, totalPaid, adminId,
				transactionBooks);
		this.adminName = adminName;
		this.date = date;
	}

	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param adminName
	 *            the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionReport [adminName=" + adminName + ", date=" + date
				+ "]";
	}

}
