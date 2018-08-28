package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class TbAppointment {

	private  long appId;
	
	private String carNum;
	private long money;
	private String startTime;
	private String endTime;
	private int flag;
	public long getAppId() {
		return appId;
	}
	public void setAppId(long appId) {
		this.appId = appId;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public long getMoney() {
		return money;
	}
	public void setMoney(long money) {
		this.money = money;
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
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public TbAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TbAppointment(long appId, String carNum, long money, String startTime, String endTime) {
		super();
		this.appId = appId;
		this.carNum = carNum;
		this.money = money;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	
	
	
	
}
