package com.soft.bean;

import java.util.List;

public class TbMenu {

	private long menuId;
	private long menuPid;
	private String menuName;
	private String menuLink;
	
	private List<TbMenu>secondList;
	private List<ViewRoleMenu>secondList2;


	public List<ViewRoleMenu> getSecondList2() {
		return secondList2;
	}



	public List<TbMenu> getSecondList() {
		return secondList;
	}



	public void setSecondList(List<TbMenu> secondList) {
		this.secondList = secondList;
	}



	public void setSecondList2(List<ViewRoleMenu> secondList2) {
		this.secondList2 = secondList2;
	}



	



	



	public long getMenuId() {
		return menuId;
	}



	public void setMenuId(long menuId) {
		this.menuId = menuId;
	}



	public long getMenuPid() {
		return menuPid;
	}



	public void setMenuPid(long menuPid) {
		this.menuPid = menuPid;
	}



	public String getMenuName() {
		return menuName;
	}



	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}



	public String getMenuLink() {
		return menuLink;
	}



	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}

	





	public TbMenu(long menuId, long menuPid, String menuName, String menuLink, List<TbMenu> secondList,
			List<ViewRoleMenu> secondList2) {
		super();
		this.menuId = menuId;
		this.menuPid = menuPid;
		this.menuName = menuName;
		this.menuLink = menuLink;
		this.secondList = secondList;
		this.secondList2 = secondList2;
	}



	public TbMenu() {
		super();
	}
	
	
	
}
