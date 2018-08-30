package com.soft.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.ViewCarPark;
import com.soft.mapper.CarParkCheckMapper;

@Service
public class CarParkCheckBizImpl implements CarParkCheckBiz {

	@Resource
	private CarParkCheckMapper carParkMapper;

 
	@Override
	public List<ViewCarPark> queryAllCarPark() {
		// TODO Auto-generated method stub
		List<ViewCarPark> list = carParkMapper.findAll();
		return list;
	}

	 

}
