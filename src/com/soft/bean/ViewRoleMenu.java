package com.soft.bean;

import java.util.List;

public class ViewRoleMenu {
	
	private long menuId;
	private String menuName;
	private long roleId;
	private String roleName;
	private long menuPid;
	
	
	private List<TbMenu>secondList;
	private List<ViewRoleMenu>secondList2;
	
	
	public List<ViewRoleMenu> getSecondList2() {
		return secondList2;
	}
	public void setSecondList2(List<ViewRoleMenu> secondList2) {
		this.secondList2 = secondList2;
	}
	public List<TbMenu> getSecondList() {
		return secondList;
	}
	public void setSecondList(List<TbMenu> secondList) {
		this.secondList = secondList;
	}
	public long getMenuId() {
		return menuId;
	}
	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	public ViewRoleMenu(long menuId, String menuName, long roleId, String roleName, long menuPid,
			List<TbMenu> secondList) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.roleId = roleId;
		this.roleName = roleName;
		this.menuPid = menuPid;
		this.secondList = secondList;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public ViewRoleMenu() {
		super();
	}
	public long getMenuPid() {
		return menuPid;
	}
	public void setMenuPid(long menuPid) {
		this.menuPid = menuPid;
	}
	
	

}
