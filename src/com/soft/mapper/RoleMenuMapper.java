package com.soft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbMenu;
import com.soft.bean.TbRole;
import com.soft.bean.ViewRoleMenu;

@MyAnnotation
public interface RoleMenuMapper {
	 public List<ViewRoleMenu>findallview();
	 public List<TbMenu>findmenu(TbMenu tbMenu);
	 public List<TbMenu>findseconid(String menuId);//查2级
	 public List<TbRole> findrole();
	 
	 public List<ViewRoleMenu> findchange(String roleId);
	 public List<ViewRoleMenu> findSecond(String menuId,String roleId);//查2级
	 
	 //tip1
	 public List<ViewRoleMenu> findFirstMenu(String roleId);
	 public List<ViewRoleMenu> findSecondMenu(String roleId,String menuPid);
	 public void deleall(ViewRoleMenu viewRoleMenu);
	 public void newMenu (String roleId,String menuId);
	 public List<TbMenu> newMenu2(String[] array);
	 public void addFisrtMenu(String roleId,String menuId);
	 
	
}
