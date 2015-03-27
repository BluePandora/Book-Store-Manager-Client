package com.project.betelguese.app.screens;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.betelguese.app.utils.ScreenFactoryClass;
import com.project.betelguese.server.connection.utils.Response;
import com.project.betelguese.server.connection.utils.Response.ErrorListener;
import com.project.betelguese.server.connection.utils.Response.Listener;

import java.util.HashMap;

import org.controlsfx.dialog.Dialogs;
import org.json.simple.JSONObject;

import com.project.betelguese.server.connection.utils.ServerRequest;
import com.project.betelguese.server.connection.utils.URLHelper;
import com.project.betelguese.utils.items.ReportServiceValue;
import com.project.betelguese.utils.items.TransactionReport;
import com.project.betelguese.utils.json.builders.DayReportMessage;
import com.project.betelguese.utils.json.builders.MonthReportMessage;
import com.project.betelguese.utils.json.builders.TransactionReportMessage;
import com.project.betelguese.utils.json.builders.YearReportMessage;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

public class ReportScreen extends Screen implements URLHelper {

	@FXML
	private ComboBox<String> chartOption;
	@FXML
	private ComboBox<String> yearOption;

	@FXML
	private ComboBox<String> monthOption;
	@FXML
	private ComboBox<String> reportOption;

	@FXML
	private Pane yearPane;
	@FXML
	private Pane monthPane;
	@FXML
	private Pane chartPane;

	public ReportScreen() {
	}

	@Override
	public Scene getScreenLayout() {
		return getScene();
	}

	@FXML
	public void handleShowingReport() {
		ReportServiceValue reportServiceValue = new ReportServiceValue();
		HashMap<String, String> params = new HashMap<String, String>();
		Gson gson = new GsonBuilder().create();
		ServerRequest<JSONObject> serverRequest = null;
		if (reportOption.getValue() == null
				|| reportOption.getValue().equals("")) {
			Dialogs.create()
					.masthead("Select an option for showing the report.")
					.showError();
			return;
		} else if (reportOption.getValue().equals("By Year")) {
			reportServiceValue.setServiceName("year");
			params = new HashMap<>();
			params.put("requestName", "reportRequest");
			params.put("serviceKey", "yearlyService");
			params.put("serviceValue", gson.toJson(reportServiceValue));
			serverRequest = getReportRequest(params);
		} else if (reportOption.getValue().equals("By Month")) {
			reportServiceValue.setServiceName("month");
			if (yearOption.getValue() == null
					|| yearOption.getValue().equals("")) {
				Dialogs.create()
						.masthead(
								"You must Select an year for showing the report.")
						.showError();
				return;
			} else {
				reportServiceValue.setYearValue(yearOption.getValue());
				params = new HashMap<>();
				params.put("requestName", "reportRequest");
				params.put("serviceKey", "monthlyService");
				params.put("serviceValue", gson.toJson(reportServiceValue));
				serverRequest = getReportRequest(params);
			}
		} else if (reportOption.getValue().equals("By Day")) {
			reportServiceValue.setServiceName("day");
			if (yearOption.getValue() == null
					|| yearOption.getValue().equals("")) {
				Dialogs.create()
						.masthead(
								"You must Select a year for showing the report.")
						.showError();
				return;
			} else if (monthOption.getValue() == null
					|| monthOption.getValue().equals("")) {
				Dialogs.create()
						.masthead(
								"You must Select a month for showing the report.")
						.showError();
				return;
			} else {
				reportServiceValue.setYearValue(yearOption.getValue());
				reportServiceValue.setMonthValue(monthOption.getValue());
				params = new HashMap<>();
				params.put("requestName", "reportRequest");
				params.put("serviceKey", "dailyService");
				params.put("serviceValue", gson.toJson(reportServiceValue));
				serverRequest = getReportRequest(params);
			}
		} else if (reportOption.getValue().equals("By Transaction")) {
			reportServiceValue.setServiceName("transaction");
			params = new HashMap<>();
			params.put("requestName", "reportRequest");
			params.put("serviceKey", "transactionService");
			params.put("serviceValue", gson.toJson(reportServiceValue));
			serverRequest = getReportRequest(params);
		}
		if (isChartOptionSelected()) {
			serverRequest.start();
		} else {
			Dialogs.create().masthead("Select an option for the chart.")
					.showError();
		}
	}

	@FXML
	public <T> void initialize() {
		getAllYear();
		reportOption
				.getSelectionModel()
				.selectedIndexProperty()
				.addListener(
						(observable, oldValue, newValue) -> peroformAct(
								observable, oldValue, newValue));

	}

