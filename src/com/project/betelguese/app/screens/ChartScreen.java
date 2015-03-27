package com.project.betelguese.app.screens;

import java.util.List;

import com.project.betelguese.utils.items.DayReport;
import com.project.betelguese.utils.items.MonthReport;
import com.project.betelguese.utils.items.YearReport;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class ChartScreen extends Screen {

	public static final String BAR_CHART = "Bar Chart";
	public static final String AREA_CHART = "Area Chart";
	public static final String PIE_CHART = "Pie Chart";
	public static final String LINE_CHART = "Line Chart";
	private Stage dialogStage;

	public ChartScreen() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Scene getScreenLayout() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the dialogStage
	 */
	public Stage getDialogStage() {
		return dialogStage;
	}

	/**
	 * @param dialogStage
	 *            the dialogStage to set
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public abstract void setYearlyData(List<YearReport> reports);
	public abstract void setMonthlyData(List<MonthReport> reports);
	public abstract void setDailyData(List<DayReport> reports);
	public void showAndWait() {
		dialogStage.showAndWait();
	}

	
}
