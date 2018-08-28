package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class ViewCarPark {

	//整合车和车位信息。


		private long carId;
		private String  carNum;
		private String startTime;
			private String endTime;
			private long userType;
			private long payState;
			private String enterImgSrc;
			private String outImgSrc;
			private String parkImgSrc;
			private long parkId;
			 private String prefix;
			 private String parkNum;
			 private long parkState;
			 private long parkX;
			 private long parkY;
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
			public ViewCarPark() {
				super();
				// TODO Auto-generated constructor stub
			}
			public ViewCarPark(long carId, String carNum, String startTime, String endTime, long userType,
					long payState, String enterImgSrc, String outImgSrc, String parkImgSrc, long parkId, String prefix,
					String parkNum, long parkState, long parkX, long parkY) {
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
				this.parkId = parkId;
				this.prefix = prefix;
				this.parkNum = parkNum;
				this.parkState = parkState;
				this.parkX = parkX;
				this.parkY = parkY;
			}
			 
			 
}
