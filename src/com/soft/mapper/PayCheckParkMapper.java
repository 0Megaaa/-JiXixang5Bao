package com.soft.mapper;


import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbStaff;



@MyAnnotation
public interface PayCheckParkMapper {
	//所有车位
	public long allPark();
	//停车的车位
	public long bePark();
}
