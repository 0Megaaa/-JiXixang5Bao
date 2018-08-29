package com.soft.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.Page;
import com.soft.bean.TbPackages;
import com.soft.bean.TbVip;



@MyAnnotation
public interface PackageMapper {
	
	public List<TbPackages> getPackageList(Page<?> p,RowBounds rb);
	public List<TbPackages> getPackageList(Page<?> p);
	public TbPackages getPackageById(String paId);
	public int updatePackage(TbPackages pack);
	public int deletePackage(String paId);
	public int addPackage(TbPackages pack);
	public List<TbVip> findVipByPackageId(String paId);
	public TbPackages timeCheck(String time);
}
