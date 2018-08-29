package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class TbBill {
private long billId;
private String scheduleDate;
private String scheduleType;
private long moneyCount;
public long getBillId() {
	return billId;
}
public void setBillId(long billId) {
	this.billId = billId;
}
public long getMoneyCount() {
	return moneyCount;
}
public void setMoneyCount(long moneyCount) {
	this.moneyCount = moneyCount;
}

public String getScheduleDate() {
	return scheduleDate;
}
public void setScheduleDate(String scheduleDate) {
	this.scheduleDate = scheduleDate;
}
public String getScheduleType() {
	return scheduleType;
}
public void setScheduleType(String scheduleType) {
	this.scheduleType = scheduleType;
}
public TbBill() {
	super();
	// TODO Auto-generated constructor stub
}
public TbBill(long billId, String scheduleDate, String scheduleType, long moneyCount) {
	super();
	this.billId = billId;
	this.scheduleDate = scheduleDate;
	this.scheduleType = scheduleType;
	this.moneyCount = moneyCount;
}
	
	
	
}
