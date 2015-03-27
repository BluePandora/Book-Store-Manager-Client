package com.project.betelguese.utils.items;

public class ReportServiceValue {

	private String serviceName;
	private String yearValue;
	private String monthValue;

	public ReportServiceValue() {
	}

	/**
	 * @param serviceName
	 * @param yearValue
	 * @param monthValue
	 */
	public ReportServiceValue(String serviceName, String yearValue,
			String monthValue) {
		this.serviceName = serviceName;
		this.yearValue = yearValue;
		this.monthValue = monthValue;
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @param serviceName
	 *            the serviceName to set
	 */
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/**
	 * @return the yearValue
	 */
	public String getYearValue() {
		return yearValue;
	}

	/**
	 * @param yearValue
	 *            the yearValue to set
	 */
	public void setYearValue(String yearValue) {
		this.yearValue = yearValue;
	}

	/**
	 * @return the monthValue
	 */
	public String getMonthValue() {
		return monthValue;
	}

	/**
	 * @param monthValue
	 *            the monthValue to set
	 */
	public void setMonthValue(String monthValue) {
		this.monthValue = monthValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ReportServiceValue [serviceName=" + serviceName
				+ ", yearValue=" + yearValue + ", monthValue=" + monthValue
				+ "]";
	}

}
