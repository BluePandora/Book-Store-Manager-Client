package com.project.betelguese.app.item;

import com.project.betelguese.utils.items.UpdateSearchResult;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UpdateItem {

	private final StringProperty booksId;
	private final StringProperty booksName;
	private final StringProperty booksPublisher;
	private final StringProperty booksAuthor;
	private final StringProperty booksPrice;
	private final StringProperty booksStock;
	private final StringProperty booksISBN;
	private final StringProperty booksShelf;
	private final StringProperty booksColumn;
	private final StringProperty booksRow;
	private final StringProperty suppliedBooks;
	private final StringProperty comment;
	private final StringProperty totalPaid;
	private boolean add;
	private final StringProperty administratorName;

	public UpdateItem() {
		this(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null);
	}

	public UpdateItem(String administratorName, String booksId,
			String booksName, String booksPublisher, String booksAuthor,
			String booksPrice, String booksStock, String booksISBN,
			String booksShelf, String booksColumn, String booksRow,
			String suppliedBooks, String totalPaid, String comment) {
		this.administratorName = new SimpleStringProperty(administratorName);
		this.booksId = new SimpleStringProperty(booksId);
		this.booksName = new SimpleStringProperty(booksName);
		this.booksAuthor = new SimpleStringProperty(booksAuthor);
		this.booksPublisher = new SimpleStringProperty(booksPublisher);
		this.booksPrice = new SimpleStringProperty(booksPrice);
		this.booksStock = new SimpleStringProperty(booksStock);
		this.booksISBN = new SimpleStringProperty(booksISBN);
		this.booksShelf = new SimpleStringProperty(booksShelf);
		this.suppliedBooks = new SimpleStringProperty(suppliedBooks);
		this.booksColumn = new SimpleStringProperty(booksColumn);
		this.booksRow = new SimpleStringProperty(booksRow);
		this.comment = new SimpleStringProperty(comment);
		this.totalPaid = new SimpleStringProperty(totalPaid);

	}

	public UpdateItem(UpdateSearchResult updateSearchResult) {
		this.administratorName = new SimpleStringProperty(
				updateSearchResult.getAdminName());
		this.booksId = new SimpleStringProperty(updateSearchResult.getBooksId());
		this.booksName = new SimpleStringProperty(
				updateSearchResult.getBooksName());
		this.booksAuthor = new SimpleStringProperty(
				updateSearchResult.getBooksAuthor());
		this.booksPublisher = new SimpleStringProperty(
				updateSearchResult.getPublisherName());
		this.booksPrice = new SimpleStringProperty(
				updateSearchResult.getPrice());
		this.booksStock = new SimpleStringProperty(
				updateSearchResult.getBooksTotalStock());
		this.booksISBN = new SimpleStringProperty(
				updateSearchResult.getBooksISBN());
		this.booksShelf = new SimpleStringProperty(
				updateSearchResult.getDisplayShelf());
		this.suppliedBooks = new SimpleStringProperty(
				updateSearchResult.getQuantity());
		this.booksColumn = new SimpleStringProperty(
				updateSearchResult.getDisplayColumn());
		this.booksRow = new SimpleStringProperty(
				updateSearchResult.getDisplayRow());
		this.comment = new SimpleStringProperty(updateSearchResult.getComment());
		this.totalPaid = new SimpleStringProperty(
				updateSearchResult.getTotalPaid());

	}

	public StringProperty getBooksId() {
		return booksId;
	}

	public StringProperty getBooksName() {
		return booksName;
	}

	public StringProperty getBooksPublisher() {
		return booksPublisher;
	}

	public StringProperty getBooksAuthor() {
		return booksAuthor;
	}

	public StringProperty getBooksPrice() {
		return booksPrice;
	}

	public StringProperty getBooksStock() {
		return booksStock;
	}

	public StringProperty getBooksISBN() {
		return booksISBN;
	}

	public StringProperty getBooksShelf() {
		return booksShelf;
	}

	public StringProperty getBooksColumn() {
		return booksColumn;
	}

	public StringProperty getBooksRow() {
		return booksRow;
	}

	public StringProperty getSuppliedBooks() {
		return suppliedBooks;
	}

	public StringProperty getComment() {
		return comment;
	}

	public StringProperty getTotalPaid() {
		return totalPaid;
	}

	public StringProperty getAdministratorName() {
		return administratorName;
	}

	public boolean isAdd() {
		return add;
	}

	public void setAdd(boolean add) {
		this.add = add;
	}

}
