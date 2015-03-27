package com.project.betelguese.app.utils;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.project.betelguese.app.item.Admin;

/**
 * Helper class to wrap a list of persons. This is used for saving the list of
 * persons to XML.
 * 
 * @author Marco Jakob
 */
@XmlRootElement(name = "admins")
public class AdministratorWrapper {

	private List<Admin> admins;

	@XmlElement(name = "admin")
	public List<Admin> getAdmins() {
		return admins;
	}

	public void setAdmin(List<Admin> admin) {
		this.admins = admin;
	}
}