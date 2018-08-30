package com.soft.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.mapper.CarOutMapper;
import com.soft.mapper.PayCheckParkMapper;

@Service
public class PayCheckParkBizImpl implements PayCheckParkBiz {

	@Resource
	private PayCheckParkMapper payCheckParkMapper;

	@Override
	public long allPark() {
		// TODO Auto-generated method stub

		return payCheckParkMapper.allPark();
	}

	@Override
	public long bePark() {
		// TODO Auto-generated method stub
		return payCheckParkMapper.bePark();
	}

}
