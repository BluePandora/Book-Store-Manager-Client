package com.project.betelguese.utils.json.builders;

import java.util.List;

import com.project.betelguese.utils.items.TransactionReport;

public class TransactionReportMessage extends ServiceMessage {

	private List<TransactionReport> reports;

	public TransactionReportMessage() {
		this(0, null);
	}

	public TransactionReportMessage(int done, String message) {
		this(done, message, null);
		// TODO Auto-generated constructor stub
	}

	public TransactionReportMessage(int done, String message, String requestName) {
		this(done, message, requestName, null);
	}

	public TransactionReportMessage(int done, String message,
			String requestName, List<TransactionReport> reports) {
		super(done, message, requestName);
		this.reports = reports;
	}

	/**
	 * @return the reports
	 */
	public List<TransactionReport> getReports() {
		return reports;
	}

	/**
	 * @param reports
	 *            the reports to set
	 */
	public void setReports(List<TransactionReport> reports) {
		this.reports = reports;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TransactionReportMessage [reports=" + reports + "]";
	}

}
