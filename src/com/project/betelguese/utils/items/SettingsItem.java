package com.project.betelguese.utils.items;

public class SettingsItem {

	private String adminId;
	private NewUser newUser;
	private ChangePassword changePassword;
	private ChangeName changeName;

	public SettingsItem() {
		this(null, null, null, null);
	}

	public SettingsItem(String adminId, NewUser newUser) {
		this(adminId, newUser, null, null);
	}

	public SettingsItem(String adminId, ChangePassword changePassword) {
		this(adminId, null, changePassword, null);
	}

	public SettingsItem(String adminId, ChangeName changeName) {
		this(adminId, null, null, changeName);
	}

	/**
	 * @param newUser
	 * @param changePassword
	 * @param changeName
	 */
	public SettingsItem(String adminId, NewUser newUser,
			ChangePassword changePassword, ChangeName changeName) {
		this.adminId = adminId;
		this.newUser = newUser;
		this.changePassword = changePassword;
		this.changeName = changeName;
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
	 * @return the newUser
	 */
	public NewUser getNewUser() {
		return newUser;
	}

	/**
	 * @param newUser
	 *            the newUser to set
	 */
	public void setNewUser(NewUser newUser) {
		this.newUser = newUser;
	}

	/**
	 * @return the changePassword
	 */
	public ChangePassword getChangePassword() {
		return changePassword;
	}

	/**
	 * @param changePassword
	 *            the changePassword to set
	 */
	public void setChangePassword(ChangePassword changePassword) {
		this.changePassword = changePassword;
	}

	/**
	 * @return the changeName
	 */
	public ChangeName getChangeName() {
		return changeName;
	}

	/**
	 * @param changeName
	 *            the changeName to set
	 */
	public void setChangeName(ChangeName changeName) {
		this.changeName = changeName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SettingsItem [newUser=" + newUser + ", changePassword="
				+ changePassword + ", changeName=" + changeName + "]";
	}

}
