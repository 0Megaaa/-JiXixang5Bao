package com.soft.biz;


import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;

public interface PayChannelBiz {
	//自助缴费
		public long findAotuChannel();
		//手机端缴费
		public long findPhoneChannel();
 
}
