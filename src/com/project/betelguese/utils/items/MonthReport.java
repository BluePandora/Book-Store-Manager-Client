package com.project.betelguese.utils.items;

/**
 * @author tuman
 *
 */
public class MonthReport {

	private String month;
	private String value;

	public MonthReport() {
	}

	/**
	 * @param month
	 * @param value
	 */
	public MonthReport(String month, String value) {
		this.month = month;
		this.value = value;
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MonthReport [month=" + month + ", value=" + value + "]";
	}

}
