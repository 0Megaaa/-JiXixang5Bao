package com.soft.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.soft.bean.Page;
import com.soft.bean.TbCar;
import com.soft.bean.TbPackages;
import com.soft.bean.TbVip;
import com.soft.bean.ViewCarPark;
import com.soft.bean.ViewCharge;
import com.soft.bean.ViewVip;
import com.soft.bean.ViewWhiteList;
import com.soft.mapper.CarLoginMapper;
import com.soft.mapper.ChargeListMapper;
import com.soft.mapper.WhiteListMapper;

@Service
public class ChargeListBiz {
	
	@Resource
	private ChargeListMapper mapper;
	
	public Page<ViewCharge> getWhitePageInfo(Page page) {
		page.setCurPage(page.getCurPage()==0?1:page.getCurPage());
		page.setPageSize(5);
		RowBounds rb = new RowBounds((page.getCurPage()-1)*page.getPageSize(),page.getPageSize());
		page.setPageList(mapper.getChargeList(page,rb));
		page.setTotalRecord(mapper.getChargeList(page).size());
		int all = page.getTotalRecord();
		int size = page.getPageSize();
		page.setTotalPage(all%size ==0?all/size:all/size+1);	//总页数
		return page;
	}
	public Page<ViewVip> getPackageMoney(Page page) {
		page.setCurPage(page.getCurPage()==0?1:page.getCurPage());
		page.setPageSize(5);
		RowBounds rb = new RowBounds((page.getCurPage()-1)*page.getPageSize(),page.getPageSize());
		page.setPageList(mapper.findPackageMoney(page,rb));
		page.setTotalRecord(mapper.findPackageMoney(page).size());
		int all = page.getTotalRecord();
		int size = page.getPageSize();
		page.setTotalPage(all%size ==0?all/size:all/size+1);	//总页数
		return page;
	}
	public List<ViewCharge> findSumMoney(){
		return mapper.findSumMoney();
	}
	public List<ViewCharge> findSumPark(){
		return mapper.findSumPark();
	}
	public List<TbPackages> findPackageList(){
		return mapper.findPackageList();
	}
}
