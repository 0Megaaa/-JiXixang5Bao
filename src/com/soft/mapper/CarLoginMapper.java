package com.soft.mapper;

import java.util.List;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.bean.ViewVip;
import com.soft.bean.ViewWhiteList;



@MyAnnotation
public interface CarLoginMapper {
	
	public void addCar(TbCar car);
	public List<ViewCarPark> findCar(TbCar car);
	public List<ViewWhiteList> findWhite(TbCar car);
	public List<ViewVip> findVip(TbCar car);
}
