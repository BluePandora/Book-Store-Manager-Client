package com.project.betelguese.app.screens;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import org.controlsfx.dialog.Dialogs;

import com.project.betelguese.app.item.UpdateItem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddBooksScreen extends Screen {

	private AnchorPane rootPane;
	private FXMLLoader loader;
	private Stage dialogStage;
	private Scene scene;
	@FXML
	private HBox displayHBox;

	@FXML
	private Label booksId;

	@FXML
	private TextField ISBNTextField;
	@FXML
	private TextField bookNameTextField;
	@FXML
	private TextField authorNameTextField;
	@FXML
	private TextField publisherNameTextField;
	@FXML
	private TextField priceTextField;
	@FXML
	private TextField totalSupplyTextField;

	@FXML
	private TextField displayShelfTextField;

	@FXML
	private TextField displayColumnTextField;

	@FXML
	private TextField displayRowTextField;

	@FXML
	private CheckBox displayAvailableCheckBox;

	@FXML
	private TextField commentTextField;

	private UpdateItem updateItem;
	private boolean okPressed;

	public AddBooksScreen() {
		okPressed = false;
	}

	@Override
	public Scene getScreenLayout() {
		try {
			loader.getController();
			rootPane = (AnchorPane) loader.load();
			scene = new Scene(rootPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return scene;
	}

	public void setRoot(AnchorPane pane) {
		this.rootPane = pane;
	}

	@FXML
	public void initialize() {
		priceTextField.setOnKeyTyped(value -> onKeyPressed(value));
		displayShelfTextField.setOnKeyTyped(value -> onKeyPressed(value));
		displayColumnTextField.setOnKeyTyped(value -> onKeyPressed(value));
		displayRowTextField.setOnKeyTyped(value -> onKeyPressed(value));
		totalSupplyTextField.setOnKeyTyped(value -> onKeyPressed(value));
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
		if (bookNameTextField.getText().trim().equals("")) {
			Dialogs.create().title("Warnings!")
					.message("Books Name Can not be empty!").showWarning();
		} else if (authorNameTextField.getText().trim().equals("")) {
			Dialogs.create().title("Warnings!")
					.message("Author Name Can not be empty!").showWarning();
		} else if (publisherNameTextField.getText().trim().equals("")) {
			Dialogs.create().title("Warnings!")
					.message("Publisher Name Can not be empty!").showWarning();
		} else if (priceTextField.getText().trim().equals("")) {
			Dialogs.create().title("Warnings!")
					.message("Publisher Name Can not be empty!").showWarning();
		} else if (totalSupplyTextField.getText().trim().equals("")) {
			Dialogs.create().title("Warnings!")
					.message("Publisher Name Can not be empty!").showWarning();
		} else if (displayShelfTextField.getText().trim().equals("")
				|| displayColumnTextField.getText().trim().equals("")
				|| displayRowTextField.getText().trim().equals("")) {
			if (!displayAvailableCheckBox.isSelected()) {
				Dialogs.create()
						.title("Warnings!")
						.message(
								"Please check the box if the book is not is display!")
						.masthead("Books display details is incomplete.")
						.showWarning();
			}
		} else if (commentTextField.getText().trim().equals("")) {
			Dialogs.create().title("Warnings!")
					.message("Comment field Can not be empty!").showWarning();
		} else {
			final String administratorName = getApplicationListener()
					.loadPersonDataFromFile().getAdminName().getValue();
			final String booksId = this.booksId.getText().trim();
			final String booksName = this.bookNameTextField.getText().trim();
			final String booksPublisher = this.publisherNameTextField.getText()
					.trim();
			final String booksAuthor = this.authorNameTextField.getText()
					.trim();
			final String booksPrice = this.priceTextField.getText().trim();
			final String booksStock = this.totalSupplyTextField.getText()
					.trim();
			final String booksISBN = ISBNTextField.getText().trim();
			final String booksShelf = this.displayShelfTextField.getText()
					.trim();
			final String booksColumn = this.displayColumnTextField.getText()
					.trim();
			final String booksRow = this.displayRowTextField.getText().trim();
			final String suppliedBooks = this.totalSupplyTextField.getText()
					.trim();
			final String totalPaid = Integer
					.toString(
							Integer.parseInt(this.totalSupplyTextField
									.getText().trim())
									* Integer.parseInt(this.priceTextField
											.getText().trim())).trim();
			final String comment = commentTextField.getText().trim();
			updateItem = new UpdateItem(administratorName, booksId, booksName,
					booksPublisher, booksAuthor, booksPrice, booksStock,
					booksISBN, booksShelf, booksColumn, booksRow,
					suppliedBooks, totalPaid, comment);
			updateItem.setAdd(true);
			okPressed = true;
			dialogStage.close();
		}
	}

	@FXML
	private void handleCancelButton() {
		dialogStage.close();
	}

	@FXML
	private void handleDisplay(ActionEvent actionEvent) {
		displayHBox.setDisable(displayAvailableCheckBox.isSelected());
		if (displayAvailableCheckBox.isSelected()) {
			displayRowTextField.setText("0");
			displayShelfTextField.setText("0");
			displayColumnTextField.setText("0");
		} else {
			displayRowTextField.setText("");
			displayShelfTextField.setText("");
			displayColumnTextField.setText("");
		}
	}

	public void showAndWait() {
		dialogStage.showAndWait();
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setbooksId(String maxBookId) {
		booksId.setText(maxBookId);
	}

	public UpdateItem getUpdateItem() {
		return updateItem;
	}

	public void setUpdateItem(UpdateItem updateItem) {
		this.updateItem = updateItem;
	}

	public boolean isOkPressed() {
		return okPressed;
	}

	public void setOkPressed(boolean okPressed) {
		this.okPressed = okPressed;
	}

	public void editBooks() {
		if (updateItem != null) {
			booksId.setText(updateItem.getBooksId().getValue());

			ISBNTextField.setText(updateItem.getBooksISBN().getValue());

			bookNameTextField.setText(updateItem.getBooksName().getValue());

			authorNameTextField.setText(updateItem.getBooksAuthor().getValue());

			publisherNameTextField.setText(updateItem.getBooksPrice()
					.getValue());

			priceTextField.setText(updateItem.getBooksPrice().getValue());

			totalSupplyTextField.setText(updateItem.getSuppliedBooks()
					.getValue());

			displayShelfTextField
					.setText(updateItem.getBooksShelf().getValue());

			displayColumnTextField.setText(updateItem.getBooksColumn()
					.getValue());

			displayRowTextField.setText(updateItem.getBooksRow().getValue());

			if (displayShelfTextField.getText().equals("0")
					&& displayColumnTextField.getText().equals("0")
					&& displayRowTextField.getText().equals("0")) {
				displayAvailableCheckBox.setSelected(true);
				displayHBox.setDisable(true);
			}
			commentTextField.setText(updateItem.getComment().getValue());
		}
	}
}
