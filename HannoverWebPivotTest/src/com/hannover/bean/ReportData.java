package com.hannover.bean;

public class ReportData {
	private String status;
	private String trendName;
	private Integer count;
	private Integer countTotal;
	private double percentage;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTrendName() {
		return trendName;
	}
	public void setTrendName(String trendName) {
		this.trendName = trendName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getCountTotal() {
		return countTotal;
	}
	public void setCountTotal(Integer countTotal) {
		this.countTotal = countTotal;
	}
	public double getPercentage() {
//		if(getCount() != null && getCountTotal() != null){
//			return (getCount()*100).doubleValue()/getCountTotal().doubleValue();
//		}
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
}
