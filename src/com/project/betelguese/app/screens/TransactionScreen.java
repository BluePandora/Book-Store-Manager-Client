package com.project.betelguese.app.screens;

import static com.project.betelguese.app.utils.FxmlUrl.transactionBookDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.controlsfx.dialog.Dialogs;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itextpdf.text.DocumentException;
import com.project.betelguese.app.item.Admin;
import com.project.betelguese.app.item.TransactionItem;
import com.project.betelguese.app.utils.DialogBuilder;
import com.project.betelguese.app.utils.TransactionCreator;
import com.project.betelguese.app.utils.TransactionInfo;
import com.project.betelguese.server.connection.utils.Response;
import com.project.betelguese.server.connection.utils.ServerRequest;
import com.project.betelguese.server.connection.utils.URLHelper;
import com.project.betelguese.server.connection.utils.Response.ErrorListener;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import com.project.betelguese.server.connection.utils.Response.Listener;
import com.project.betelguese.utils.items.Transaction;
import com.project.betelguese.utils.items.TransactionBook;

public class TransactionScreen extends Screen implements URLHelper {

	private Admin admin;

	@FXML
	private TableView<TransactionItem> transactionTableView;

	@FXML
	private TableColumn<TransactionItem, String> booksId;
	@FXML
	private TableColumn<TransactionItem, String> booksName;
	@FXML
	private TableColumn<TransactionItem, String> rate;
	@FXML
	private TableColumn<TransactionItem, String> quantity;
	@FXML
	private TableColumn<TransactionItem, String> amount;

	@FXML
	private TextField customerName;

	@FXML
	private TextField customerNumber;

	private ObservableList<TransactionItem> transactionData = FXCollections
			.observableArrayList();

	private TransactionBookScreen transactionBookScreen;

	private Stage dialogStage;
	@FXML
	private Text adminId;

	@FXML
	private Text adminName;
	@FXML
	private Text adminLevel;

	@FXML
	private Text amountText;

	@FXML
	private Text transactionId;

	private TransactionInfo transactionInfo;

	DialogBuilder progressDialog;

	public TransactionScreen() {

	}

	@Override
	public Scene getScreenLayout() {
		return getScene();
	}

