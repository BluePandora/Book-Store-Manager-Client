package com.project.betelguese.app.item;

import java.util.Iterator;
import java.util.List;

import com.project.betelguese.utils.items.TransactionBook;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TransactionIdItem {

	private final StringProperty transactionId;
	private final StringProperty customerName;
	private final StringProperty customerNumber;
	private final StringProperty adminName;
	private final StringProperty createdDate;
	private final StringProperty adminId;
	private final StringProperty totalPaid;

	private ObservableList<TransactionItem> transactionData = FXCollections
			.observableArrayList();

	public TransactionIdItem() {
		this("", "", "", "", "", "", "");
	}

	/**
	 * @param transactionId
	 * @param customerName
	 * @param customerNumber
	 * @param adminName
	 * @param createdDate
	 * @param adminId
	 * @param totalPaid
	 * @param transactionData
	 */
	public TransactionIdItem(StringProperty transactionId,
			StringProperty customerName, StringProperty customerNumber,
			StringProperty adminName, StringProperty createdDate,
			StringProperty adminId, StringProperty totalPaid) {
		this.transactionId = transactionId;
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.adminName = adminName;
		this.createdDate = createdDate;
		this.adminId = adminId;
		this.totalPaid = totalPaid;
	}

	/**
	 * @param transactionId
	 * @param customerName
	 * @param customerNumber
	 * @param adminName
	 * @param createdDate
	 * @param adminId
	 * @param totalPaid
	 * @param transactionData
	 */
	public TransactionIdItem(String transactionId, String customerName,
			String customerNumber, String adminName, String createdDate,
			String adminId, String totalPaid) {
		this.transactionId = new SimpleStringProperty(transactionId);
		this.customerName = new SimpleStringProperty(customerName);
		this.customerNumber = new SimpleStringProperty(customerNumber);
		this.adminName = new SimpleStringProperty(adminName);
		this.createdDate = new SimpleStringProperty(createdDate);
		this.adminId = new SimpleStringProperty(adminId);
		this.totalPaid = new SimpleStringProperty(totalPaid);
	}

	/**
	 * @return the transactionData
	 */
	public ObservableList<TransactionItem> getTransactionData() {
		return transactionData;
	}

	/**
	 * @param transactionData
	 *            the transactionData to set
	 */
	public void setTransactionData(
			ObservableList<TransactionItem> transactionData) {
		this.transactionData = transactionData;
	}

	/**
	 * @return the transactionId
	 */
	public StringProperty getTransactionId() {
		return transactionId;
	}

	/**
	 * @return the customerName
	 */
	public StringProperty getCustomerName() {
		return customerName;
	}

	/**
	 * @return the customerNumber
	 */
	public StringProperty getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * @return the adminName
	 */
	public StringProperty getAdminName() {
		return adminName;
	}

	/**
	 * @return the createdDate
	 */
	public StringProperty getCreatedDate() {
		return createdDate;
	}

	/**
	 * @return the adminId
	 */
	public StringProperty getAdminId() {
		return adminId;
	}

	/**
	 * @return the totalPaid
	 */
	public StringProperty getTotalPaid() {
		return totalPaid;
	}

	public void setTransactionBooks(List<TransactionBook> transactionBooks) {
		for (TransactionBook transactionBook : transactionBooks) {
			TransactionItem transactionItem = new TransactionItem(
					transactionBook.getBooksId(),
					transactionBook.getBooksName(),
					transactionBook.getBooksPrice(),
					transactionBook.getQuantity());
			transactionData.add(transactionItem);
		}
	}

}
