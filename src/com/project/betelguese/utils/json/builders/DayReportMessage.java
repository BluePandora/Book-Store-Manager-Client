package com.project.betelguese.utils.json.builders;

import java.util.List;

import com.project.betelguese.utils.items.DayReport;

public class DayReportMessage extends ServiceMessage {

	private String month;
	private List<DayReport> reports;

	public DayReportMessage() {
		this(0, null);
	}

	public DayReportMessage(int done, String message) {
		this(done, message, null);
		// TODO Auto-generated constructor stub
	}

	public DayReportMessage(int done, String message, String requestName) {
		this(done, message, requestName, null, null);
	}

	public DayReportMessage(int done, String message, String requestName,
			String month, List<DayReport> reports) {
		super(done, message, requestName);
		this.month = month;
		this.reports = reports;
	}

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * @param month
	 *            the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * @return the reports
	 */
	public List<DayReport> getReports() {
		return reports;
	}

	/**
	 * @param reports
	 *            the reports to set
	 */
	public void setReports(List<DayReport> reports) {
		this.reports = reports;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DayReportMessage [month=" + month + ", reports=" + reports
				+ "]";
	}

}
