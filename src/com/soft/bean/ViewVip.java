package com.soft.bean;

public class ViewVip {
	
	private long vipId;
	private String carNum;
	private String startDate;
	private long paId;
	private long vipState;
	private String paTime;
	private long paPrice;
	private long money;
	public ViewVip() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViewVip(long vipId, String carNum, String startDate, long paId, long vipState, String paTime, long paPrice) {
		super();
		this.vipId = vipId;
		this.carNum = carNum;
		this.startDate = startDate;
		this.paId = paId;
		this.vipState = vipState;
		this.paTime = paTime;
		this.paPrice = paPrice;
	}
	
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public long getVipId() {
		return vipId;
	}
	public void setVipId(long vipId) {
		this.vipId = vipId;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public long getPaId() {
		return paId;
	}
	public void setPaId(long paId) {
		this.paId = paId;
	}
	public long getVipState() {
		return vipState;
	}
	public void setVipState(long vipState) {
		this.vipState = vipState;
	}
	public String getPaTime() {
		return paTime;
	}
	public void setPaTime(String paTime) {
		this.paTime = paTime;
	}
	public long getPaPrice() {
		return paPrice;
	}
	public void setPaPrice(long paPrice) {
		this.paPrice = paPrice;
	}
	
	
}
