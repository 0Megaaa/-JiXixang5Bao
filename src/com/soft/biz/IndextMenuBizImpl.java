package com.soft.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbMenu;
import com.soft.bean.TbRole;
import com.soft.bean.ViewRoleMenu;
import com.soft.mapper.IndextMenuMapper;
import com.soft.mapper.RoleMenuMapper;
@Service
public class IndextMenuBizImpl implements IndextMenuBiz{
	@Resource
	private IndextMenuMapper indextMenuMapper;

	@Override
	public List<TbMenu> findOneMenu(long roleid) {
		// TODO Auto-generated method stub
		
		return indextMenuMapper.findOneMenu(roleid);
	}

	@Override
	public List<TbMenu> findTwoMenu(long muneid,long roleid) {
		// TODO Auto-generated method stub
		
		return indextMenuMapper.findTwoMenu(muneid,roleid);
	}
	 
	 

}
