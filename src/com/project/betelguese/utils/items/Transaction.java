package com.project.betelguese.utils.items;

public class Transaction extends TransactionInfo {
	private String createdTime;
	private String adminName;

	/**
	 * @param createdTime
	 * @param adminName
	 */
	public Transaction(String createdTime, String adminName) {
		this.createdTime = createdTime;
		this.adminName = adminName;
	}

	/**
	 * @return the createdTime
	 */
	public String getCreatedTime() {
		return createdTime;
	}

	/**
	 * @param createdTime
	 *            the createdTime to set
	 */
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [createdTime=" + createdTime + ", adminName="
				+ adminName + "]";
	}

}
