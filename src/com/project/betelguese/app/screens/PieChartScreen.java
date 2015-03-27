package com.project.betelguese.app.screens;

import java.util.List;

import com.project.betelguese.utils.items.DayReport;
import com.project.betelguese.utils.items.MonthReport;
import com.project.betelguese.utils.items.YearReport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;

public class PieChartScreen extends ChartScreen {

	@FXML
	private PieChart pieChart;

	private ObservableList<Data> values = FXCollections.observableArrayList();

	public PieChartScreen() {
	}

	/**
	 * @return the values
	 */
	public ObservableList<Data> getValues() {
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public void setValues(ObservableList<Data> values) {
		this.values = values;
	}

	@FXML
	private void initialize() {
		pieChart.setData(values);
	}

	@Override
	public void setYearlyData(List<YearReport> reports) {
		for (YearReport report : reports) {
			String label = report.getValue() + " Taka(" + report.getYear()
					+ ")";
			Data data = new Data(label, Double.parseDouble(report.getValue()));
			values.add(data);

		}
	}

	@Override
	public void setMonthlyData(List<MonthReport> reports) {
		for (MonthReport report : reports) {
			String label = report.getValue() + " Taka(" + report.getMonth()
					+ ")";
			Data data = new Data(label, Double.parseDouble(report.getValue()));
			values.add(data);

		}
	}

	@Override
	public void setDailyData(List<DayReport> reports) {
		for (DayReport report : reports) {
			String label = report.getValue() + " Taka(" + report.getDay() + ")";
			Data data = new Data(label, Double.parseDouble(report.getValue()));
			values.add(data);

		}
	}

	@Override
	public Scene getScreenLayout() {
		return getScene();
	}

}
