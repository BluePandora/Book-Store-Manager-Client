package com.project.betelguese.utils.json.builders;

import com.project.betelguese.utils.items.AdminInfo;

public class LogInMessage extends ServiceMessage {

	private AdminInfo profile;

	public LogInMessage() {
		this(null);
	}

	public LogInMessage(AdminInfo profile) {
		this(0, null, null, profile);
	}

	public LogInMessage(int done, String message, String requestName,
			AdminInfo profile) {
		super(done, message, requestName);
		this.profile = profile;
	}

	public AdminInfo getProfile() {
		return profile;
	}

	public void setProfile(AdminInfo profile) {
		this.profile = profile;
	}
}
