package com.soft.mapper;

import java.util.List;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbAppointment;
import com.soft.bean.TbCar;
import com.soft.bean.TbParkPlace;
import com.soft.bean.ViewCarPark;
@MyAnnotation
public interface CarParkMapper {

	List<ViewCarPark> queryAllCarPark();
	ViewCarPark   queryCarParkMsg(ViewCarPark viewCarPark);
	TbCar queryCar(TbCar tbCar);
	//通过车号id查询车位信息。
	TbParkPlace queryCarPlace(TbParkPlace tbParkPlace);
	
	Integer updateParkPlace(TbParkPlace tbParkPlace);
	ViewCarPark   queryCarParkMsg1(ViewCarPark viewCarPark);
	Integer updateCarParkSrc(TbCar tbCar); 
	
	ViewCarPark   queryCarParkMsg2(ViewCarPark viewCarPark);
	
	
	List<TbParkPlace> queryParkPlace(String parkState);
	List<TbParkPlace> queryParkPlaceAll();
	List<TbAppointment>queryAppoint(TbAppointment tbAppointment);
	
}
