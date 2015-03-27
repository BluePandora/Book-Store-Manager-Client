package com.project.betelguese.app.screens;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import org.controlsfx.dialog.Dialogs;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.project.betelguese.app.item.SearchTableItem;
import com.project.betelguese.server.connection.utils.Response.ErrorListener;
import com.project.betelguese.server.connection.utils.Response.Listener;
import com.project.betelguese.server.connection.utils.Response;
import com.project.betelguese.server.connection.utils.ServerRequest;
import com.project.betelguese.server.connection.utils.URLHelper;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class SearchScreen extends Screen implements Initializable,
		Listener<JSONObject>, ErrorListener, URLHelper {

	@FXML
	private TextField searchField;

	@FXML
	private ComboBox<String> searchKeyComboBox;

	@FXML
	private TableView<SearchTableItem> searchTableView;

	@FXML
	private TableColumn<SearchTableItem, String> booksId;
	@FXML
	private TableColumn<SearchTableItem, String> booksName;
	@FXML
	private TableColumn<SearchTableItem, String> booksAuthor;
	@FXML
	private TableColumn<SearchTableItem, String> booksPublisher;
	@FXML
	private TableColumn<SearchTableItem, String> booksPrice;
	@FXML
	private TableColumn<SearchTableItem, String> booksStock;
	@FXML
	private TableColumn<SearchTableItem, String> booksISBN;
	@FXML
	private TableColumn<SearchTableItem, String> booksShelf;

	private Dialogs warningDialogs;

	private ObservableList<SearchTableItem> personData = FXCollections
			.observableArrayList();

	public SearchScreen() {

	}

	@Override
	public Scene getScreenLayout() {
		return getScene();
	}

	@FXML
	private void handleSearchButton() {
		final String requestURL = URL;
		HashMap<String, String> params = new HashMap<String, String>();
		System.out.println(searchField.getText());
		if (searchKeyComboBox.getValue() != null
				&& !searchField.getText().equals("")) {

			putSearchKey(params, searchKeyComboBox.getValue());
			params.put(REQUEST_NAME, "searchRequest");
			params.put("searchValue", searchField.getText());
			ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
					Response.POST, requestURL, params, this, this);
			serverRequest.start();
		} else if (searchKeyComboBox.getValue() == null) {
			warningDialogs.message("Select a search option first.")
					.showWarning();
		} else if (searchField.getText().equals("")) {
			warningDialogs.message("No search value entered.").showWarning();
		}
	}

	private boolean putSearchKey(HashMap<String, String> params, String key) {
		switch (key) {
		case "Book ID":
			params.put("searchKey", "searchByBookId");
			break;
		case "Book Name":
			params.put("searchKey", "searchByBook");
			break;
		case "Author":
			params.put("searchKey", "searchByAuthor");
			break;
		case "Publisher":
			params.put("searchKey", "searchByPublisher");
			break;
		case "ISBN":
			params.put("searchKey", "searchByISBN");
			break;
		case "Shelf Number":
			params.put("searchKey", "searchByShelf");
			break;
		case "All":
			params.put("searchKey", "searchByAll");
			break;
		default:
			return false;
		}
		return true;

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println(":'(");

		booksId.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksId());
		booksAuthor.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksAuthor());
		booksPublisher.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksPublisher());
		booksISBN.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksISBN());
		booksName.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksName());
		booksPrice.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksPrice());
		booksShelf.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksShelf());
		booksStock.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksStock());
		searchTableView.setItems(personData);
		searchTableView.setFixedCellSize(40.0);

	}

	@Override
	public void onErrorResponse(Exception exception) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onResponse(JSONObject s) {

		// {"searchResult":[{"booksId":"1","booksName":"line e ashun","publisherName":"nandonik","booksISBN":"978-984-90950-2-6","booksAuthor":"chorom udas","booksTotalStock":"10","displayId":"0","displayShelf":"0","displayColumn":"0","displayRow":"0"}],"done":1,"requestName":"updateRequest","message":"updateRequest  was processed by the server successfully."}
		// {"requestName":"updateRequest","searchResult":[{"displayShelf":"0","displayRow":"0","publisherName":"nandonik","booksISBN":"978-984-90950-2-6","displayColumn":"0","booksAuthor":"chorom udas","displayId":"0","booksName":"line e ashun","booksId":"1","booksTotalStock":"10"}],"message":"updateRequest  was processed by the server successfully.","done":1}

		if (!personData.isEmpty()) {
			for (int i = 0; i < personData.size();) {
				System.out.println(i + " " + personData.size());
				personData.remove(i);
			}
		}
		JSONArray array = (JSONArray) s.get("searchResult");
		if (array != null) {
			searchTableView.setPrefHeight((array.size() * 50) + 30);
			for (int i = 0; i < array.size(); i++) {
				JSONObject searchResult = (JSONObject) array.get(i);
				final String booksId = (String) searchResult.get("booksId");
				final String booksName = (String) searchResult.get("booksName")
						+ "\n";
				final String booksPublisher = (String) searchResult
						.get("publisherName");
				final String booksAuthor = (String) searchResult
						.get("booksAuthor");
				final String booksStock = (String) searchResult
						.get("booksTotalStock");
				final String booksPrice = (String) searchResult.get("price");
				final String booksISBN = (String) searchResult.get("booksISBN");
				final String displayId = (String) searchResult.get("displayId");
				final String booksDisplay;
				if (displayId.equals("0")) {
					booksDisplay = "NID";
				} else {
					booksDisplay = (String) searchResult.get("displayShelf")
							+ "/" + searchResult.get("displayColumn") + "/"
							+ searchResult.get("displayRow");
				}
				personData.add(new SearchTableItem(booksId, booksName,
						booksPublisher, booksAuthor, booksPrice, booksStock,
						booksISBN, booksDisplay));
			}
		} else {
			searchTableView.setPrefHeight(80);
		}

	}

	/**
	 * @return the warningDialogs
	 */
	public Dialogs getWarningDialogs() {
		return warningDialogs;
	}

	/**
	 * @param warningDialogs
	 *            the warningDialogs to set
	 */
	public void setWarningDialogs(Dialogs warningDialogs) {
		this.warningDialogs = warningDialogs;
	}

}
