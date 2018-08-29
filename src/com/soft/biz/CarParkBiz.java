package com.soft.biz;

import java.util.List;

import com.soft.bean.TbAppointment;
import com.soft.bean.TbCar;
import com.soft.bean.TbParkPlace;
import com.soft.bean.ViewCarPark;

public interface CarParkBiz {
	List<ViewCarPark> fingAllCarPark();
	ViewCarPark       findCarParkMsg(ViewCarPark viewCarPark );
	ViewCarPark       findCarParkMsg1(ViewCarPark viewCarPark );
	ViewCarPark       findCarParkMsg2(ViewCarPark viewCarPark );
	TbCar findCar(TbCar tbCar);
TbParkPlace	findCarPlace(TbParkPlace tbParkPlace);
Integer updateParkPlace(TbParkPlace tbParkPlace);
Integer updateCarParkSrc(TbCar tbCar); 
List<TbParkPlace> queryParkPlace(String parkState);
List<TbParkPlace> queryParkPlaceAll();
List<TbCar>  queryCarAll(TbCar tbCar);
List<TbAppointment>queryAppoint(TbAppointment tbAppointment);
}
