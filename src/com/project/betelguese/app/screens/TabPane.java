package com.project.betelguese.app.screens;

import java.awt.MenuItem;

import com.project.betelguese.app.utils.SettingsDialog;
import com.project.betelguese.appcontrol.ApplicationListener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;

public abstract class TabPane extends Screen {

	@FXML
	private ToggleButton searchTabButton;
	@FXML
	private ToggleButton transactionTabButton;
	@FXML
	private ToggleButton updateTabButton;
	@FXML
	private ToggleButton reportTabButton;

	@FXML
	private AnchorPane searchTabScreen;
	@FXML
	private AnchorPane transactionTabScreen;

	@FXML
	private MenuItem menuItem;

	protected static String selectedTab = "searchTabButton";
	protected static final String SEARCH_BUTTON_ID = "searchTabButton";
	protected static final String TRANSACTION_BUTTON_ID = "transactionTabButton";
	protected static final String REPORT_BUTTON_ID = "reportTabButton";
	protected static final String UPDATE_BUTTON_ID = "updateTabButton";

	public TabPane() {
	}

	@Override
	public Scene getScreenLayout() {
		return getScene();
	}

	public ToggleButton getSearchTabButton() {
		return searchTabButton;
	}

	public void setSearchTabButton(ToggleButton searchTabButton) {
		this.searchTabButton = searchTabButton;
	}

	public ToggleButton getTransactionTabButton() {
		return transactionTabButton;
	}

	public void setTransactionTabButton(ToggleButton transactionTabButton) {
		this.transactionTabButton = transactionTabButton;
	}

	public ToggleButton getUpdateTabButton() {
		return updateTabButton;
	}

	public void setUpdateTabButton(ToggleButton updateTabButton) {
		this.updateTabButton = updateTabButton;
	}

	public ToggleButton getReportTabButton() {
		return reportTabButton;
	}

	public void setReportTabButton(ToggleButton reportTabButton) {
		this.reportTabButton = reportTabButton;
	}

	protected abstract void toggleTabButtonSelection(final String ID);

	protected abstract boolean changeTo(final String screenTag);

	protected abstract boolean remove(final String screenTag);

	public AnchorPane getSearchTabScreen() {
		return searchTabScreen;
	}

	public void setSearchTabScreen(AnchorPane searchTabScreen) {
		this.searchTabScreen = searchTabScreen;
	}

	public AnchorPane getTransactionTabScreen() {
		return transactionTabScreen;
	}

	@FXML
	private void handleLogOut(ActionEvent actionEvent) {
		if (getApplicationListener() != null) {
			getApplicationListener().changeScene(
					ApplicationListener.LOG_IN_SCENE);
		}
	}

	@FXML
	private void handleSettings(ActionEvent actionEvent) {
		if (getApplicationListener() != null) {
			SettingsDialog settingsDialog = SettingsDialog
					.createSettingsDialog(getPrimaryStage(),
							getApplicationListener().loadPersonDataFromFile());
			settingsDialog.loadData();
			settingsDialog.show();
			if (settingsDialog.isNameChange()) {
				changeName(settingsDialog.getAdmin().getAdminName().getValue());
			}
		}
	}

	public abstract void changeName(String newName);

	public void setTransactionTabScreen(AnchorPane transactionTabScreen) {
		this.transactionTabScreen = transactionTabScreen;
	}

}
