package com.project.betelguese.app.screens;

import java.util.HashMap;

import org.controlsfx.dialog.Dialogs;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.project.betelguese.app.item.UpdateItem;
import com.project.betelguese.app.utils.ScreenFactoryClass;
import com.project.betelguese.server.connection.utils.Response;
import com.project.betelguese.server.connection.utils.ServerRequest;
import com.project.betelguese.server.connection.utils.URLHelper;
import com.project.betelguese.server.connection.utils.Response.ErrorListener;
import com.project.betelguese.server.connection.utils.Response.Listener;
import com.project.betelguese.utils.items.UpdateSearchResult;
import com.project.betelguese.utils.json.builders.UpdateSearchMessage;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class UpdateScreen extends Screen implements Listener<JSONObject>,
		ErrorListener, URLHelper {

	private AddBooksScreen addBooksScreen;

	@FXML
	private TableView<UpdateItem> searchTableView;

	@FXML
	private TableColumn<UpdateItem, String> booksId;

	private ObservableList<UpdateItem> personData = FXCollections
			.observableArrayList();

	@FXML
	private TextField searchField;

	@FXML
	private Button searchButton;

	@FXML
	private Label booksIdLabel;
	@FXML
	private Label ISBNLabel;
	@FXML
	private Label booksNameLabel;
	@FXML
	private Label authorLabel;
	@FXML
	private Label publisherLabel;
	@FXML
	private Label administratorNameLabel;
	@FXML
	private Label priceLabel;
	@FXML
	private Label quantityLabel;
	@FXML
	private Label stockLabel;
	@FXML
	private Label shelfLabel;
	@FXML
	private Label columnLabel;
	@FXML
	private Label rowLabel;
	@FXML
	private Label commentLabel;

	@FXML
	private Pane detailPane;

	private String maxBookId = "";
	private String ServerMaxId = "";

	public UpdateScreen() {

	}

	@Override
	public Scene getScreenLayout() {
		return getScene();
	}

	@FXML
	private void handleSearchButton() {
		final String requestURL = URL;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put(REQUEST_NAME, "updateRequest");
		params.put("updateSearch", searchField.getText());
		ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
				Response.POST, requestURL, params, this, this);
		serverRequest.start();
	}

	@Override
	public void onErrorResponse(Exception exception) {

	}

	@Override
	public void onResponse(JSONObject s) {
		Gson gson = new GsonBuilder().create();
		UpdateSearchMessage updateSearchMessage = gson.fromJson(
				s.toJSONString(), UpdateSearchMessage.class);
		if (updateSearchMessage.getSearchResult() != null) {
			for (UpdateSearchResult updateSearchResult : updateSearchMessage
					.getSearchResult()) {
				UpdateItem updateItem = new UpdateItem(updateSearchResult);
				boolean flag = false;
				for (int j = 0; j < personData.size(); j++) {
					System.out.println(personData.get(j).getBooksId()
							.getValue()
							+ " " + booksId);
					if (personData.get(j).getBooksId().getValue()
							.equals(updateItem.getBooksId().getValue())) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					personData.add(updateItem);
				}
			}
		}
	}

	@FXML
	public void initialize() {

		booksId.setCellValueFactory(celldata -> celldata.getValue()
				.getBooksId());
		searchTableView.setItems(personData);
		searchTableView.setFixedCellSize(40.0);
		detailPane.setVisible(false);
		searchTableView.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<UpdateItem>() {

					@Override
					public void changed(
							ObservableValue<? extends UpdateItem> observable,
							UpdateItem oldValue, UpdateItem item) {
						if (!detailPane.isVisible()) {
							detailPane.setVisible(true);
						}
						if (item != null) {
							booksIdLabel.setText(item.getBooksId().getValue());
							ISBNLabel.setText(item.getBooksISBN().getValue());
							booksNameLabel.setText(item.getBooksName()
									.getValue());
							authorLabel.setText(item.getBooksAuthor()
									.getValue());
							publisherLabel.setText(item.getBooksPublisher()
									.getValue());
							administratorNameLabel.setText(item
									.getAdministratorName().getValue());
							priceLabel.setText(item.getBooksPrice().getValue());
							quantityLabel.setText(item.getSuppliedBooks()
									.getValue());
							stockLabel.setText(item.getBooksStock().getValue());
							shelfLabel.setText(item.getBooksShelf().getValue());
							columnLabel.setText(item.getBooksColumn()
									.getValue());
							rowLabel.setText(item.getBooksRow().getValue());
							commentLabel.setText(item.getComment().getValue());
						}
					}
				});
	}

	@FXML
	private void handleDeleteButton() {
		if (personData.size() != 0
				&& searchTableView.getSelectionModel().getSelectedIndex() != -1) {
			try {
				personData.remove(searchTableView.getSelectionModel()
						.getSelectedIndex());
			} catch (Exception e) {

			}

			if (!maxBookId.equals("")) {
				for (int i = 0; i < personData.size(); i++) {
					if (Integer.parseInt(personData.get(i).getBooksId()
							.getValue()) > Integer.parseInt(maxBookId)) {
						maxBookId = personData.get(i).getBooksId().getValue();
					}
				}
				System.out.println(maxBookId + "tuman");
				if (Integer.parseInt(ServerMaxId) > Integer.parseInt(maxBookId)) {
					int id = Integer.parseInt(ServerMaxId);
					maxBookId = Integer.toString(++id);
				} else {
					int id = Integer.parseInt(maxBookId);
					maxBookId = Integer.toString(++id);
				}
			}
		}
		System.out.println(personData.size());
		if (personData.size() == 0) {
			System.out.println("ok");
			maxBookId = ServerMaxId = "";
			detailPane.setVisible(false);
		}
	}

	@FXML
	private void handleAddButton() {
		addBooksScreen = ScreenFactoryClass
				.addBooksScreenInstance(getPrimaryStage());
		addBooksScreen.setApplicationListener(getApplicationListener());
		if (maxBookId.equals("")) {
			final String requestURL = URL;
			HashMap<String, String> params = new HashMap<>();
			params.put(REQUEST_NAME, "updateRequest");
			params.put("maxId", "booksTable");
			ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
					Response.POST, requestURL, params,
					new Listener<JSONObject>() {

						@Override
						public void onResponse(JSONObject s) {
							ServerMaxId = maxBookId = (String) s
									.get("maxBooksId");
							System.out.println(s.toJSONString());
							int id = 0;
							if (maxBookId != null) {
								id = Integer.parseInt(maxBookId);
							}
							ServerMaxId = Integer.toString(id);
							maxBookId = Integer.toString(++id);
							addBooksScreen.setbooksId(maxBookId);
							showAddBookDialog();
						}
					}, new ErrorListener() {

						@Override
						public void onErrorResponse(Exception exception) {

						}
					});
			serverRequest.start();
		} else {
			boolean min[] = new boolean[Integer.parseInt(maxBookId)];
			System.out.println(maxBookId + "  " + ServerMaxId);
			for (int i = 1; i <= Integer.parseInt(ServerMaxId); i++) {
				min[i] = true;
			}
			for (int i = 0; i < personData.size(); i++) {
				if (!min[Integer.parseInt(personData.get(i).getBooksId()
						.getValue())]) {
					min[Integer.parseInt(personData.get(i).getBooksId()
							.getValue())] = true;
				}
			}
			for (int i = 1; i <= min.length; i++) {
				if (!min[i]) {
					addBooksScreen.setbooksId(Integer.toString(i));
					break;
				} else if (i == min.length - 1) {
					System.out.println(ServerMaxId + "kkkk" + maxBookId);
					if (Integer.parseInt(ServerMaxId) < Integer
							.parseInt(maxBookId)) {
						addBooksScreen.setbooksId(maxBookId);
					}
					break;
				}
			}
			showAddBookDialog();
		}
	}

	@SuppressWarnings("unchecked")
	@FXML
	private void handleUpdateButton() {
		// {"addBooks":[{"booksId":1,"publisherName":"tuman","totalPrice":1000,"totalPaid":1000,
		// "comment":"ok done job","administratorId":2,"displayShelf":1,"displayColumn":1,
		// "displayRow":10,"booksName":"tuman","booksAuthor":"tuman","booksISBN":901,"individualPrice":100,
		// "booksTotalStock":10}]}
		// added publisher or get the old one
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		for (int i = 0; i < personData.size(); i++) {
			UpdateItem item = personData.get(i);
			if (personData.get(i).isAdd()) {
				maxBookId = "";
				ServerMaxId = "";
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("administratorId", getApplicationListener()
						.loadPersonDataFromFile().getAdminId().getValue());
				jsonObject.put("booksId", item.getBooksId().getValue());
				jsonObject.put("booksName", item.getBooksName().getValue());
				jsonObject.put("booksISBN", item.getBooksISBN().getValue());
				jsonObject.put("booksAuthor", item.getBooksAuthor().getValue());
				jsonObject.put("booksTotalStock", item.getBooksStock()
						.getValue());
				jsonObject.put("individualPrice", item.getBooksPrice()
						.getValue());
				jsonObject.put(
						"totalPrice",
						Integer.parseInt(item.getBooksPrice().getValue())
								* Integer.parseInt(item.getBooksStock()
										.getValue()));
				jsonObject.put(
						"totalPaid",
						Integer.parseInt(item.getBooksPrice().getValue())
								* Integer.parseInt(item.getBooksStock()
										.getValue()));
				jsonObject.put("publisherName", item.getBooksPublisher()
						.getValue());
				jsonObject.put("comment", item.getComment().getValue());

				jsonObject.put("displayShelf", item.getBooksShelf().getValue());
				jsonObject.put("displayColumn", item.getBooksColumn()
						.getValue());
				jsonObject.put("displayRow", item.getBooksRow().getValue());

				array.add(jsonObject);
			}
			object.put("addBooks", array);
			System.out.println(object.toJSONString());
			HashMap<String, String> params = new HashMap<>();
			params.put(REQUEST_NAME, "updateRequest");
			params.put("addBooks", object.toJSONString());
			ServerRequest<JSONObject> serverRequest = new ServerRequest<>(
					Response.POST, URL, params, new Listener<JSONObject>() {

						@Override
						public void onResponse(JSONObject s) {
							System.out.println(s.toJSONString());
							personData.clear();

						}
					}, new ErrorListener() {

						@Override
						public void onErrorResponse(Exception exception) {
						}
					});
			serverRequest.start();
		}
	}

	@FXML
	private void handleEditButton() {
		if (personData.size() != 0
				&& searchTableView.getSelectionModel().getSelectedIndex() != -1) {
			addBooksScreen = ScreenFactoryClass
					.addBooksScreenInstance(getPrimaryStage());
			addBooksScreen.setApplicationListener(getApplicationListener());
			int selectedPosition = searchTableView.getSelectionModel()
					.getSelectedIndex();
			UpdateItem updateItem = personData.get(selectedPosition);
			addBooksScreen.setUpdateItem(updateItem);
			addBooksScreen.editBooks();
			addBooksScreen.showAndWait();
			if (addBooksScreen.isOkPressed()) {
				int maxId = Integer.parseInt(maxBookId);
				maxBookId = Integer.toString(++maxId);
				if (!duplicateEntryCheck(addBooksScreen.getUpdateItem(),
						selectedPosition)) {
					personData.set(selectedPosition,
							addBooksScreen.getUpdateItem());
				}
			} else if (maxBookId.equals(ServerMaxId)) {
				maxBookId = ServerMaxId = "";
			}

		} else {
			Dialogs.create().masthead("No item is selected").showError();
		}
	}

	private boolean duplicateEntryCheck(UpdateItem updateItem) {

		boolean flag = false;
		for (int i = 0; i < personData.size(); i++) {
			if (personData.get(i).getBooksId().getValue()
					.equals(updateItem.getBooksId().getValue())) {
				flag = true;
				Dialogs.create().masthead("Duplicate Books ID!").title("Error")
						.showError();
				break;
			} else if (personData.get(i).getBooksName().getValue()
					.equals(updateItem.getBooksName().getValue())) {
				flag = true;
				Dialogs.create().masthead("Duplicate Book Name!")
						.title("Error").showError();
				break;
			} else if (personData.get(i).getBooksISBN().getValue()
					.equals(updateItem.getBooksISBN().getValue())) {
				flag = true;
				Dialogs.create().masthead("Duplicate ISBN!").title("Error")
						.showError();
				break;
			}
		}
		return flag;
	}

	private boolean duplicateEntryCheck(UpdateItem updateItem, int position) {

		boolean flag = false;
		for (int i = 0; i < personData.size(); i++) {
			if (i == position)
				continue;
			if (personData.get(i).getBooksName().getValue()
					.equals(updateItem.getBooksName().getValue())) {
				flag = true;
				Dialogs.create().masthead("Duplicate Book Name!")
						.title("Error").showError();
				break;
			} else if (personData.get(i).getBooksISBN().getValue()
					.equals(updateItem.getBooksISBN().getValue())) {
				flag = true;
				Dialogs.create().masthead("Duplicate ISBN!").title("Error")
						.showError();
				break;
			}
		}
		return flag;
	}

	private void showAddBookDialog() {
		addBooksScreen.showAndWait();
		if (addBooksScreen.isOkPressed()) {
			int maxId = Integer.parseInt(maxBookId);
			maxBookId = Integer.toString(++maxId);
			if (!duplicateEntryCheck(addBooksScreen.getUpdateItem())) {
				personData.add(addBooksScreen.getUpdateItem());
			}
		} else if (maxBookId.equals(ServerMaxId)) {
			maxBookId = ServerMaxId = "";
		}
	}
}
