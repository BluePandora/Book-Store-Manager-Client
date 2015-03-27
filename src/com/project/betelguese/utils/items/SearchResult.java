package com.project.betelguese.utils.items;

public class SearchResult {

	/*
	 * books_id,books_name,publisher_name,books_isbn,books_author,
	 * books_total_stock,display_id, display_shelf,display_column,display_row
	 */
	private String booksId;
	private String booksName;
	private String publisherName;
	private String booksISBN;
	private String booksAuthor;
	private String booksTotalStock;
	private String price;
	private String displayId;
	private String displayShelf;
	private String displayColumn;
	private String displayRow;

	public SearchResult() {
		this(null, null, null, null, null, null, null, null, null, null, null);
	}

	/**
	 * @param booksId
	 * @param booksName
	 * @param publisherName
	 * @param booksISBN
	 * @param booksAuthor
	 * @param booksTotalStock
	 * @param price
	 * @param displayId
	 * @param displayShelf
	 * @param displayColumn
	 * @param displayRow
	 */
	public SearchResult(String booksId, String booksName, String publisherName,
			String booksISBN, String booksAuthor, String booksTotalStock,
			String price, String displayId, String displayShelf,
			String displayColumn, String displayRow) {
		this.booksId = booksId;
		this.booksName = booksName;
		this.publisherName = publisherName;
		this.booksISBN = booksISBN;
		this.booksAuthor = booksAuthor;
		this.booksTotalStock = booksTotalStock;
		this.price = price;
		this.displayId = displayId;
		this.displayShelf = displayShelf;
		this.displayColumn = displayColumn;
		this.displayRow = displayRow;
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
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the displayId
	 */
	public String getDisplayId() {
		return displayId;
	}

	/**
	 * @param displayId
	 *            the displayId to set
	 */
	public void setDisplayId(String displayId) {
		this.displayId = displayId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SearchResult [booksId=" + booksId + ", booksName=" + booksName
				+ ", publisherName=" + publisherName + ", booksISBN="
				+ booksISBN + ", booksAuthor=" + booksAuthor
				+ ", booksTotalStock=" + booksTotalStock + ", price=" + price
				+ ", displayId=" + displayId + ", displayShelf=" + displayShelf
				+ ", displayColumn=" + displayColumn + ", displayRow="
				+ displayRow + "]";
	}

}
