package com.project.betelguese.utils.items;

public class NewUser {

	private String fristName;
	private String lastName;
	private String password;
	private String administratorLevel;

	public NewUser() {
		this(null, null, null, null);
	}

	/**
	 * @param fristName
	 * @param lastName
	 * @param password
	 * @param administratorLevel
	 */
	public NewUser(String fristName, String lastName, String password,
			String administratorLevel) {
		this.fristName = fristName;
		this.lastName = lastName;
		this.password = password;
		this.administratorLevel = administratorLevel;
	}

	/**
	 * @return the fristName
	 */
	public String getFristName() {
		return fristName;
	}

	/**
	 * @param fristName
	 *            the fristName to set
	 */
	public void setFristName(String fristName) {
		this.fristName = fristName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the administratorLevel
	 */
	public String getAdministratorLevel() {
		return administratorLevel;
	}

	/**
	 * @param administratorLevel
	 *            the administratorLevel to set
	 */
	public void setAdministratorLevel(String administratorLevel) {
		this.administratorLevel = administratorLevel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NewUser [fristName=" + fristName + ", lastName=" + lastName
				+ ", password=" + password + ", administratorLevel="
				+ administratorLevel + "]";
	}

}
