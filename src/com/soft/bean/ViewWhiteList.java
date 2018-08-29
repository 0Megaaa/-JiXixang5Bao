package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class ViewWhiteList {

	//整合车和车位信息。


	private long whiteId;
	private String carNum;
	private String startDate;
	public ViewWhiteList() {
				
	}
	public ViewWhiteList(long whiteId,String carNum,String startDate) {
		this.whiteId=whiteId;
		this.carNum=carNum;
		this.startDate=startDate;
	}
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}	 
			 
}
