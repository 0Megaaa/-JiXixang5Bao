package com.soft.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.Page;
import com.soft.bean.TbCar;
import com.soft.bean.ViewWhiteList;



@MyAnnotation
public interface WhiteListMapper {
	
	
	public List<ViewWhiteList> getWhiteList(Page<?> p,RowBounds rb);
	public List<ViewWhiteList> getWhiteList(Page<?> p);
	public void deleteWhite(long whiteId);
	public void createWhite(ViewWhiteList view);
}
