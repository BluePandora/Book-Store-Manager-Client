package com.project.betelguese.app.utils;

import static com.project.betelguese.app.utils.FxmlUrl.settingsDialogScreen;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.betelguese.app.item.Admin;
import com.project.betelguese.server.connection.utils.Response;
import com.project.betelguese.server.connection.utils.ServerRequest;
import com.project.betelguese.server.connection.utils.URLHelper;
import com.project.betelguese.server.connection.utils.Response.ErrorListener;
import com.project.betelguese.server.connection.utils.Response.Listener;
import com.project.betelguese.utils.items.ChangeName;
import com.project.betelguese.utils.items.ChangePassword;
import com.project.betelguese.utils.items.SettingsItem;

public class SettingsDialog implements Initializable, URLHelper {
	private Dialog settingsDialog;
	private FXMLLoader loader;
	private AnchorPane anchorPane;
	private Stage parentStage;
	private Dialogs otherDialogs;
	private Admin admin;
	private SettingsItem settingsItem;
	@FXML
	private ListView<String> optionList;

	@FXML
	private Pane newUserPane;
	@FXML
	private TextField newUserFirstName;
	@FXML
	private TextField newUserLastName;
	@FXML
	private TextField newUsername;
	@FXML
	private PasswordField newUserPassword;
	@FXML
	private ComboBox<String> newUserRoll;
	@FXML
	private Button newUserCreateButton;

	@FXML
	private Pane changeNamePane;
	@FXML
	private TextField changeFirstName;
	@FXML
	private TextField changeLastName;
	@FXML
	private Button changeNameButton;

	@FXML
	private Pane changePasswordPane;
	@FXML
	private PasswordField oldPassword;
	@FXML
	private PasswordField newPassword;
	@FXML
	private PasswordField confirmPassword;
	@FXML
	private Button changePasswordButton;

	private boolean nameChange;

	public static SettingsDialog createSettingsDialog(Stage primaryStage,
			Admin admin) {
		SettingsDialog dialog = null;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(settingsDialogScreen);
			AnchorPane anchorPane = (AnchorPane) loader.load();
			dialog = (SettingsDialog) loader.getController();
			Dialog settingsDialog = new Dialog(primaryStage, "Settings");
			settingsDialog.setResizable(false);
			settingsDialog.setClosable(true);
			settingsDialog.setContent(anchorPane);
			dialog.setSettingsDialog(settingsDialog);
			dialog.setAnchorPane(anchorPane);
			dialog.setLoader(loader);
			dialog.setAdmin(admin);
			dialog.setParentStage(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dialog;
	}

	/**
	 * @return the settingsDialog
	 */
	public Dialog getSettingsDialog() {
		return settingsDialog;
	}

	/**
	 * @param settingsDialog
	 *            the settingsDialog to set
	 */
	public void setSettingsDialog(Dialog settingsDialog) {
		this.settingsDialog = settingsDialog;
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

	/**
	 * @return the otherDialogs
	 */
	public Dialogs getOtherDialogs() {
		return otherDialogs;
	}

	/**
	 * @param otherDialogs
	 *            the otherDialogs to set
	 */
	public void setOtherDialogs(Dialogs otherDialogs) {
		this.otherDialogs = otherDialogs;
	}

	public void show() {
		settingsDialog.show();
	}

	public void hide() {
		settingsDialog.hide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		optionList
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> observeListView(
								observable, oldValue, newValue));
	}

	public void loadData() {
		if (!admin.getAdminLevel().getValue().equals("admin")) {
			if (optionList.getItems().get(2).equals("Create new User")) {
				optionList.getItems().remove(2);
			}
		}
	}

	@FXML
	public void changePasswordAction(ActionEvent event) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("requestName", "settingsRequest");
		params.put("serviceKey", "changePassword");
		ChangePassword changePassword = new ChangePassword();
		changePassword.setOldPassword(oldPassword.getText());
		changePassword.setNewPassword(newPassword.getText());
		SettingsItem settingsItem = new SettingsItem(admin.getAdminId()
				.getValue(), changePassword);
		Gson gson = new GsonBuilder().create();
		params.put("serviceValue", gson.toJson(settingsItem));
		ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
				Response.POST, URL, params, new Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject s) {
						long done = (long) s.get("done");
						if (done == 0) {
							Dialogs.create().masthead("Wrong old Password.")
									.showError();
						} else {
							Dialogs.create()
									.masthead("Password change Successfull.")
									.showConfirm();
						}
					}
				}, new ErrorListener() {
					@Override
					public void onErrorResponse(Exception exception) {

					}
				});
		serverRequest.start();
	}

	@FXML
	public void changeNameAction(ActionEvent event) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("requestName", "settingsRequest");
		params.put("serviceKey", "changeUsername");
		ChangeName changeName = new ChangeName();
		changeName.setFirstName(changeFirstName.getText());
		changeName.setLastName(changeLastName.getText());
		SettingsItem settingsItem = new SettingsItem(admin.getAdminId()
				.getValue(), changeName);
		Gson gson = new GsonBuilder().create();
		params.put("serviceValue", gson.toJson(settingsItem));
		ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
				Response.POST, URL, params, new Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject s) {
						Dialogs.create().masthead("Name change Successfull.")
								.showConfirm();
						admin.getAdminName().setValue(
								changeFirstName.getText() + " "
										+ changeLastName.getText());
						nameChange = true;
						hide();
					}
				}, new ErrorListener() {
					@Override
					public void onErrorResponse(Exception exception) {

					}
				});
		serverRequest.start();

	}

	@FXML
	public void newUserCreateAction(ActionEvent event) {
		HashMap<String, String> params = new HashMap<String, String>();
		ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
				Response.POST, URL, params, new Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject s) {
					}
				}, new ErrorListener() {
					@Override
					public void onErrorResponse(Exception exception) {

					}
				});
		serverRequest.start();
	}

	private Object observeListView(
			ObservableValue<? extends String> observable, String oldValue,
			String newValue) {
		System.out.println(settingsDialog.getHeight() + " "
				+ settingsDialog.getWidth());
		if (newValue != null) {
			if (newValue.equals("Change Password")) {
				changePasswordPane.setVisible(true);
				changeNamePane.setVisible(false);
				newUserPane.setVisible(false);
			} else if (newValue.equals("Change Name")) {
				changePasswordPane.setVisible(false);
				changeNamePane.setVisible(true);
				newUserPane.setVisible(false);
			} else if (newValue.equals("Create new User")) {
				changePasswordPane.setVisible(false);
				changeNamePane.setVisible(false);
				newUserPane.setVisible(true);
			} else {
				changePasswordPane.setVisible(false);
				changeNamePane.setVisible(false);
				newUserPane.setVisible(false);
			}
		}

		return null;
	}

	/**
	 * @return the admin
	 */
	public Admin getAdmin() {
		return admin;
	}

	/**
	 * @param admin
	 *            the admin to set
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	/**
	 * @return the nameChange
	 */
	public boolean isNameChange() {
		return nameChange;
	}

	/**
	 * @param nameChange
	 *            the nameChange to set
	 */
	public void setNameChange(boolean nameChange) {
		this.nameChange = nameChange;
	}

}
