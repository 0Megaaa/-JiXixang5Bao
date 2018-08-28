package com.soft.tools;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.soft.bean.TbCar;
import com.soft.bean.TbRule;
@Component
public class ChargingTool {
	/***************************************
		需要的参数
		开始时间：2018-08-22 13:00:00 
		结束时间：2018-08-22 16:43:00 
		前 30 分钟				0元
		超 30 分钟， 不足 3 个小时， 收费 10 元
	 	超过 3 个小时， 超过部分每小时收费 5 元
		超过 5 个小时， 超过部分每小时收费 10 元
		超过 8 个小时， 收费 80 元
	 ***************************************/
//	private String timeStart = "2018-08-22 08:00:00";
/*	private String timeEnd = "2018-08-22 15:10:00";
	private int p1 = 0;
	private int p2 = 10;
	private int p3 = 5;
	private int p4 = 10;
	private int p5 = 80;*/
	private Map<String, Object> resultMap = new HashMap<>();
	
	public Map<String, Object> chargingMethod(TbCar tbCar,TbRule tbRule) throws Exception{
		 String timeStart =tbCar.getStartTime();
		 String timeEnd = tbCar.getEndTime();
		 int p1 = 0;
		 int p2 =Integer.parseInt(tbRule.getPassfh()) ;
		 int p3 = Integer.parseInt(tbRule.getPass3h()) ;
		 int p4 =  Integer.parseInt(tbRule.getPass5h()) ;
		 int p5 =  Integer.parseInt(tbRule.getPass8h()) ;
		 
		 
		//计算停车时长
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateStart = df.parse(timeStart);
		Date dateEnd = df.parse(timeEnd);
		
		long diff = dateEnd.getTime() - dateStart.getTime();// 计算毫秒差值
			
		long days = diff / (1000 * 60 * 60 * 24);	//停留总天数
		long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);

		//最后一日的停留时长（minutes）
		long stayMinutes = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60);	
		long cost = 0;
		
		if(stayMinutes <= 30){
			cost = p1;
		}else if(stayMinutes <= 180){
			cost = p2;
		}else if(stayMinutes <= 300){
			cost = p2+ (((stayMinutes-180-1)/60)+1) * p3;
		}else if(stayMinutes <= 480){
			cost = p1 + p2 + p3 * 2 + (((stayMinutes-300-1)/60)+1) * p4;
		}else if(stayMinutes <= 24*60){
			cost = p5;
		}
		cost += days * p5;
		
		resultMap.put("停车时长", days + "天" + hours + "小时" + minutes + "分钟");
		resultMap.put("停车费用", cost);
		
		return resultMap;
	}
}
