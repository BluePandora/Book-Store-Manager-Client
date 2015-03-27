package com.project.betelguese.app.screens;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import org.controlsfx.dialog.Dialogs;
import org.json.simple.JSONObject;

import com.project.betelguese.app.controller.LogInController;
import com.project.betelguese.app.item.Admin;
import com.project.betelguese.app.utils.DialogBuilder;
import com.project.betelguese.appcontrol.ApplicationListener;
import com.project.betelguese.server.connection.utils.Response;
import com.project.betelguese.server.connection.utils.Response.ErrorListener;
import com.project.betelguese.server.connection.utils.ServerRequest;
import com.project.betelguese.server.connection.utils.URLHelper;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;

public class LogInScreen extends Screen implements LogInController, URLHelper,
		Response.Listener<JSONObject>, ErrorListener {

	private static final int LOGIN_FAILED = -1;
	private static final int LOGIN_ERROR = 0;
	private static final int LOGIN_SUCCESS = 1;

	@FXML
	private AnchorPane mainPane;
	@FXML
	private TextField userNameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button logInButton;

	private Dialogs warningDialogs;
	private Admin admin;
	DialogBuilder progressDialog;

	public LogInScreen() {
	}

	public Scene getScreenLayout() {
		return getScene();
	}

	@FXML
	public void handleLogInButton(ActionEvent event) {
		if (userNameField.getText().isEmpty()) {
			warningDialogs.message("User Name can't be empty.").showWarning();
		} else if (passwordField.getText().isEmpty()) {
			warningDialogs.message("Password Field can't be empty.")
					.showWarning();
		} else {
			logInRequest();
			// captureScreenshot();
		}
	}

	private void logInRequest() {
		progressDialog = DialogBuilder.createProgressDialog(getPrimaryStage());
		String requestURL = URL;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("requestName", "logInRequest");
		params.put(USERNAME_TAG, userNameField.getText());
		params.put("password", passwordField.getText());
		params.put(REQUEST_NAME, LOGIN_REQUEST);
		System.out.println(userNameField.getText() + " "
				+ passwordField.getText());
		ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
				Response.POST, requestURL, params, this, this);
		serverRequest.start();
		progressDialog.show();

	}

	@Override
	public void onResponse(JSONObject response) {
		int reg;
		System.out.println(response.toJSONString());
		reg = (int) ((long) response.get("done"));
		switch (reg) {
		case LOGIN_FAILED:
			warningDialogs.message("Wrong user name or password.")
					.showWarning();
			break;
		case LOGIN_ERROR:
			warningDialogs.message(
					"Something went wrong.Please try again later.")
					.showWarning();
			break;
		case LOGIN_SUCCESS:
			if (getApplicationListener() != null) {
				// {"profile":[{"userName":"tuman_hacker","adminName":"Sajid Shahriar",
				// "administratorLevel":"admin"}],"done":1,
				// "requestName":"logInRequest",
				// "message":"logInRequest  was processed by the server successfully."}
				JSONObject profile = (JSONObject) response.get("profile");
				admin = new Admin((String) profile.get("adminName"),
						(String) profile.get("administratorLevel"),
						(String) profile.get("adminId"));
				getApplicationListener().savePersonDataToFile(admin);
				getApplicationListener().changeScene(
						ApplicationListener.MAIN_SCENE);
				userNameField.setText("");
				passwordField.setText("");
			}
			break;

		default:
			break;
		}
		System.out.println(response.toString());
		progressDialog.hide();
	}

	@Override
	public void onErrorResponse(Exception exception) {
		if (exception instanceof ConnectException) {
			warningDialogs.message("Unable to connect to server.")
					.showWarning();
		} else if (exception instanceof UnknownHostException) {
			warningDialogs.message(
					"No Internet Connection.Check the Internet connection.")
					.showWarning();
		} else {
			System.out.println(exception.getMessage());
		}
		try {
			progressDialog.hide();
		} catch (Exception e) {
			Dialogs.create().owner(getPrimaryStage()).message("Error")
					.showExceptionInNewWindow(e);
		}
	}

	public Dialogs getWarningDialogs() {
		return warningDialogs;
	}

	public void setWarningDialogs(Dialogs warningDialogs) {
		this.warningDialogs = warningDialogs;
	}

	void captureScreenshot() {
		SnapshotParameters params = new SnapshotParameters();
		WritableImage image = logInButton.snapshot(params, null);
		File file = new File("D:\\image.png");
		BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
		try {
			ImageIO.write(bImage, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void initialize() {

	}
}