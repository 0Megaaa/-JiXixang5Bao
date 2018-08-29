package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class ViewCharge {

	//整合车和车位信息。


	private long chId;
	private long carId;
	private long staffId;
	private long money;
	private long sumMoney;
	private String chargeTime;
	private String chType;
	private long ocuser;
	private long pauser;
	private long parkTime;
	public ViewCharge() {
				
	}
	
	public long getSumMoney() {
		return sumMoney;
	}

	public void setSumMoney(long sumMoney) {
		this.sumMoney = sumMoney;
	}

	public long getParkTime() {
		return parkTime;
	}

	public void setParkTime(long parkTime) {
		this.parkTime = parkTime;
	}

	public long getOcuser() {
		return ocuser;
	}

	public void setOcuser(long ocuser) {
		this.ocuser = ocuser;
	}

	public long getPauser() {
		return pauser;
	}

	public void setPauser(long pauser) {
		this.pauser = pauser;
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
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
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
	
	
}
