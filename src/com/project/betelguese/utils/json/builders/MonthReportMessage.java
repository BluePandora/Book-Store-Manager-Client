package com.project.betelguese.utils.json.builders;

import java.util.List;

import com.project.betelguese.utils.items.MonthReport;

public class MonthReportMessage extends ServiceMessage {

	private List<MonthReport> reports;

	public MonthReportMessage() {
		this(0, null);
	}

	public MonthReportMessage(int done, String message) {
		this(done, message, null);
		// TODO Auto-generated constructor stub
	}

	public MonthReportMessage(int done, String message, String requestName) {
		this(done, message, requestName, null);
	}

	public MonthReportMessage(int done, String message, String requestName,
			List<MonthReport> reports) {
		super(done, message, requestName);
		this.reports = reports;
	}

	/**
	 * @return the reports
	 */
	public List<MonthReport> getReports() {
		return reports;
	}

	/**
	 * @param reports
	 *            the reports to set
	 */
	public void setReports(List<MonthReport> reports) {
		this.reports = reports;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MonthReportMessage [reports=" + reports + "]";
	}

}
