package com.soft.mapper;

import java.util.List;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;



@MyAnnotation
public interface CarLoginMapper {
	
	public void addCar(TbCar car);
	public List<ViewCarPark> findCar(TbCar car);
}
