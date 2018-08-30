package com.soft.biz;


import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;

public interface CarOutBiz {
//找车计费//获取场中照片
	public TbCar findCarOut(TbCar Car );

	//添加出场照片路径
		TbCar addCarOut(TbCar Car);
 
}
