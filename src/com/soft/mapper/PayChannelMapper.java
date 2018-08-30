package com.soft.mapper;


import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
@MyAnnotation
public interface PayChannelMapper {
	//自助缴费
	public long findAotuChannel();
	//手机端缴费
	public long findPhoneChannel();
 
}
