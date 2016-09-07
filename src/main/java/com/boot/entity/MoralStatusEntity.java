package com.boot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MORAL_Status")
public class MoralStatusEntity {

	public MoralStatusEntity(int high, int low, int avg, int total) {
		this.high = high;
		this.low = low;
		this.average = avg;
		this.total = total;
	}

	public MoralStatusEntity() {

	}

	@Id
	@Column(nullable = false)
	private String date;

	@Column
	private int high;

	@Column
	private int low;

	@Column
	private int average;

	@Column
	private int total;

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
