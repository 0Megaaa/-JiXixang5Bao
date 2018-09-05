package com.soft.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbMenu;
import com.soft.bean.TbRole;
import com.soft.bean.ViewRoleMenu;

@MyAnnotation
public interface IndextMenuMapper {
	
	 public List<TbMenu>findOneMenu(long roleid);
	 
	 public List<TbMenu>findTwoMenu(long muneid,long roleid);
	 
 
	 
	 
	 
	
}
