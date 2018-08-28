package com.soft.mapper;

import java.util.List;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbCar;
import com.soft.bean.TbCharge;
import com.soft.bean.TbParkPlace;
import com.soft.bean.TbRule;
import com.soft.bean.TbVip;
import com.soft.bean.TbWhiteList;
import com.soft.bean.ViewCarPark;

@MyAnnotation
public interface SelfChargeMapper {

	// 查询白名单用户。
	TbWhiteList queryWhiteList(String carNum);

	TbVip queryVip(String carNum);

	//根据车号查车id。
	TbCar queryCarId(String carNum);
	//根据车号查车信息。
	TbCar queryCardMsg(long carId);
	
	// 更新车辆状态。为已缴费。
	int updateCarState(TbCar tbCar);
	
	//更新记录。出场时间。
	
	//根据paystate=7和carNum查询车记录，
TbCar queryCar (String carNum);

int updateCarEndTime(String carNum);
//出场更新停车记录。。、

int updateCarMsg(TbCar tbCar);
//更新车位信息。

int updatePlace(TbParkPlace tbParkPlace);
//插入收费记录单，、

int insertTbCharge(TbCharge tbCharge);
//查询规则表。

TbRule queryTbRule();






}
