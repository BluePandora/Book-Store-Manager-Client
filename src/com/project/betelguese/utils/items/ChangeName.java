package com.project.betelguese.utils.items;

public class ChangeName {
	private String firstName;
	private String lastName;

	public ChangeName() {
		this(null, null);
	}

	/**
	 * @param firstName
	 * @param lastName
	 */
	public ChangeName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChangeName [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}

}
