package com.project.betelguese.utils.items;

public class ChangePassword {
	private String oldPassword;
	private String newPassword;

	public ChangePassword() {
		this(null, null);
	}

	/**
	 * @param oldPassword
	 * @param newPassword
	 */
	public ChangePassword(String oldPassword, String newPassword) {
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	/**
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword
	 *            the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword
	 *            the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChangePassword [oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + "]";
	}

}
