package com.soft.bean;

public class TbWhiteList {
private long whiteId;
private String carNum;
private long whiteState;
private String startDate;
public long getWhiteId() {
	return whiteId;
}
public void setWhiteId(long whiteId) {
	this.whiteId = whiteId;
}
public String getCarNum() {
	return carNum;
}
public void setCarNum(String carNum) {
	this.carNum = carNum;
}
public long getWhiteState() {
	return whiteState;
}
public void setWhiteState(long whiteState) {
	this.whiteState = whiteState;
}
public String getStartDate() {
	return startDate;
}
public void setStartDate(String startDate) {
	this.startDate = startDate;
}
public TbWhiteList() {
	super();
	// TODO Auto-generated constructor stub
}
public TbWhiteList(long whiteId, String carNum, long whiteState, String startDate) {
	super();
	this.whiteId = whiteId;
	this.carNum = carNum;
	this.whiteState = whiteState;
	this.startDate = startDate;
}




}
