package com.boot.models;

public class AggregatMoralStatusVO {

	public AggregatMoralStatusVO(String high, String low, String average) {
		this.high = high;
		this.low = low;
		this.average = average;
	}

	public AggregatMoralStatusVO() {

	}

	private String high;
	private String low;
	private String average;

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getAverage() {
		return average;
	}

	public void setAverage(String average) {
		this.average = average;
	}

}
