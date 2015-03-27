package com.project.betelguese.utils.items;

/**
 * @author tuman
 *
 */
public class DayReport {

	private String day;
	private String value;

	public DayReport() {
	}

	/**
	 * @param day
	 * @param value
	 */
	public DayReport(String day, String value) {
		this.day = day;
		this.value = value;
	}

	/**
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * @param day
	 *            the day to set
	 */
	public void setDay(String day) {
		this.day = day;
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
		return "DayReport [day=" + day + ", value=" + value + "]";
	}

}
