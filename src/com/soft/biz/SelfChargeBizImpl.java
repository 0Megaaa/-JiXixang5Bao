package com.soft.biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbCar;
import com.soft.bean.TbCharge;
import com.soft.bean.TbParkPlace;
import com.soft.bean.TbRule;
import com.soft.bean.TbVip;
import com.soft.bean.TbWhiteList;
import com.soft.mapper.CarParkMapper;
import com.soft.mapper.SelfChargeMapper;
import com.soft.tools.ChargingTool;

@Service
public class SelfChargeBizImpl implements SelfChargeBiz {

	@Resource
	TbCar tbCar;
	@Resource
	SelfChargeMapper selfChargeMapper;
	@Resource
	CarParkMapper carParkMapper;
	@Resource
	TbParkPlace tbParkPlace;
	@Resource
	TbCharge tbCharge;
@Resource
ChargingTool ChargingTool;
	@Override
	public int findList(String carNum) {
		// 查询是否是白名单，
		int flag = 0;
		TbWhiteList tbWhiteList = selfChargeMapper.queryWhiteList(carNum);
		if (tbWhiteList != null) {
			System.out.println(tbWhiteList);
			flag = 1;
		}
		// 查询是否是vip会员。
		TbVip tbVip = selfChargeMapper.queryVip(carNum);
		if (tbVip != null) {
			System.out.println(tbVip);
			flag = 1;
		}

		// TODO Auto-generated method stub
		return flag;
	}

	@Override
	public long updateCarState(String carNum) {
		// 根据车号查车id。根据id去更新记录。
		TbCar tbCar2 = selfChargeMapper.queryCarId(carNum);
		long i = -1;
		if (tbCar2 == null) {

		} else {

			Date day = new Date();
			SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = date1.format(day);
			tbCar2.setEndTime(endTime);
			selfChargeMapper.updateCarState(tbCar2);
			long carId = tbCar2.getCarId();
			i = carId;
		}

		return i;
	}

	@Override
	public int charge(String carNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public TbCar queryCarMsg(String carNum) {

		TbCar tbCar2 = selfChargeMapper.queryCarId(carNum);
		if (tbCar2 != null) {
			Date day = new Date();
			SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String endTime = date1.format(day);
			tbCar2.setEndTime(endTime);
			// 计算金额。
			// 先放着，直接写金额代替。
			// 用金额5元。
	
			//查询规则表
		TbRule tbRule=	selfChargeMapper.queryTbRule();
		Map<String, Object>  map1=null;
		try {
 map1=		ChargingTool.chargingMethod( tbCar2, tbRule);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tbCar2.setMoney( (long)  map1.get("停车费用"));
tbCar2.setTotalTime((String )map1.get("停车时长"));
		}

		return tbCar2;
	}

	@Override
	public int updateCarMsg(TbCar tbCar) {

		tbParkPlace.setCarId(tbCar.getCarId());
		TbParkPlace tbParkPlace2 = carParkMapper.queryCarPlace(tbParkPlace);
	selfChargeMapper.updatePlace(tbParkPlace2);
		selfChargeMapper.updateCarMsg(tbCar);
		//插入收费记录。
		
		tbCharge.setCarId(tbCar.getCarId());
		tbCharge.setChargeTime(tbCar.getEndTime());

		tbCharge.setMoney(tbCar.getMoney());
		tbCharge.setStaffId(0);
		System.out.println(tbCharge.getCarId()+tbCharge.getChargeTime()+tbCharge.getMoney()+tbCharge.getStaffId());

		selfChargeMapper.insertTbCharge(tbCharge);

		
		return 0;
	}

}
