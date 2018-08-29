package com.soft.tools;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class RefundTool {
	
	public String countRefund(String startDate,String time,long price){

		int dayUsed = this.countDayReturn(startDate);	//计算已用天数
		int dayAll = Integer.valueOf(time)*30;			//计算总天数
		
		double priceUsed = (double) ((double)(dayUsed * price) / dayAll);	//已扣除金额
		double priceRest = (double) price - priceUsed;	//剩余金额
		DecimalFormat df = new DecimalFormat("0.00");	//格式化小数  
		String moneyRest = df.format(priceRest);		//返回String类型 
		
		return moneyRest;
	}
	
	
	private int countDayReturn(String startDate){
		
		int day = -1;
		try {
		    Date dateToday =  new Date();	//今天的日期
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		    Date dateStart = format.parse(startDate);
//		    System.out.println("两个日期的差距："+countMethod(dateStart,dateToday));
		    day = countMethod(dateStart,dateToday);
		    
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		
		return day+1;
	}
	
	
	private int countMethod(Date dateStart,Date dateToday){
        int days = (int) ((dateToday.getTime() - dateStart.getTime()) / (1000*3600*24));
        return days;
    }
	
}
