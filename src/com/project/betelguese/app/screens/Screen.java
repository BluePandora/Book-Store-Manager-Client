package com.project.betelguese.app.screens;

//import static com.project.betelguese.app.utils.FxmlUrl.logInScreen;

import java.io.IOException;

import com.project.betelguese.appcontrol.ApplicationListener;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

abstract class Screen {
	private AnchorPane rootPane;
	private FXMLLoader loader;
	private Scene scene;
	private Stage primaryStage;
	private ApplicationListener applicationListener;

	public abstract Scene getScreenLayout();

	public <T> T findViewbyId(String locationId) throws IOException {
		loader = new FXMLLoader();
		// loader.setLocation(logInScreen);
		return loader.load();
	}

	/**
	 * @return the rootPane
	 */
	public AnchorPane getRootPane() {
		return rootPane;
	}

	/**
	 * @param rootPane
	 *            the rootPane to set
	 */
	public void setRootPane(AnchorPane rootPane) {
		this.rootPane = rootPane;
	}

	/**
	 * @return the loader
	 */
	public FXMLLoader getLoader() {
		return loader;
	}

	/**
	 * @param loader
	 *            the loader to set
	 */
	public void setLoader(FXMLLoader loader) {
		this.loader = loader;
	}

	/**
	 * @return the scene
	 */
	public Scene getScene() {
		return scene;
	}

	/**
	 * @param scene
	 *            the scene to set
	 */
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	/**
	 * @return the primaryStage
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	/**
	 * @param primaryStage
	 *            the primaryStage to set
	 */
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	/**
	 * @return the applicationListener
	 */
	public ApplicationListener getApplicationListener() {
		return applicationListener;
	}

	/**
	 * @param applicationListener
	 *            the applicationListener to set
	 */
	public void setApplicationListener(ApplicationListener applicationListener) {
		this.applicationListener = applicationListener;
	}

}
