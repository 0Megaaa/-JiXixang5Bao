package com.soft.biz;

import java.util.List;

import com.soft.bean.TbMenu;
import com.soft.bean.TbRole;
import com.soft.bean.ViewRoleMenu;

public interface RoleMenuBiz {
 public List<ViewRoleMenu>findallview();
 public List<TbRole> findrole();
 public List<TbMenu>findseconid(String menuId);//查2级
 public List<TbMenu>findmenu(TbMenu tbMenu);//加载所有1ji菜单
 
 public List<ViewRoleMenu> findchange(String menuId);
 public List<ViewRoleMenu>findseconid2(String menuId,String roleId);//查2级
 
 public List<ViewRoleMenu> findFirstMenu(String roleId);
 public List<ViewRoleMenu> findSecondMenu(String roleId,String menuPid); 
 public void deleall(ViewRoleMenu viewRoleMenu);
 
 public void newMenu (String roleId,String[] menuArr);
 
 public void addAllFirst(String[] menuArr,String roleId);
}
