package com.soft.biz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbAppointment;
import com.soft.bean.TbCar;
import com.soft.bean.TbParkPlace;
import com.soft.bean.ViewCarPark;
import com.soft.mapper.CarParkMapper;

@Service
public class CarParkBizImpl implements CarParkBiz {

	@Resource
	private CarParkMapper carParkMapper;

	@Override
	public List<ViewCarPark> fingAllCarPark() {
	
		// TODO Auto-generated method stub
		List<ViewCarPark> list = carParkMapper.queryAllCarPark();
		
		
		
		return list;
	}

	@Override
	public ViewCarPark findCarParkMsg(ViewCarPark viewCarPark) {
		// TODO Auto-generated method stub

		ViewCarPark viewCarPark1 = carParkMapper.queryCarParkMsg(viewCarPark);

		return viewCarPark1;
	}

	@Override
	public TbCar findCar(TbCar tbCar) {
		// TODO Auto-generated method stub

		TbCar tbCar2 = carParkMapper.queryCar(tbCar);

		return tbCar2;
	}

	@Override
	public TbParkPlace findCarPlace(TbParkPlace tbParkPlace) {

		TbParkPlace tbParkPlace2 = carParkMapper.queryCarPlace(tbParkPlace);

		return tbParkPlace2;
	}

	@Override
	public Integer updateParkPlace(TbParkPlace tbParkPlace) {

		Integer integer = carParkMapper.updateParkPlace(tbParkPlace);

		return integer;
	}

	@Override
	public ViewCarPark findCarParkMsg1(ViewCarPark viewCarPark) {

		ViewCarPark viewCarPark1 = carParkMapper.queryCarParkMsg1(viewCarPark);
		return viewCarPark1;
	}

	@Override
	public Integer updateCarParkSrc(TbCar tbCar) {
		Integer integer = carParkMapper.updateCarParkSrc(tbCar);
		return integer;
	}

	@Override
	public ViewCarPark findCarParkMsg2(ViewCarPark viewCarPark) {
		ViewCarPark viewCarPark1 = carParkMapper.queryCarParkMsg2(viewCarPark);
		return viewCarPark1;
	}

	@Override
	public List<TbParkPlace> queryParkPlace(String parkState) {
		
		
		
		// TODO Auto-generated method stub
		return carParkMapper.queryParkPlace( parkState);
	}

	@Override
	public List<TbParkPlace> queryParkPlaceAll() {
		// TODO Auto-generated method stub
		return  carParkMapper.queryParkPlaceAll();
	}

	@Override
	public List<TbAppointment> queryAppoint(TbAppointment tbAppointment) {
		
		
		
		
		// TODO Auto-generated method stub
		return carParkMapper.queryAppoint( tbAppointment);
	}

	@Override
	public List<TbCar> queryCarAll(TbCar tbCar) {
		// TODO Auto-generated method stub
		return  carParkMapper.queryCarAll( tbCar);
	}
	
	
	
	 
	
	
	

}
