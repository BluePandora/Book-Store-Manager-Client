package com.project.betelguese.utils.json.builders;

import java.util.List;

import com.project.betelguese.utils.items.UpdateSearchResult;

public class UpdateSearchMessage extends ServiceMessage {

	List<UpdateSearchResult> searchResult;

	public UpdateSearchMessage() {
		this(0, null);
	}

	public UpdateSearchMessage(int done, String message) {
		this(done, message, null);
	}

	public UpdateSearchMessage(int done, String message, String requestName) {
		super(done, message, requestName);
	}

	public UpdateSearchMessage(int done, String message, String requestName,
			List<UpdateSearchResult> searchResult) {
		super(done, message, requestName);
		this.searchResult = searchResult;
	}

	/**
	 * @return the searchResult
	 */
	public List<UpdateSearchResult> getSearchResult() {
		return searchResult;
	}

	/**
	 * @param searchResult
	 *            the searchResult to set
	 */
	public void setSearchResult(List<UpdateSearchResult> searchResult) {
		this.searchResult = searchResult;
	}

}
