package com.soft.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.Page;
import com.soft.bean.TbCar;
import com.soft.bean.TbPackages;
import com.soft.bean.ViewCharge;
import com.soft.bean.ViewVip;
import com.soft.bean.ViewWhiteList;



@MyAnnotation
public interface ChargeListMapper {
	
	
	public List<ViewCharge> getChargeList(Page<?> p,RowBounds rb);
	public List<ViewCharge> getChargeList(Page<?> p);
	public List<ViewCharge> findSumMoney();
	public List<ViewCharge> findSumPark();
	public List<ViewVip> findPackageMoney(Page<?> p,RowBounds rb);
	public List<ViewVip> findPackageMoney(Page<?> p);
	public List<TbPackages> findPackageList();
}
