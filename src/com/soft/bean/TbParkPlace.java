package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class TbParkPlace {

	 private long parkId;
	 private String prefix;
	 private String parkNum;
	 private long parkState;
	 private long parkX;
	 private long parkY;
	 private long carId;
	 
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public long getParkId() {
		return parkId;
	}
	public void setParkId(long parkId) {
		this.parkId = parkId;
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getParkNum() {
		return parkNum;
	}
	public void setParkNum(String parkNum) {
		this.parkNum = parkNum;
	}
	public long getParkState() {
		return parkState;
	}
	public void setParkState(long parkState) {
		this.parkState = parkState;
	}
	public long getParkX() {
		return parkX;
	}
	public void setParkX(long parkX) {
		this.parkX = parkX;
	}
	public long getParkY() {
		return parkY;
	}
	public void setParkY(long parkY) {
		this.parkY = parkY;
	}
	public TbParkPlace() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TbParkPlace(long parkId, String prefix, String parkNum, long parkState, long parkX, long parkY, long carId) {
		super();
		this.parkId = parkId;
		this.prefix = prefix;
		this.parkNum = parkNum;
		this.parkState = parkState;
		this.parkX = parkX;
		this.parkY = parkY;
		this.carId = carId;
	}

	
	
	
	
}
