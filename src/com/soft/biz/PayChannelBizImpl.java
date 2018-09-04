package com.soft.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.bean.ViewMonthService;
import com.soft.bean.ViewTollChannel;
import com.soft.bean.ViewAutoService;
import com.soft.bean.ViewBar;
import com.soft.mapper.CarOutMapper;
import com.soft.mapper.PayChannelMapper;
import com.soft.mapper.PayCheckParkMapper;

@Service
public class PayChannelBizImpl implements PayChannelBiz {

	
	@Resource
	private PayChannelMapper payChannelMapper;
	@Override
	public ViewAutoService findAutoChannel(ViewBar viewBar) {
		// TODO Auto-generated method stub
		
		return payChannelMapper.findAutoChannel(viewBar);
	}
	@Override
	public ViewTollChannel findTollChannel(ViewBar viewBar) {
		// TODO Auto-generated method stub
		return payChannelMapper.findTollChannel(viewBar);
	}
	@Override
	public ViewMonthService findMonthServic(ViewBar viewBar) {
		// TODO Auto-generated method stub
		return payChannelMapper.findMonthServic(viewBar);
	}

	 

 

 

 
}
