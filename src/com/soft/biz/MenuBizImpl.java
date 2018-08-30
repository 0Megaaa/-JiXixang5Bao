package com.soft.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbMenu;
import com.soft.mapper.MenuMapper;

@Service
public class MenuBizImpl implements MenuBiz {
@Resource
	private MenuMapper menuMapper;
	
	@Override
	public List<TbMenu> findMenu() {

		List<TbMenu>tbMenus=menuMapper.findMenu();
		return tbMenus;
	}

	@Override
	public void Menudelete(TbMenu tbMenu) {
    menuMapper.Menudelete(tbMenu);
	}

	@Override
	public void MenuInsert(TbMenu tbMenu) {
    menuMapper.MenuInsert(tbMenu);		
	}

	@Override
	public void MenuIsert2(TbMenu tbMenu) {
		menuMapper.MenuIsert2(tbMenu);
	}

	@Override
	public TbMenu selectmenu(TbMenu tbMenu) {
		TbMenu tbMenu2=menuMapper.selectmenu(tbMenu);
		return tbMenu2;
	}

}
