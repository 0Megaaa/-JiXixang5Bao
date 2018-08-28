package com.soft.bean;

public class TbVip {

	private long vipId;
	private String carNum;
	private String startDate;
	private long paId;
	private long vipState;
	
	public TbVip() {
		super();
	}
	public TbVip(long vipId, String carNum, String startDate, long paId, long vipState) {
		super();
		this.vipId = vipId;
		this.carNum = carNum;
		this.startDate = startDate;
		this.paId = paId;
		this.vipState = vipState;
	}
	public long getVipId() {
		return vipId;
	}
	public void setVipId(long vipId) {
		this.vipId = vipId;
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
	public long getPaId() {
		return paId;
	}
	public void setPaId(long paId) {
		this.paId = paId;
	}
	public long getVipState() {
		return vipState;
	}
	public void setVipState(long vipState) {
		this.vipState = vipState;
	}
	
	
}
