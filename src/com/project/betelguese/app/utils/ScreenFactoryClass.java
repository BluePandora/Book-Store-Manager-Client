package com.project.betelguese.app.utils;

import static com.project.betelguese.app.utils.FxmlUrl.logInScreen;
import static com.project.betelguese.app.utils.FxmlUrl.searchScreen;
import static com.project.betelguese.app.utils.FxmlUrl.tabPane;
import static com.project.betelguese.app.utils.FxmlUrl.transactionScreen;
import static com.project.betelguese.app.utils.FxmlUrl.updateScreen;
import static com.project.betelguese.app.utils.FxmlUrl.reportScreen;
import static com.project.betelguese.app.utils.FxmlUrl.barChartScreen;
import static com.project.betelguese.app.utils.FxmlUrl.areaChartScreen;
import static com.project.betelguese.app.utils.FxmlUrl.lineChartScreen;
import static com.project.betelguese.app.utils.FxmlUrl.pieChartScreen;
import static com.project.betelguese.app.utils.FxmlUrl.transactionReportScreen;
import static com.project.betelguese.app.utils.FxmlUrl.addBooksDialog;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.controlsfx.dialog.Dialogs;

import com.project.betelguese.app.screens.AddBooksScreen;
import com.project.betelguese.app.screens.AreaChartScreen;
import com.project.betelguese.app.screens.LineChartScreen;
import com.project.betelguese.app.screens.BarChartScreen;
import com.project.betelguese.app.screens.LogInScreen;
import com.project.betelguese.app.screens.MainScreen;
import com.project.betelguese.app.screens.PieChartScreen;
import com.project.betelguese.app.screens.ReportScreen;
import com.project.betelguese.app.screens.SearchScreen;
import com.project.betelguese.app.screens.TransactionReportScreen;
import com.project.betelguese.app.screens.TransactionScreen;
import com.project.betelguese.app.screens.UpdateScreen;
import com.project.betelguese.appcontrol.ApplicationListener;

public abstract class ScreenFactoryClass {

