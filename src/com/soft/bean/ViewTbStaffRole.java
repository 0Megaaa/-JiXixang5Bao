package com.soft.bean;

import java.util.List;

public class ViewTbStaffRole {
private long staffId;
private String staffName;
private String staffAccount;
private String staffPwd;
private long staffState;
private long staffRole;
private String roleName;
private List<TbStaff>liststaff;
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
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public List<TbStaff> getListstaff() {
	return liststaff;
}
public void setListstaff(List<TbStaff> liststaff) {
	this.liststaff = liststaff;
}
public ViewTbStaffRole(long staffId, String staffName, String staffAccount, String staffPwd, long staffState,
		long staffRole, String roleName, List<TbStaff> liststaff) {
	super();
	this.staffId = staffId;
	this.staffName = staffName;
	this.staffAccount = staffAccount;
	this.staffPwd = staffPwd;
	this.staffState = staffState;
	this.staffRole = staffRole;
	this.roleName = roleName;
	this.liststaff = liststaff;
}
public ViewTbStaffRole() {
	super();
}




	
}
