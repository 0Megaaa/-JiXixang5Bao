package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class TbBill {
private long billId;
private String cheduleDate;
private String cheduleType;
private long moneyCount;
public long getBillId() {
	return billId;
}
public void setBillId(long billId) {
	this.billId = billId;
}
public String getCheduleDate() {
	return cheduleDate;
}
public void setCheduleDate(String cheduleDate) {
	this.cheduleDate = cheduleDate;
}
public String getCheduleType() {
	return cheduleType;
}
public void setCheduleType(String cheduleType) {
	this.cheduleType = cheduleType;
}
public long getMoneyCount() {
	return moneyCount;
}
public void setMoneyCount(long moneyCount) {
	this.moneyCount = moneyCount;
}
public TbBill() {
	super();
	// TODO Auto-generated constructor stub
}
public TbBill(long billId, String cheduleDate, String cheduleType, long moneyCount) {
	super();
	this.billId = billId;
	this.cheduleDate = cheduleDate;
	this.cheduleType = cheduleType;
	this.moneyCount = moneyCount;
}
	
	
	
}
