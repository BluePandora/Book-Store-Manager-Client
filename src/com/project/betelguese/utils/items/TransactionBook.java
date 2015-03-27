package com.project.betelguese.utils.items;

public class TransactionBook {

	private String booksId;
	private String booksName;
	private String booksAuthor;
	private String booksPrice;
	private String quantity;

	public TransactionBook() {
	}

	/**
	 * @return the booksId
	 */
	public String getBooksId() {
		return booksId;
	}

	/**
	 * @param booksId
	 *            the booksId to set
	 */
	public void setBooksId(String booksId) {
		this.booksId = booksId;
	}

	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the booksName
	 */
	public String getBooksName() {
		return booksName;
	}

	/**
	 * @param booksName
	 *            the booksName to set
	 */
	public void setBooksName(String booksName) {
		this.booksName = booksName;
	}

	/**
	 * @return the booksPrice
	 */
	public String getBooksPrice() {
		return booksPrice;
	}

	/**
	 * @param booksPrice
	 *            the booksPrice to set
	 */
	public void setBooksPrice(String booksPrice) {
		this.booksPrice = booksPrice;
	}

	/**
	 * @return the booksAuthor
	 */
	public String getBooksAuthor() {
		return booksAuthor;
	}

	/**
	 * @param booksAuthor the booksAuthor to set
	 */
	public void setBooksAuthor(String booksAuthor) {
		this.booksAuthor = booksAuthor;
	}

}
