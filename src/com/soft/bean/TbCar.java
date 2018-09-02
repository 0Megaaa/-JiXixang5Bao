package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class TbCar {
private long carId;
private String  carNum;
private String startTime;
	private String endTime;
	private long userType;
	private long payState;
	private String enterImgSrc;
	private String outImgSrc;
	private String parkImgSrc;
	private long payChannel;
	private long  money;
	private String totalTime;
	private String msg;
	public long getCarId() {
		return carId;
	}
	public void setCarId(long carId) {
		this.carId = carId;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public long getUserType() {
		return userType;
	}
	public void setUserType(long userType) {
		this.userType = userType;
	}
	public long getPayState() {
		return payState;
	}
	public void setPayState(long payState) {
		this.payState = payState;
	}
	public String getEnterImgSrc() {
		return enterImgSrc;
	}
	public void setEnterImgSrc(String enterImgSrc) {
		this.enterImgSrc = enterImgSrc;
	}
	public String getOutImgSrc() {
		return outImgSrc;
	}
	public void setOutImgSrc(String outImgSrc) {
		this.outImgSrc = outImgSrc;
	}
	public String getParkImgSrc() {
		return parkImgSrc;
	}
	public void setParkImgSrc(String parkImgSrc) {
		this.parkImgSrc = parkImgSrc;
	}
	
	
	public long getPayChannel() {
		return payChannel;
	}
	public void setPayChannel(long payChannel) {
		this.payChannel = payChannel;
	}
	
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
	}
	
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public TbCar() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public TbCar(long carId, String carNum, String startTime, String endTime, long userType, long payState,
			String enterImgSrc, String outImgSrc, String parkImgSrc, long payChannel, long money, String totalTime,
			String msg) {
		super();
		this.carId = carId;
		this.carNum = carNum;
		this.startTime = startTime;
		this.endTime = endTime;
		this.userType = userType;
		this.payState = payState;
		this.enterImgSrc = enterImgSrc;
		this.outImgSrc = outImgSrc;
		this.parkImgSrc = parkImgSrc;
		this.payChannel = payChannel;
		this.money = money;
		this.totalTime = totalTime;
		this.msg = msg;
	}

}
