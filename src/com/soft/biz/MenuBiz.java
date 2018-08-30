package com.soft.biz;

import java.util.List;

import com.soft.bean.TbMenu;

public interface MenuBiz {
	
	public List<TbMenu> findMenu();//拉取全部菜单数据
	public void Menudelete(TbMenu tbMenu);
	public void MenuInsert(TbMenu tbMenu);//一级菜单添加
	public void MenuIsert2(TbMenu tbMenu);//二级菜单添加
	public TbMenu selectmenu(TbMenu tbMenu);
	

}
