package com.project.betelguese.utils.items;

import java.util.List;

public class UpdateItems {

	List<UpdateBook> addBooks;

	public UpdateItems() {
	}

	/**
	 * @param addBooks
	 */
	public UpdateItems(List<UpdateBook> addBooks) {
		this.addBooks = addBooks;
	}

	/**
	 * @return the addBooks
	 */
	public List<UpdateBook> getAddBooks() {
		return addBooks;
	}

	/**
	 * @param addBooks
	 *            the addBooks to set
	 */
	public void setAddBooks(List<UpdateBook> addBooks) {
		this.addBooks = addBooks;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UpdateItems [addBooks=" + addBooks + "]";
	}

}
