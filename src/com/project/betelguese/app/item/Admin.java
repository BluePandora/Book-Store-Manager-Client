package com.project.betelguese.app.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Admin {

	private final StringProperty adminName;
	private final StringProperty adminLevel;
	private final StringProperty adminId;

	public Admin() {
		this(null, null, null);
	}

	public Admin(String adminName, String adminLevel, String adminId) {
		this.adminId = new SimpleStringProperty(adminId);
		this.adminName = new SimpleStringProperty(adminName);
		this.adminLevel = new SimpleStringProperty(adminLevel);
	}

	public StringProperty getAdminName() {
		return adminName;
	}

	public StringProperty getAdminLevel() {
		return adminLevel;
	}

	public StringProperty getAdminId() {
		return adminId;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName.getValue() + ", adminLevel="
				+ adminLevel.getValue() + ", adminId=" + adminId.getValue()
				+ "]";
	}

}
