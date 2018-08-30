package com.soft.mapper;


import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
@MyAnnotation
public interface CarOutMapper {
	//找车计费
	TbCar findCarOut(TbCar Car);
	//添加出场照片路径
	void addCarOut(TbCar Car);
 
}
