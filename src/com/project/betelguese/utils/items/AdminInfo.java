package com.project.betelguese.utils.items;

public class AdminInfo {

	private String adminId;
	private String userName;
	private String adminName;
	private String administratorLevel;

	public AdminInfo() {

	}

	/**
	 * @param adminId
	 * @param userName
	 * @param adminName
	 * @param administratorLevel
	 */
	public AdminInfo(String adminId, String userName, String adminName,
			String administratorLevel) {
		this.adminId = adminId;
		this.userName = userName;
		this.adminName = adminName;
		this.administratorLevel = administratorLevel;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdministratorLevel() {
		return administratorLevel;
	}

	public void setAdministratorLevel(String administratorLevel) {
		this.administratorLevel = administratorLevel;
	}

}
