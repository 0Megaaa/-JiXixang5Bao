package com.soft.biz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.soft.bean.Page;
import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.bean.ViewWhiteList;
import com.soft.mapper.CarLoginMapper;
import com.soft.mapper.WhiteListMapper;

@Service
public class WhiteListBiz {
	
	@Resource
	private WhiteListMapper mapper;
	
	public Page<ViewWhiteList> getWhitePageInfo(Page page) {
		page.setCurPage(page.getCurPage()==0?1:page.getCurPage());
		page.setPageSize(5);
		RowBounds rb = new RowBounds((page.getCurPage()-1)*page.getPageSize(),page.getPageSize());
		page.setPageList(mapper.getWhiteList(page,rb));
		page.setTotalRecord(mapper.getWhiteList(page).size());
		int all = page.getTotalRecord();
		int size = page.getPageSize();
		page.setTotalPage(all%size ==0?all/size:all/size+1);	//总页数
		return page;
	}
	public Page<ViewWhiteList> getAllWhitePageInfo(Page page) {
		page.setCurPage(page.getCurPage()==0?1:page.getCurPage());
		page.setPageSize(5);
		RowBounds rb = new RowBounds((page.getCurPage()-1)*page.getPageSize(),page.getPageSize());
		page.setPageList(mapper.getAllWhiteList(page,rb));
		page.setTotalRecord(mapper.getAllWhiteList(page).size());
		int all = page.getTotalRecord();
		int size = page.getPageSize();
		page.setTotalPage(all%size ==0?all/size:all/size+1);	//总页数
		return page;
	}
	public void deleteWhite(long whiteId){
		mapper.deleteWhite(whiteId);
	}
	public void createWhite(ViewWhiteList view){
		mapper.createWhite(view);
	}
}