	public static LogInScreen logInScreenInstance(Stage primaryStage) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(logInScreen);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LogInScreen logInScreen = (LogInScreen) fxmlLoader.getController();
		Scene scene = new Scene(rootPane);
		logInScreen.setRootPane(rootPane);
		logInScreen.setScene(scene);
		logInScreen.setLoader(fxmlLoader);
		logInScreen.setPrimaryStage(primaryStage);
		logInScreen.setWarningDialogs(Dialogs.create().owner(primaryStage)
				.title("Warning!!!"));
		return logInScreen;

	}

	public static MainScreen mainScreenInstance(Stage primaryStage) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(tabPane);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		MainScreen mainScreen = (MainScreen) fxmlLoader.getController();
		Scene scene = new Scene(rootPane);
		mainScreen.setScene(scene);
		mainScreen.setLoader(fxmlLoader);
		mainScreen.setRootPane(rootPane);
		mainScreen.setPrimaryStage(primaryStage);
		return mainScreen;

	}

	public static TransactionScreen transactionScreenInstance(
			Stage primaryStage, ApplicationListener applicationListener) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(transactionScreen);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		TransactionScreen transactionScreen = (TransactionScreen) fxmlLoader
				.getController();
		transactionScreen.setLoader(fxmlLoader);
		transactionScreen.setPrimaryStage(primaryStage);
		transactionScreen.setApplicationListener(applicationListener);
		transactionScreen
				.setAdmin(applicationListener.loadPersonDataFromFile());
		transactionScreen.setRootPane(rootPane);
		transactionScreen.setScene(scene);
		transactionScreen.createTransactionId();
		return transactionScreen;
	}

	public static SearchScreen searchScreenInstance(Stage primaryStage) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(searchScreen);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		SearchScreen searchScreen = (SearchScreen) fxmlLoader.getController();
		searchScreen.setLoader(fxmlLoader);
		searchScreen.setPrimaryStage(primaryStage);
		searchScreen.setRootPane(rootPane);
		searchScreen.setScene(scene);
		searchScreen.setWarningDialogs(Dialogs.create().owner(primaryStage)
				.title("Warning!!!"));
		return searchScreen;
	}

	public static UpdateScreen updateScreenInstance(Stage primaryStage) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(updateScreen);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		UpdateScreen updateScreen = (UpdateScreen) fxmlLoader.getController();
		updateScreen.setLoader(fxmlLoader);
		updateScreen.setPrimaryStage(primaryStage);
		updateScreen.setRootPane(rootPane);
		updateScreen.setScene(scene);
		return updateScreen;
	}

	public static ReportScreen reportScreenInstance(Stage primaryStage) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(reportScreen);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		ReportScreen reportScreen = (ReportScreen) fxmlLoader.getController();
		reportScreen.setLoader(fxmlLoader);
		reportScreen.setPrimaryStage(primaryStage);
		reportScreen.setRootPane(rootPane);
		reportScreen.setScene(scene);
		return reportScreen;
	}

	public static AddBooksScreen addBooksScreenInstance(Stage primaryStage) {

		Stage dialogStage = initDialogStage("Add Books", primaryStage);
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(addBooksDialog);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		dialogStage.setScene(scene);
		AddBooksScreen addBooksScreen = (AddBooksScreen) fxmlLoader
				.getController();
		addBooksScreen.setLoader(fxmlLoader);
		addBooksScreen.setPrimaryStage(primaryStage);
		addBooksScreen.setDialogStage(dialogStage);
		addBooksScreen.setRootPane(rootPane);
		addBooksScreen.setScene(scene);
		return addBooksScreen;
	}

	public static BarChartScreen addBarChartInstance(Stage primaryStage,
			String title) {
		Stage dialogStage = initDialogStage(title, primaryStage);
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(barChartScreen);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		dialogStage.setScene(scene);
		BarChartScreen barChartScreen = (BarChartScreen) fxmlLoader
				.getController();
		barChartScreen.setLoader(fxmlLoader);
		barChartScreen.setPrimaryStage(primaryStage);
		barChartScreen.setDialogStage(dialogStage);
		barChartScreen.setRootPane(rootPane);
		barChartScreen.setScene(scene);
		return barChartScreen;
	}

	public static AreaChartScreen addAreaChartInstance(Stage primaryStage,
			String title) {
		Stage dialogStage = initDialogStage(title, primaryStage);
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(areaChartScreen);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		dialogStage.setScene(scene);
		AreaChartScreen areaChartScreen = (AreaChartScreen) fxmlLoader
				.getController();
		areaChartScreen.setLoader(fxmlLoader);
		areaChartScreen.setPrimaryStage(primaryStage);
		areaChartScreen.setDialogStage(dialogStage);
		areaChartScreen.setRootPane(rootPane);
		areaChartScreen.setScene(scene);
		return areaChartScreen;
	}

	public static LineChartScreen addLineChartInstance(Stage primaryStage,
			String title) {
		Stage dialogStage = initDialogStage(title, primaryStage);
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(lineChartScreen);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		dialogStage.setScene(scene);
		LineChartScreen lineChartScreen = (LineChartScreen) fxmlLoader
				.getController();
		lineChartScreen.setLoader(fxmlLoader);
		lineChartScreen.setPrimaryStage(primaryStage);
		lineChartScreen.setDialogStage(dialogStage);
		lineChartScreen.setRootPane(rootPane);
		lineChartScreen.setScene(scene);
		return lineChartScreen;
	}

	public static PieChartScreen addPieChartInstance(Stage primaryStage,
			String title) {
		Stage dialogStage = initDialogStage(title, primaryStage);
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(pieChartScreen);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		dialogStage.setScene(scene);
		PieChartScreen pieChartScreen = (PieChartScreen) fxmlLoader
				.getController();
		pieChartScreen.setLoader(fxmlLoader);
		pieChartScreen.setPrimaryStage(primaryStage);
		pieChartScreen.setDialogStage(dialogStage);
		pieChartScreen.setRootPane(rootPane);
		pieChartScreen.setScene(scene);
		return pieChartScreen;
	}

	public static TransactionReportScreen addTransactionReportScreenInstance(
			Stage primaryStage, String title) {
		Stage dialogStage = initDialogStage(title, primaryStage);
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(transactionReportScreen);
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		dialogStage.setScene(scene);
		TransactionReportScreen transactionReportScreen = (TransactionReportScreen) fxmlLoader
				.getController();
		transactionReportScreen.setLoader(fxmlLoader);
		transactionReportScreen.setPrimaryStage(primaryStage);
		transactionReportScreen.setDialogStage(dialogStage);
		transactionReportScreen.setRootPane(rootPane);
		transactionReportScreen.setScene(scene);
		return transactionReportScreen;
	}

	private static Stage initDialogStage(String title, Stage ownerStage) {
		Stage dialogStage;
		dialogStage = new Stage();
		dialogStage.setTitle(title);
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.setResizable(false);
		if (ownerStage != null)
			dialogStage.initOwner(ownerStage);
		return dialogStage;
	}

}
