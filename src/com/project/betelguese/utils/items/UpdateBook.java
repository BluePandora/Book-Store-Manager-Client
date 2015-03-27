package com.project.betelguese.utils.items;

public class UpdateBook {

	private String booksId;
	private String booksName;
	private String publisherName;
	private String booksISBN;
	private String booksAuthor;
	private String booksTotalStock;
	private String individualPrice;
	private String displayShelf;
	private String displayColumn;
	private String displayRow;
	private String comment;
	private String totalPaid;
	private String sellerName;
	private String quantity;
	private String administratorId;

	public UpdateBook() {
		this(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null);
	}

	/**
	 * 
	 * @param booksId
	 * @param booksName
	 * @param publisherName
	 * @param booksISBN
	 * @param booksAuthor
	 * @param booksTotalStock
	 * @param individualPrice
	 * @param displayId
	 * @param displayShelf
	 * @param displayColumn
	 * @param displayRow
	 * @param comment
	 * @param totalPaid
	 * @param sellerName
	 * @param quantity
	 * @param administratorId
	 */
	public UpdateBook(String booksId, String booksName, String publisherName,
			String booksISBN, String booksAuthor, String booksTotalStock,
			String individualPrice, String displayShelf, String displayColumn,
			String displayRow, String comment, String totalPaid,
			String sellerName, String quantity, String administratorId) {
		this.booksId = booksId;
		this.booksName = booksName;
		this.publisherName = publisherName;
		this.booksISBN = booksISBN;
		this.booksAuthor = booksAuthor;
		this.booksTotalStock = booksTotalStock;
		this.individualPrice = individualPrice;
		this.displayShelf = displayShelf;
		this.displayColumn = displayColumn;
		this.displayRow = displayRow;
		this.comment = comment;
		this.totalPaid = totalPaid;
		this.sellerName = sellerName;
		this.quantity = quantity;
		this.administratorId = administratorId;
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
	 * @return the publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}

	/**
	 * @param publisherName
	 *            the publisherName to set
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	/**
	 * @return the booksISBN
	 */
	public String getBooksISBN() {
		return booksISBN;
	}

	/**
	 * @param booksISBN
	 *            the booksISBN to set
	 */
	public void setBooksISBN(String booksISBN) {
		this.booksISBN = booksISBN;
	}

	/**
	 * @return the booksAuthor
	 */
	public String getBooksAuthor() {
		return booksAuthor;
	}

	/**
	 * @param booksAuthor
	 *            the booksAuthor to set
	 */
	public void setBooksAuthor(String booksAuthor) {
		this.booksAuthor = booksAuthor;
	}

	/**
	 * @return the booksTotalStock
	 */
	public String getBooksTotalStock() {
		return booksTotalStock;
	}

	/**
	 * @param booksTotalStock
	 *            the booksTotalStock to set
	 */
	public void setBooksTotalStock(String booksTotalStock) {
		this.booksTotalStock = booksTotalStock;
	}

	/**
	 * @return the individualPrice
	 */
	public String getIndividualPrice() {
		return individualPrice;
	}

	/**
	 * @param individualPrice
	 *            the individualPrice to set
	 */
	public void setIndividualPrice(String individualPrice) {
		this.individualPrice = individualPrice;
	}

	/**
	 * @return the displayShelf
	 */
	public String getDisplayShelf() {
		return displayShelf;
	}

	/**
	 * @param displayShelf
	 *            the displayShelf to set
	 */
	public void setDisplayShelf(String displayShelf) {
		this.displayShelf = displayShelf;
	}

	/**
	 * @return the displayColumn
	 */
	public String getDisplayColumn() {
		return displayColumn;
	}

	/**
	 * @param displayColumn
	 *            the displayColumn to set
	 */
	public void setDisplayColumn(String displayColumn) {
		this.displayColumn = displayColumn;
	}

	/**
	 * @return the displayRow
	 */
	public String getDisplayRow() {
		return displayRow;
	}

	/**
	 * @param displayRow
	 *            the displayRow to set
	 */
	public void setDisplayRow(String displayRow) {
		this.displayRow = displayRow;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment
	 *            the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return the totalPaid
	 */
	public String getTotalPaid() {
		return totalPaid;
	}

	/**
	 * @param totalPaid
	 *            the totalPaid to set
	 */
	public void setTotalPaid(String totalPaid) {
		this.totalPaid = totalPaid;
	}

	/**
	 * @return the sellerName
	 */
	public String getSellerName() {
		return sellerName;
	}

	/**
	 * @param sellerName
	 *            the sellerName to set
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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

	public void setAdministratorId(String adminId) {
		this.administratorId = adminId;
	}

	public String getAdministratorId() {
		return administratorId;
	}

	/**
	 * @param comment
	 * @param totalPaid
	 * @param sellerName
	 * @param quantity
	 * @param adminId
	 */
	public UpdateBook(String comment, String totalPaid, String sellerName,
			String quantity, String adminId) {
		this.comment = comment;
		this.totalPaid = totalPaid;
		this.sellerName = sellerName;
		this.quantity = quantity;
		this.administratorId = adminId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateSearchResult [comment=" + comment + ", totalPaid="
				+ totalPaid + ", sellerName=" + sellerName + ", quantity="
				+ quantity + ", adminName=" + administratorId + "]";
	}

}
