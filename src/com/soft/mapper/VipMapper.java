package com.soft.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.Page;
import com.soft.bean.TbPackages;
import com.soft.bean.TbVip;
import com.soft.bean.ViewVip;


@MyAnnotation
public interface VipMapper {
	
	public List<ViewVip> getVipList(Page<?> p,RowBounds rb);
	public List<ViewVip> getVipList(Page<?> p);
	public List<TbPackages> getPackagesSelect();
	public void addVip(ViewVip viewVip);
	public TbPackages getPackageById(String paId);
	public ViewVip getVipById(String vipId);
	public void deleteVip(String vipId);
	public TbVip carNumCheck(String carNum);
	public int clearVip(List<TbVip> vipClearList);
	public List<ViewVip> findAllVip(); 
}
