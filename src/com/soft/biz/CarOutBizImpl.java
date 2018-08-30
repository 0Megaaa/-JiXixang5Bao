package com.soft.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.mapper.CarOutMapper;

@Service
public class CarOutBizImpl implements CarOutBiz {

	@Resource
	private CarOutMapper carOutMapper;

	@Override
	public TbCar findCarOut(TbCar Car) {
		TbCar TbCar = carOutMapper.findCarOut(Car);
		return TbCar;
	}

	@Override
	public TbCar addCarOut(TbCar Car) {

		carOutMapper.addCarOut(Car);
		return null;
	}

 
}
