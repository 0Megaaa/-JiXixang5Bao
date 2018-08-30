package com.soft.mapper;

import java.util.List;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.ViewCarPark;
@MyAnnotation
public interface CarParkCheckMapper {

	List<ViewCarPark> findAll();
	 
	
}
