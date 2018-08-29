package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class TbCharge {
private long chId;
private long carId;
private long  money;
private long  staffId;
private String chargeTime;

private String chType;
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



public String getChType() {
	return chType;
}
public void setChType(String chType) {
	this.chType = chType;
}
public TbCharge() {
	super();
	// TODO Auto-generated constructor stub
}
public TbCharge(long chId, long carId, long money, long staffId, String chargeTime, String chType) {
	super();
	this.chId = chId;
	this.carId = carId;
	this.money = money;
	this.staffId = staffId;
	this.chargeTime = chargeTime;
	this.chType = chType;
}





	
	
}
