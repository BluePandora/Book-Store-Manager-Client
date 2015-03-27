package com.project.betelguese.utils.json.builders;

import java.util.List;

import com.project.betelguese.utils.items.YearReport;

public class YearReportMessage extends ServiceMessage {

	private String maxYear;
	private String minYear;
	private List<YearReport> reports;

	public YearReportMessage() {
		this(0, null);
	}

	public YearReportMessage(int done, String message) {
		this(done, message, null);
		// TODO Auto-generated constructor stub
	}

	public YearReportMessage(int done, String message, String requestName) {
		this(done, message, requestName, null, null, null);
		// TODO Auto-generated constructor stub
	}

	public YearReportMessage(int done, String message, String requestName,
			String maxYear, String minYear, List<YearReport> reports) {
		super(done, message, requestName);
		this.maxYear = maxYear;
		this.minYear = minYear;
		this.reports = reports;
	}

	/**
	 * @return the maxYear
	 */
	public String getMaxYear() {
		return maxYear;
	}

	/**
	 * @param maxYear
	 *            the maxYear to set
	 */
	public void setMaxYear(String maxYear) {
		this.maxYear = maxYear;
	}

	/**
	 * @return the minYear
	 */
	public String getMinYear() {
		return minYear;
	}

	/**
	 * @param minYear
	 *            the minYear to set
	 */
	public void setMinYear(String minYear) {
		this.minYear = minYear;
	}

	/**
	 * @return the reports
	 */
	public List<YearReport> getReports() {
		return reports;
	}

	/**
	 * @param reports
	 *            the reports to set
	 */
	public void setReports(List<YearReport> reports) {
		this.reports = reports;
	}

	/**
	 * @param reports
	 */
	public YearReportMessage(List<YearReport> reports) {
		this.reports = reports;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "YearReportMessage [maxYear=" + maxYear + ", minYear=" + minYear
				+ ", reports=" + reports + "]";
	}

}
