package com.soft.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbMenu;
import com.soft.bean.TbRole;
import com.soft.bean.ViewRoleMenu;
import com.soft.mapper.RoleMenuMapper;
@Service
public class RoleMenuBizImpl implements RoleMenuBiz{
	@Resource
	private RoleMenuMapper roleMenuMapper;
	@Override
	public List<ViewRoleMenu> findallview() {
		
		List<ViewRoleMenu>roleMenus=roleMenuMapper.findallview();
		return roleMenus;
	}
	@Override
	public List<TbMenu> findmenu(TbMenu tbMenu) {
        List<TbMenu>menus=roleMenuMapper.findmenu(tbMenu);
		return menus;
	}
	@Override
	public List<TbMenu> findseconid(String menuId) {
		List<TbMenu>menus=roleMenuMapper.findseconid(menuId);
		return menus;
	}
	@Override
	public List<TbRole> findrole() {
    List<TbRole>roles=roleMenuMapper.findrole();
		return roles;
	}
	@Override
	public List<ViewRoleMenu> findchange(String menuId) {
		List<ViewRoleMenu>meList=roleMenuMapper.findchange(menuId);
		return meList;
	}
	@Override
	public List<ViewRoleMenu> findseconid2(String menuId, String roleId) {
		
		return roleMenuMapper.findSecond(menuId, roleId);
	}
	
	//tip1
	@Override
	public List<ViewRoleMenu> findFirstMenu(String roleId) {
	
		return roleMenuMapper.findFirstMenu(roleId);
	}
	@Override
	public List<ViewRoleMenu> findSecondMenu(String roleId, String menuPid) {
		
		return roleMenuMapper.findSecondMenu(roleId, menuPid);
	}
//	@Override
//	public void deleall(ViewRoleMenu viewRoleMenu) {
//		return roleMenuMapper.deleall(viewRoleMenu);
//	}
	@Override
	public void deleall(ViewRoleMenu viewRoleMenu) {
		roleMenuMapper.deleall(viewRoleMenu);
	}
	@Override
	public void newMenu(String roleId,String[] menuArr) {
		for (int i = 0; i < menuArr.length; i++) {
			roleMenuMapper.newMenu(roleId,menuArr[i]);
		}
		
	}
	@Override
	public void addAllFirst(String[] menuArr,String roleId) {
		//添加一级菜单
		//step1,查询所有的一级菜单
		
		List<TbMenu> list = roleMenuMapper.newMenu2(menuArr);
		
		//step2,增加查询所有的一级菜单
		for (int i = 0; i < list.size(); i++) {
			TbMenu menu = list.get(i);
			
			roleMenuMapper.addFisrtMenu(roleId, menu.getMenuId()+"");
			
		}
		
		
		
		
	}

}