	private void peroformAct(Observable s, Number oldValue, Number newValue) {
		if (reportOption.getValue().equals("By Month")) {
			chartPane.setVisible(true);
			yearPane.setVisible(true);
			monthPane.setVisible(false);
		} else if (reportOption.getValue().equals("By Day")) {
			chartPane.setVisible(true);
			yearPane.setVisible(true);
			monthPane.setVisible(true);
		} else if (reportOption.getValue().equals("By Year")) {
			chartPane.setVisible(true);
			yearPane.setVisible(false);
			monthPane.setVisible(false);
		} else if (reportOption.getValue().equals("By Transaction")) {
			chartPane.setVisible(false);
			yearPane.setVisible(false);
			monthPane.setVisible(false);
		} else {
			chartPane.setVisible(false);
			yearPane.setVisible(false);
			monthPane.setVisible(false);
		}
	}

	private void getAllYear() {
		ReportServiceValue reportServiceValue = new ReportServiceValue();
		reportServiceValue.setServiceName("getYear");
		Gson gson = new GsonBuilder().create();
		HashMap<String, String> params = new HashMap<>();
		params.put("requestName", "reportRequest");
		params.put("serviceKey", "getYearService");
		params.put("serviceValue", gson.toJson(reportServiceValue));
		System.out.println(gson.toJson(reportServiceValue));
		ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
				Response.POST, URL, params, new Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject s) {
						Gson gson = new GsonBuilder().create();
						YearReportMessage yearReportMessage = gson.fromJson(
								s.toJSONString(), YearReportMessage.class);
						int minYear = Integer.parseInt(yearReportMessage
								.getMinYear());
						int maxYear = Integer.parseInt(yearReportMessage
								.getMaxYear());
						ObservableList<String> years = yearOption.getItems();

						for (int i = minYear; i <= maxYear; i++) {
							years.add(Integer.toString(i));
						}
						System.out.println(yearReportMessage);
					}
				}, new ErrorListener() {
					@Override
					public void onErrorResponse(Exception exception) {

					}
				});
		serverRequest.start();
	}

	private ServerRequest<JSONObject> getReportRequest(
			HashMap<String, String> params) {
		return new ServerRequest<>(Response.POST, URL, params,
				new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject s) {
						System.out.println(s.toJSONString());
						ChartScreen chartScreen = null;
						if (chartPane.isVisible()) {
							chartScreen = getChartScreen();
						}
						Gson gson = new GsonBuilder().create();
						if (reportOption.getValue().equals("By Year")) {
							YearReportMessage yearReportMessage = gson
									.fromJson(s.toJSONString(),
											YearReportMessage.class);
							chartScreen.setYearlyData(yearReportMessage
									.getReports());
							chartScreen.showAndWait();

						} else if (reportOption.getValue().equals("By Month")) {
							MonthReportMessage yearReportMessage = gson
									.fromJson(s.toJSONString(),
											MonthReportMessage.class);
							chartScreen.setMonthlyData(yearReportMessage
									.getReports());
							chartScreen.showAndWait();
						} else if (reportOption.getValue().equals("By Day")) {
							DayReportMessage yearReportMessage = gson.fromJson(
									s.toJSONString(), DayReportMessage.class);
							chartScreen.setDailyData(yearReportMessage
									.getReports());
							chartScreen.showAndWait();
						} else if (reportOption.getValue().equals(
								"By Transaction")) {
							TransactionReportScreen transactionReportScreen = ScreenFactoryClass
									.addTransactionReportScreenInstance(
											getPrimaryStage(),
											"Transaction Report");
							TransactionReportMessage transactionReportMessage = gson
									.fromJson(s.toJSONString(),
											TransactionReportMessage.class);
							transactionReportScreen
									.setApplicationListener(getApplicationListener());
							transactionReportScreen
									.setData(transactionReportMessage);
							transactionReportScreen.showAndWait();
							System.err.println(transactionReportMessage);
						}
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(Exception exception) {

					}
				});
	}

	protected ChartScreen getChartScreen() {
		if (isChartOptionSelected()) {
			switch (chartOption.getValue()) {
			case ChartScreen.BAR_CHART:
				return ScreenFactoryClass.addBarChartInstance(
						getPrimaryStage(), chartOption.getValue());
			case ChartScreen.AREA_CHART:
				return ScreenFactoryClass.addAreaChartInstance(
						getPrimaryStage(), chartOption.getValue());
			case ChartScreen.LINE_CHART:
				return ScreenFactoryClass.addLineChartInstance(
						getPrimaryStage(), chartOption.getValue());
			case ChartScreen.PIE_CHART:
				return ScreenFactoryClass.addPieChartInstance(
						getPrimaryStage(), chartOption.getValue());
			default:
				break;
			}
		}
		return null;
	}

	private boolean isChartOptionSelected() {
		return (chartOption.getValue() != null && !chartOption.getValue()
				.equals("")) || !chartPane.isVisible();
	}
}
