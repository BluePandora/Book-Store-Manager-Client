package com.project.betelguese.utils.json.builders;

import java.util.List;

import com.project.betelguese.utils.items.SearchResult;

public class SearchMessage extends ServiceMessage {

	private List<SearchResult> searchResult;

	/**
	 * 
	 */
	public SearchMessage() {
		this(0, null);
	}

	/**
	 * 
	 * @param done
	 * @param message
	 */
	public SearchMessage(int done, String message) {
		this(done, message, null);
	}

	/**
	 * 
	 * @param done
	 * @param message
	 * @param requestName
	 */
	public SearchMessage(int done, String message, String requestName) {
		this(done, message, requestName, null);
	}

	/**
	 * @param searchResult
	 */
	public SearchMessage(List<SearchResult> searchResult) {
		this(0, null, null, searchResult);
	}

	public SearchMessage(int done, String message, String requestName,
			List<SearchResult> searchResult) {
		super(done, message, requestName);
		this.searchResult = searchResult;
	}

	/**
	 * @return the searchResult
	 */
	public List<SearchResult> getSearchResult() {
		return searchResult;
	}

	/**
	 * @param searchResult
	 *            the searchResult to set
	 */
	public void setSearchResult(List<SearchResult> searchResult) {
		this.searchResult = searchResult;
	}
}
