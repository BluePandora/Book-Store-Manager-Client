package com.project.betelguese.app.utils;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import static com.project.betelguese.app.utils.FxmlUrl.progressDialog;

import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

public class DialogBuilder implements Initializable {

	private Dialog progressDialogs;
	Dialogs otherDialogs;
	private FXMLLoader loader;
	AnchorPane anchorPane;
	private Stage parentStage;
	@FXML
	private Text progressText;

	public DialogBuilder() {
	}

	public static DialogBuilder createProgressDialog(Stage primaryStage) {
		DialogBuilder dialogBuilder = null;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(progressDialog);
			AnchorPane anchorPane = (AnchorPane) loader.load();
			dialogBuilder = (DialogBuilder) loader.getController();
			Dialog progressDialogs = new Dialog(primaryStage, "");
			progressDialogs.setResizable(false);
			progressDialogs.setClosable(false);
			progressDialogs.setContent(anchorPane);
			dialogBuilder.setProgressDialogs(progressDialogs);
			dialogBuilder.setAnchorPane(anchorPane);
			dialogBuilder.setLoader(loader);
			dialogBuilder.setParentStage(primaryStage);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return dialogBuilder;
	}

	public void show() {
		progressDialogs.show();
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
	 * @return the anchorPane
	 */
	public AnchorPane getAnchorPane() {
		return anchorPane;
	}

	/**
	 * @param anchorPane
	 *            the anchorPane to set
	 */
	public void setAnchorPane(AnchorPane anchorPane) {
		this.anchorPane = anchorPane;
	}

	/**
	 * @return the parentStage
	 */
	public Stage getParentStage() {
		return parentStage;
	}

	/**
	 * @param parentStage
	 *            the parentStage to set
	 */
	public void setParentStage(Stage parentStage) {
		this.parentStage = parentStage;
	}

	public void hide() {
		progressDialogs.hide();
	}

	/**
	 * @return the progressDialogs
	 */
	public Dialog getProgressDialogs() {
		return progressDialogs;
	}

	/**
	 * @param progressDialogs
	 *            the progressDialogs to set
	 */
	public void setProgressDialogs(Dialog progressDialogs) {
		this.progressDialogs = progressDialogs;
	}

	public Dialog getDialogView() {
		return progressDialogs;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void setMessage(String message) {
		progressText.setText(message);
	}
}
