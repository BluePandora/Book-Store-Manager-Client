package com.project.betelguese.app.screens;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.project.betelguese.app.utils.ScreenFactoryClass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.StackPane;

public class MainScreen extends TabPane implements Initializable {

	private HashMap<String, Node> screens;
	private SearchScreen searchScreen;
	private TransactionScreen transactionScreen;
	private UpdateScreen updateScreen;
	private ReportScreen reportScreen;

	@FXML
	private StackPane screenHolderPane;

	public MainScreen() {
		super();
	}

	@FXML
	private void handleTabButton(ActionEvent actionEvent) {
		final ToggleButton pressedButton = (ToggleButton) actionEvent
				.getSource();
		final String ID = ((ToggleButton) actionEvent.getSource()).getId();
		if (ID.equals(selectedTab)) {
			pressedButton.setSelected(true);
		} else {
			toggleTabButtonSelection(selectedTab);
			remove(selectedTab);
			selectedTab = ID;
			changeTo(selectedTab);
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	public void createChildrenNode() {
		searchScreen = ScreenFactoryClass
				.searchScreenInstance(getPrimaryStage());
		searchScreen.setApplicationListener(getApplicationListener());
		transactionScreen = ScreenFactoryClass.transactionScreenInstance(
				getPrimaryStage(), getApplicationListener());
		updateScreen = ScreenFactoryClass
				.updateScreenInstance(getPrimaryStage());
		updateScreen.setApplicationListener(getApplicationListener());
		reportScreen = ScreenFactoryClass
				.reportScreenInstance(getPrimaryStage());
		reportScreen.setApplicationListener(getApplicationListener());

		screens = new HashMap<String, Node>();
		screens.put(SEARCH_BUTTON_ID, searchScreen.getScreenLayout().getRoot());
		screens.put(TRANSACTION_BUTTON_ID, transactionScreen.getScreenLayout()
				.getRoot());
		screens.put(UPDATE_BUTTON_ID, updateScreen.getScreenLayout().getRoot());
		screens.put(REPORT_BUTTON_ID, reportScreen.getScreenLayout().getRoot());
		screenHolderPane.getChildren().add(screens.get(SEARCH_BUTTON_ID));
	}

	@Override
	protected void toggleTabButtonSelection(final String ID) {
		switch (ID) {
		case SEARCH_BUTTON_ID:
			getSearchTabButton().setSelected(false);
			break;
		case TRANSACTION_BUTTON_ID:
			getTransactionTabButton().setSelected(false);
			break;
		case UPDATE_BUTTON_ID:
			getUpdateTabButton().setSelected(false);
			break;
		case REPORT_BUTTON_ID:
			getReportTabButton().setSelected(false);
			break;
		default:
			break;
		}
	}

	@Override
	public void changeName(String newName) {
		transactionScreen.setAdminName(newName);
	}

	@Override
	protected boolean remove(String screenTag) {
		return screens.get(screenTag) != null ? screenHolderPane.getChildren()
				.remove(screens.get(screenTag)) : false;
	}

	@Override
	protected boolean changeTo(final String screenTag) {
		return screens.get(screenTag) != null ? screenHolderPane.getChildren()
				.add(screens.get(screenTag)) : false;

	}
}
