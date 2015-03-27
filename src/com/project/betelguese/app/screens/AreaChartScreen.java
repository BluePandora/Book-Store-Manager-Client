package com.project.betelguese.app.screens;

import java.util.List;

import com.project.betelguese.utils.items.DayReport;
import com.project.betelguese.utils.items.MonthReport;
import com.project.betelguese.utils.items.YearReport;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

public class AreaChartScreen extends ChartScreen {

	@FXML
	private AreaChart<String, Integer> areaChart;

	@FXML
	private CategoryAxis xAxis;

	private ObservableList<String> values = FXCollections.observableArrayList();

	private XYChart.Series<String, Integer> series;

	public AreaChartScreen() {
	}

	/**
	 * @return the values
	 */
	public ObservableList<String> getValues() {
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public void setValues(ObservableList<String> values) {
		this.values = values;
	}

	@FXML
	private void initialize() {
		xAxis.setCategories(values);
	}

	@Override
	public void setYearlyData(List<YearReport> reports) {
		series = new XYChart.Series<>();
		for (YearReport report : reports) {
			series.getData().add(
					new XYChart.Data<>(report.getYear(), new Integer(report
							.getValue())));
			values.add(report.getYear());

		}
		xAxis.setLabel("Year");
		areaChart.getData().add(series);
	}

	@Override
	public void setMonthlyData(List<MonthReport> reports) {
		series = new XYChart.Series<>();
		for (MonthReport report : reports) {
			series.getData().add(
					new XYChart.Data<>(report.getMonth(), new Integer(report
							.getValue())));
			values.add(report.getMonth());

		}
		xAxis.setLabel("Month");
		areaChart.getData().add(series);
	}

	@Override
	public void setDailyData(List<DayReport> reports) {
		series = new XYChart.Series<>();
		for (DayReport report : reports) {
			series.getData().add(
					new XYChart.Data<>(report.getDay(), new Integer(report
							.getValue())));
			values.add(report.getDay());

		}
		xAxis.setLabel("Month");
		areaChart.getData().add(series);
	}

	@Override
	public Scene getScreenLayout() {
		return getScene();
	}

}
