package com.soft.bean;

public class TbStaff {
	private long staffId;
	private String staffName;
	private String staffAccount;
	private String staffPwd;
	private long staffState;
	private long staffRole;
	public long getStaffId() {
		return staffId;
	}
	public void setStaffId(long staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffAccount() {
		return staffAccount;
	}
	public void setStaffAccount(String staffAccount) {
		this.staffAccount = staffAccount;
	}
	public String getStaffPwd() {
		return staffPwd;
	}
	public void setStaffPwd(String staffPwd) {
		this.staffPwd = staffPwd;
	}
	public long getStaffState() {
		return staffState;
	}
	public void setStaffState(long staffState) {
		this.staffState = staffState;
	}
	public long getStaffRole() {
		return staffRole;
	}
	public void setStaffRole(long staffRole) {
		this.staffRole = staffRole;
	}
	public TbStaff(long staffId, String staffName, String staffAccount, String staffPwd, long staffState,
			long staffRole) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffAccount = staffAccount;
		this.staffPwd = staffPwd;
		this.staffState = staffState;
		this.staffRole = staffRole;
	}
	public TbStaff() {
		super();
	}
	
	
	
	
	

}
