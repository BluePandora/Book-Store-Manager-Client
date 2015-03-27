package com.project.betelguese.app.screens;

import com.project.betelguese.app.item.TransactionIdItem;
import com.project.betelguese.app.item.TransactionItem;
import com.project.betelguese.utils.items.TransactionReport;
import com.project.betelguese.utils.json.builders.TransactionReportMessage;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TransactionReportScreen extends Screen {
	private Stage dialogStage;
	@FXML
	private TableView<TransactionIdItem> transactionIdTable;
	@FXML
	private TableColumn<TransactionIdItem, String> transactionIdColumn;
	@FXML
	private TableView<TransactionItem> transactionBookTable;
	@FXML
	private TableColumn<TransactionItem, String> bookIdColumn;
	@FXML
	private TableColumn<TransactionItem, String> bookNameColumn;
	@FXML
	private TableColumn<TransactionItem, String> rateColumn;
	@FXML
	private TableColumn<TransactionItem, String> quantityColumn;
	@FXML
	private TableColumn<TransactionItem, String> amountColumn;
	@FXML
	private Text amountText;
	@FXML
	private Text transactionIdText;
	@FXML
	private Text customerNameText;
	@FXML
	private Text customerNumberText;
	@FXML
	private Text adminNameText;
	@FXML
	private Text adminIdText;
	@FXML
	private Text transactionTimeText;

	private ObservableList<TransactionIdItem> transactionIdData = FXCollections
			.observableArrayList();

	public TransactionReportScreen() {
	}

	@Override
	public Scene getScreenLayout() {
		// TODO Auto-generated method stub
		return getScene();
	}

	@FXML
	public void initialize() {
		transactionIdColumn.setCellValueFactory(celldata -> celldata.getValue()
				.getTransactionId());
		bookIdColumn.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksId());
		bookNameColumn.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksName());
		amountColumn.setCellValueFactory(celldata -> celldata.getValue()
				.getTotalPaid());
		quantityColumn.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksStock());
		rateColumn.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksPrice());
		transactionIdTable.setItems(transactionIdData);
		transactionIdTable
				.getSelectionModel()
				.selectedItemProperty()
				.addListener(
						(observable, oldValue, newValue) -> peroformAct(
								observable, oldValue, newValue));
		transactionIdTable.setItems(transactionIdData);
		transactionIdTable.setFixedCellSize(60.0);
		transactionBookTable.setFixedCellSize(40.0);
	}

	private void peroformAct(
			ObservableValue<? extends TransactionIdItem> observable,
			TransactionIdItem oldValue, TransactionIdItem newValue) {
		transactionIdText.setText(newValue.getTransactionId().getValue());
		customerNameText.setText(newValue.getCustomerName().getValue());
		customerNumberText.setText(newValue.getCustomerNumber().getValue());
		transactionTimeText.setText(newValue.getCreatedDate().getValue());
		adminIdText.setText(newValue.getAdminId().getValue());
		adminNameText.setText(newValue.getAdminName().getValue());
		transactionBookTable.setItems(newValue.getTransactionData());
		amountText.setText(newValue.getTotalPaid().getValue());
	}

	public void setData(TransactionReportMessage transactionReportMessage) {
		for (TransactionReport transactionReport : transactionReportMessage
				.getReports()) {
			TransactionIdItem transactionIdItem = new TransactionIdItem(
					transactionReport.getTransactionId(),
					transactionReport.getCustomerName(),
					transactionReport.getCustomerNumber(),
					transactionReport.getAdminName(),
					transactionReport.getDate(),
					transactionReport.getAdminId(),
					transactionReport.getTotalPaid());
			transactionIdItem.setTransactionBooks(transactionReport
					.getTransactionBooks());
			transactionIdData.add(transactionIdItem);
		}
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

	public void showAndWait() {
		dialogStage.showAndWait();
	}
}
