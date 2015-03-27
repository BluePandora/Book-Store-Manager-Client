package com.project.betelguese.utils.items;

public class UpdateSearchResult extends SearchResult {

	private String comment;
	private String totalPaid;
	private String sellerName;
	private String quantity;
	private String adminName;

	public UpdateSearchResult() {
		this(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null);
	}

	/**
	 * 
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
	 * @param comment
	 * @param totalPaid
	 * @param sellerName
	 * @param quantity
	 * @param adminName
	 */
	public UpdateSearchResult(String booksId, String booksName,
			String publisherName, String booksISBN, String booksAuthor,
			String booksTotalStock, String price, String displayId,
			String displayShelf, String displayColumn, String displayRow,
			String comment, String totalPaid, String sellerName,
			String quantity, String adminName) {
		super(booksId, booksName, publisherName, booksISBN, booksAuthor,
				booksTotalStock, price, displayId, displayShelf, displayColumn,
				displayRow);
		this.comment = comment;
		this.totalPaid = totalPaid;
		this.sellerName = sellerName;
		this.quantity = quantity;
		this.adminName = adminName;
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

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminName() {
		return adminName;
	}

	/**
	 * @param comment
	 * @param totalPaid
	 * @param sellerName
	 * @param quantity
	 * @param adminName
	 */
	public UpdateSearchResult(String comment, String totalPaid,
			String sellerName, String quantity, String adminName) {
		this.comment = comment;
		this.totalPaid = totalPaid;
		this.sellerName = sellerName;
		this.quantity = quantity;
		this.adminName = adminName;
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
				+ quantity + ", adminName=" + adminName + "]";
	}

}
