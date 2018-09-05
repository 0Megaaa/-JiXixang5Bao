package com.soft.biz;

import java.util.List;

import com.soft.bean.TbMenu;
import com.soft.bean.TbRole;
import com.soft.bean.ViewRoleMenu;

public interface IndextMenuBiz {

	 public List<TbMenu>findOneMenu(long roleid);
	 
	 public List<TbMenu>findTwoMenu(long muneid,long roleid);
 

 
 
}
