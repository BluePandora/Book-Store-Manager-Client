package com.project.betelguese.utils.items;

/**
 * @author tuman
 *
 */
public class YearReport {

	private String year;
	private String value;

	public YearReport() {
	}

	/**
	 * @param year
	 * @param value
	 */
	public YearReport(String year, String value) {
		this.year = year;
		this.value = value;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year
	 *            the year to set
	 */
	public void setYear(String year) {
		this.year = year;
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
		return "YearReport [year=" + year + ", value=" + value + "]";
	}

}
