package com.soft.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbCar;
import com.soft.bean.ViewCarPark;
import com.soft.bean.ViewVip;
import com.soft.bean.ViewWhiteList;
import com.soft.mapper.CarLoginMapper;

@Service
public class CarLoginBiz {
	
	@Resource
	private CarLoginMapper mapper;
	//车辆入场
	public void addCar(TbCar car){
		mapper.addCar(car);
	}
	//查询车牌信息
	public List<ViewCarPark> findCar(TbCar car){
		return mapper.findCar(car);
	}
	public List<ViewWhiteList> findWhite(TbCar car){
		return mapper.findWhite(car);
	}
	public List<ViewVip> findVip(TbCar car){
		return mapper.findVip(car);
	}
}
