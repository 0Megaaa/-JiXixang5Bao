package com.soft.bean;

public class ViewBill {

	private long chId;
	private long carId;
	private long  money;
	private long  staffId;
	private String chargeTime;
	private String carNum;
	private String staffName;
	public ViewBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViewBill(long chId, long carId, long money, long staffId, String chargeTime, String carNum,
			String staffName) {
		super();
		this.chId = chId;
		this.carId = carId;
		this.money = money;
		this.staffId = staffId;
		this.chargeTime = chargeTime;
		this.carNum = carNum;
		this.staffName = staffName;
	}
	public long getChId() {
		return chId;
	}
	public void setChId(long chId) {
		this.chId = chId;
	}
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public String getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(String chargeTime) {
		this.chargeTime = chargeTime;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	
	
}
