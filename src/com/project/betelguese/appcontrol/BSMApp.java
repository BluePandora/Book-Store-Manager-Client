package com.project.betelguese.appcontrol;

import com.project.betelguese.app.item.Admin;
import com.project.betelguese.app.screens.LogInScreen;
import com.project.betelguese.app.screens.MainScreen;
import com.project.betelguese.app.utils.ScreenFactoryClass;

import javafx.application.Application;
import javafx.stage.Stage;

public class BSMApp extends Application implements ApplicationListener {

	public Stage primaryStage;
	private LogInScreen logInScreen;
	private MainScreen mainScreen;

	public Admin admin;

	public BSMApp() {
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Book Store Manager");
		changeScene(LOG_IN_SCENE);
		this.primaryStage.setScene(logInScreen.getScreenLayout());
		this.primaryStage.setResizable(false);
		this.primaryStage.setWidth(800);
		this.primaryStage.setHeight(625);
		this.primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void changeScene(final int tag) {
		switch (tag) {
		case LOG_IN_SCENE:
			logInScreen = ScreenFactoryClass.logInScreenInstance(primaryStage);
			logInScreen.setApplicationListener(this);
			primaryStage.setScene(logInScreen.getScreenLayout());
			break;
		case MAIN_SCENE:
			mainScreen = ScreenFactoryClass.mainScreenInstance(primaryStage);
			mainScreen.setApplicationListener(this);
			mainScreen.createChildrenNode();
			primaryStage.setScene(mainScreen.getScreenLayout());
			break;
		default:
			break;
		}
	}

	public void savePersonDataToFile(Admin admin) {
		this.admin = admin;
	}

	public Admin loadPersonDataFromFile() {
		return admin;
	}
}
