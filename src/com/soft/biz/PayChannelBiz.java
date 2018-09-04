package com.soft.biz;


import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.bean.ViewMonthService;
import com.soft.bean.ViewTollChannel;
import com.soft.bean.ViewAutoService;
import com.soft.bean.ViewBar;

public interface PayChannelBiz {
	//自助缴费
		public ViewAutoService findAutoChannel(ViewBar viewBar);
		 
		//收费端缴费
		public ViewTollChannel findTollChannel(ViewBar viewBar);
		//月缴
		public ViewMonthService findMonthServic(ViewBar viewBar);
 
}
