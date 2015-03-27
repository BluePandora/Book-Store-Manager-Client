package com.project.betelguese.app.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SearchTableItem {

	private final StringProperty booksId;
	private final StringProperty booksName;
	private final StringProperty booksPublisher;
	private final StringProperty booksAuthor;
	private final StringProperty booksPrice;
	private final StringProperty booksStock;
	private final StringProperty booksISBN;
	private final StringProperty booksShelf;

	public SearchTableItem() {
		this(null, null, null, null, null, null, null, null);
	}

	/**
	 * @param booksId
	 * @param booksName
	 * @param booksAuthor
	 * @param booksPublisher
	 * @param booksPrice
	 * @param booksStock
	 * @param booksISBN
	 * @param booksShelf
	 */
	public SearchTableItem(String booksId, String booksName,
			String booksPublisher, String booksAuthor, String booksPrice,
			String booksStock, String booksISBN, String booksDisplay) {
		this.booksId = new SimpleStringProperty(booksId);
		this.booksName = new SimpleStringProperty(booksName);
		this.booksAuthor = new SimpleStringProperty(booksAuthor);
		this.booksPublisher = new SimpleStringProperty(booksPublisher);
		this.booksPrice = new SimpleStringProperty(booksPrice);
		this.booksStock = new SimpleStringProperty(booksStock);
		this.booksISBN = new SimpleStringProperty(booksISBN);
		this.booksShelf = new SimpleStringProperty(booksDisplay);
	}

	public StringProperty getBooksId() {
		return booksId;
	}

	public StringProperty getBooksName() {
		return booksName;
	}

	public StringProperty getBooksAuthor() {
		return booksAuthor;
	}

	public StringProperty getBooksPublisher() {
		return booksPublisher;
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

}
