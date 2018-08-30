package com.soft.bean;

import java.util.List;

public class TbMenu {

	private long menuId;
	private long menuPid;
	private String menuName;
	private String menuLink;
	private List<TbMenu>list;
	
	
	
	
	public List<TbMenu> getList() {
		return list;
	}

	public void setList(List<TbMenu> list) {
		this.list = list;
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

	public TbMenu(long menuId, long menuPid, String menuName, String menuLink, List<TbMenu> list) {
		super();
		this.menuId = menuId;
		this.menuPid = menuPid;
		this.menuName = menuName;
		this.menuLink = menuLink;
		this.list = list;
	}

	public TbMenu() {
		super();
	}
	
	
	
}
