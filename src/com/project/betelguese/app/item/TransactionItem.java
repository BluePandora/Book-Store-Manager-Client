package com.project.betelguese.app.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TransactionItem {

	private final StringProperty booksId;
	private final StringProperty booksName;
	private final StringProperty booksPrice;
	private final StringProperty booksStock;
	private final StringProperty totalPaid;

	public TransactionItem() {
		this(null, null, null, null);
	}

	public TransactionItem(String booksId, String booksName, String booksPrice,
			String booksStock) {
		this.booksId = new SimpleStringProperty(booksId);
		this.booksName = new SimpleStringProperty(booksName);
		this.booksPrice = new SimpleStringProperty(booksPrice);
		this.booksStock = new SimpleStringProperty(booksStock);
		String totalPaid = Integer.toString(Integer.parseInt(this.booksStock
				.getValue()) * Integer.parseInt(this.booksPrice.getValue()));
		this.totalPaid = new SimpleStringProperty(totalPaid);
	}

	public StringProperty getBooksId() {
		return booksId;
	}

	public StringProperty getBooksName() {
		return booksName;
	}

	public StringProperty getBooksPrice() {
		return booksPrice;
	}

	public StringProperty getBooksStock() {
		return booksStock;
	}

	public StringProperty getTotalPaid() {
		return totalPaid;
	}
}
