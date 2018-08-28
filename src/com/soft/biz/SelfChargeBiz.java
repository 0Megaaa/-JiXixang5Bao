package com.soft.biz;

import com.soft.bean.TbCar;
import com.soft.bean.TbWhiteList;

public interface SelfChargeBiz {
	int   findList(String  carNum);
	
	long updateCarState(String carNum);
	
	
	int charge(String carNum);
	
	//查询停车记录并计算。
	TbCar queryCarMsg(String carNum);
	
	//出场更新停车记录。。、
	int updateCarMsg(TbCar tbCar);
}
