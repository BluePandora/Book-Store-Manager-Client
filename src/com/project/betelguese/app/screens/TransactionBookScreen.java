package com.project.betelguese.app.screens;

import java.util.HashMap;

import org.controlsfx.dialog.Dialogs;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.project.betelguese.app.item.TransactionItem;
import com.project.betelguese.server.connection.utils.Response;
import com.project.betelguese.server.connection.utils.ServerRequest;
import com.project.betelguese.server.connection.utils.URLHelper;
import com.project.betelguese.server.connection.utils.Response.ErrorListener;
import com.project.betelguese.server.connection.utils.Response.Listener;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class TransactionBookScreen implements URLHelper {

	private Stage dialogStage;

	@FXML
	private TextField amountField;
	@FXML
	private TextField bookIdField;

	private TransactionItem transactionItem;

	private boolean okPressed = false;

	public TransactionBookScreen() {

	}

	@FXML
	public void initialize() {
		bookIdField.setOnKeyTyped(value -> onKeyPressed(value));
		amountField.setOnKeyTyped(value -> onKeyPressed(value));
	}

	public void onKeyPressed(KeyEvent eventHandler) {
		String c = eventHandler.getCharacter();
		if ("1234567890".contains(c)) {
		} else {
			eventHandler.consume();
		}
	}

	@FXML
	private void handleOkButton() {
		if (bookIdField.getText().trim().equals("")) {
			Dialogs.create().title("Warnings!")
					.message("Books Id Can not be empty!").showWarning();
		} else if (amountField.getText().trim().equals("")) {
			Dialogs.create().title("Warnings!")
					.message("amount Can not be empty!").showWarning();
		} else {
			HashMap<String, String> params = new HashMap<>();
			params.put("requestName", "transactionRequest");
			params.put("serviceKey", "getBooks");
			params.put("serviceValue", bookIdField.getText());
			ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
					Response.POST, URL, params, new Listener<JSONObject>() {

						@Override
						public void onResponse(JSONObject s) {
							JSONArray array = (JSONArray) s.get("searchResult");
							if (array == null) {
								Dialogs.create().title("Warnings!")
										.masthead("Invalid book ID!")
										.message("Add a valid book ID.")
										.showWarning();
								return;
							}
							JSONObject object = (JSONObject) array.get(0);
							String amount = (String) object
									.get("booksTotalStock");
							System.out.println(object.get("booksTotalStock"));
							if (Integer.parseInt(amountField.getText()) > (Integer
									.parseInt(amount))) {
								Dialogs.create()
										.title("Warnings!")
										.masthead(
												"amount is greater than stock!")
										.message(
												"Add less than"
														+ (String) object
																.get("booksTotalStock")
														+ " books.")
										.showWarning();
							} else {
								final String booksId = (String) object
										.get("booksId");
								final String booksName = (String) object
										.get("booksName");
								final String booksTotalStock = amountField
										.getText().trim();
								final String price = (String) object
										.get("price");
								transactionItem = new TransactionItem(booksId,
										booksName, price, booksTotalStock);
								okPressed = true;
								dialogStage.close();
							}
						}
					}, new ErrorListener() {

						@Override
						public void onErrorResponse(Exception exception) {
							// TODO Auto-generated method stub

						}
					});
			serverRequest.start();
		}
	}

	@FXML
	private void handleCancelButton() {
		dialogStage.close();
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isOkPressed() {
		return okPressed;
	}

	public void setOkPressed(boolean okPressed) {
		this.okPressed = okPressed;
	}

	public TransactionItem getTransactionItem() {
		return transactionItem;
	}

	public void setTransactionItem(TransactionItem transactionItem) {
		this.transactionItem = transactionItem;
	}
}
