package com.joe.ajax;

public class StockVO {
	private double yesterdayEndPrice;
	private double todayStartPrice;
	private double currentPrice;
	private String stockName;
	private String stockId;
	
	@Override
	public String toString() {
		return this.stockName + ":" + this.currentPrice;
	}
	
	public double getYesterdayEndPrice() {
		return yesterdayEndPrice;
	}
	public void setYesterdayEndPrice(double yesterdayEndPrice) {
		this.yesterdayEndPrice = yesterdayEndPrice;
	}
	public double getTodayStartPrice() {
		return todayStartPrice;
	}
	public void setTodayStartPrice(double todayStartPrice) {
		this.todayStartPrice = todayStartPrice;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
}
