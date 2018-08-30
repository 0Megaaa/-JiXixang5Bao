package com.soft.bean;

public class TbRole {
private long roleId;
private String roleName;
public long getRoleId() {
	return roleId;
}
public void setRoleId(long roleId) {
	this.roleId = roleId;
}
public String getRoleName() {
	return roleName;
}
public void setRoleName(String roleName) {
	this.roleName = roleName;
}
public TbRole(long roleId, String roleName) {
	super();
	this.roleId = roleId;
	this.roleName = roleName;
}
public TbRole() {
	super();
}

}
