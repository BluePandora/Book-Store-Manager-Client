package com.project.betelguese.appcontrol;

import com.project.betelguese.app.item.Admin;

public interface ApplicationListener {

	public static final int LOG_IN_SCENE = 0;
	public static final int MAIN_SCENE = 1;

	public void changeScene(int tag);

	public void savePersonDataToFile(Admin admin);

	public Admin loadPersonDataFromFile();

}