	@FXML
	public void initialize() {
		booksId.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksId());
		booksName.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksName());
		amount.setCellValueFactory(celldata -> celldata.getValue()
				.getTotalPaid());
		quantity.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksStock());
		rate.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksPrice());
		transactionTableView.setItems(transactionData);
		transactionTableView.setFixedCellSize(40.0);

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

	public void createTransactionId() {
		HashMap<String, String> params = new HashMap<>();
		params.put("requestName", "transactionRequest");
		params.put("serviceKey", "getTransactionId");
		params.put("serviceValue", getEstimatedId());
		adminId.setText(admin.getAdminId().getValue());
		adminLevel.setText(admin.getAdminLevel().getValue());
		adminName.setText(admin.getAdminName().getValue());
		ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
				Response.POST, URL, params, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject s) {
						System.out.println(s.toJSONString());
						if (transactionId != null) {
							int transactionIdInt = Integer.parseInt((String) s
									.get("transactionId"));
							transactionId.setText(Integer
									.toString(++transactionIdInt));
						}
						System.out.println(s.toJSONString());
					}
				}, new ErrorListener() {
					@Override
					public void onErrorResponse(Exception exception) {

					}
				});
		serverRequest.start();

	}

	@SuppressWarnings("deprecation")
	private String getEstimatedId() {
		Date date = new Date(System.currentTimeMillis());
		String id = ""
				+ -(2000 - (date.getYear() + 1900))
				+ ((date.getMonth() + 1) < 10 ? "0" + (date.getMonth() + 1)
						: (date.getMonth() + 1))
				+ ((date.getDate()) < 10 ? "0" + (date.getDate()) : (date
						.getDate()));
		return id;
	}

	@FXML
	private void handleAddBooksButton() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(transactionBookDialog);
		dialogStage = new Stage();
		dialogStage.setTitle("Add Books");
		dialogStage.initModality(Modality.WINDOW_MODAL);
		dialogStage.initOwner(getPrimaryStage());
		AnchorPane rootPane = null;
		try {
			rootPane = (AnchorPane) loader.load();
		} catch (IOException e) {

			e.printStackTrace();
		}
		Scene scene = new Scene(rootPane);
		dialogStage.setScene(scene);
		transactionBookScreen = (TransactionBookScreen) loader.getController();
		transactionBookScreen.setDialogStage(dialogStage);
		dialogStage.setResizable(false);
		dialogStage.showAndWait();
		if (transactionBookScreen.isOkPressed()) {
			boolean flag = false;
			for (int i = 0; i < transactionData.size(); i++) {
				if (transactionData
						.get(i)
						.getBooksId()
						.getValue()
						.equals(transactionBookScreen.getTransactionItem()
								.getBooksId().getValue())) {
					flag = true;
					Dialogs.create().masthead("Duplicate Books ID!")
							.title("Error").showError();
					break;
				}
			}
			if (!flag) {
				transactionData.add(transactionBookScreen.getTransactionItem());
			}
			int total = 0;
			for (int i = 0; i < transactionData.size(); i++) {
				String temp = transactionData.get(i).getTotalPaid().getValue();
				total += Integer.parseInt(temp);
			}
			amountText.setText(Integer.toString(total));
		}
	}

	@FXML
	private void handleCompleteButton() {
		if (customerName.getText().trim().equals("")) {
			Dialogs.create().title("warning!").message("Enter a customer name")
					.showWarning();
		} else if (customerNumber.getText().trim().equals("")) {
			Dialogs.create().title("warning!")
					.message("Enter a customer mobile number").showWarning();
		} else if (transactionData.size() > 0) {
			createTransaction();
		} else {
			Dialogs.create().title("warning!")
					.message("No books are added for the transaction.")
					.showWarning();
		}
	}

	private void createTransaction() {
		transactionInfo = new TransactionInfo();
		transactionInfo.setAdminId(admin.getAdminId().getValue());
		transactionInfo.setCustomerName(customerName.getText());
		transactionInfo.setCustomerNumber(customerNumber.getText());
		transactionInfo.setTransactionId(transactionId.getText());
		transactionInfo.setTotalPaid(amountText.getText());
		List<TransactionBook> transactionBooks = new ArrayList<TransactionBook>();
		for (int i = 0; i < transactionData.size(); i++) {
			TransactionBook transactionBook = new TransactionBook();
			TransactionItem trasactionItem = transactionData.get(i);
			transactionBook.setBooksId(trasactionItem.getBooksId().getValue());
			transactionBook.setQuantity(trasactionItem.getBooksStock()
					.getValue());
			transactionBooks.add(transactionBook);
		}
		transactionInfo.setTransactionBooks(transactionBooks);
		serverRequest(transactionInfo);
	}

	private void serverRequest(TransactionInfo transaction) {
		Gson gson = new GsonBuilder().create();
		HashMap<String, String> params = new HashMap<>();
		params.put("requestName", "transactionRequest");
		params.put("serviceKey", "addTransaction");
		params.put("serviceValue", gson.toJson(transaction));
		progressDialog = DialogBuilder.createProgressDialog(getPrimaryStage());
		progressDialog.setMessage("Please Wait...");
		ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
				Response.POST, URL, params, new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject s) {
						try {
							createTransactionPDF();
						} catch (DocumentException | IOException e) {
							e.printStackTrace();
						}
						transactionData.clear();
						customerName.setText("");
						customerNumber.setText("");
						amountText.setText("");
						createTransactionId();
						Dialogs.create().title("Transaction")
								.masthead("Transaction was successful")
								.showConfirm();
						progressDialog.hide();
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(Exception exception) {
						Dialogs.create()
								.title("Transaction")
								.masthead(
										"Transaction wasn't successful.Please try again later.")
								.showConfirm();
					}
				});
		serverRequest.start();
		progressDialog.show();

	}
	
	public void setAdminName(String name){
		adminName.setText(name);
	}

	protected void createTransactionPDF() throws DocumentException, IOException {
		Transaction transaction = new Transaction(Long.toString(System
				.currentTimeMillis()), admin.getAdminName().getValue());
		transaction.setCustomerName(transactionInfo.getCustomerName());
		transaction.setCustomerNumber(transactionInfo.getCustomerNumber());
		transaction.setTotalPaid(transactionInfo.getTotalPaid());
		transaction.setTransactionId(transactionInfo.getTransactionId());
		transaction.setTransactionBooks(transactionInfo.getTransactionBooks());
		TransactionCreator transactionCreator = new TransactionCreator(
				transactionInfo.getTransactionId(), transaction);
		transactionCreator.open();
		transactionCreator.createTransaction(transactionData);
		transactionCreator.close();
	}
}
