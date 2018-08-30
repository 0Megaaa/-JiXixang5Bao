package com.soft.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.mapper.CarOutMapper;
import com.soft.mapper.PayChannelMapper;
import com.soft.mapper.PayCheckParkMapper;

@Service
public class PayChannelBizImpl implements PayChannelBiz {

	
	@Resource
	private PayChannelMapper payChannelMapper;
	@Override
	public long findAotuChannel() {
		// TODO Auto-generated method stub
		
		return payChannelMapper.findAotuChannel();
	}

	@Override
	public long findPhoneChannel() {
		// TODO Auto-generated method stub
		return payChannelMapper.findPhoneChannel();
	}

 

 

 
}
