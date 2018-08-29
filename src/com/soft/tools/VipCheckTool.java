package com.soft.tools;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.soft.bean.TbVip;
import com.soft.bean.ViewVip;

@Component
public class VipCheckTool {
	
	private List<TbVip> lst = new ArrayList<>();
	
	public List<TbVip> getInvalidVipList(List<ViewVip> allVipLst) throws ParseException{
		
		for (int i = 0; i < allVipLst.size(); i++) {
	
			String ds = allVipLst.get(i).getStartDate();
			int month = Integer.valueOf(allVipLst.get(i).getPaTime());
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			
			Date dateToday = new Date();
			Date dateStart = df.parse(ds);
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateStart);
			cal.add(Calendar.MONTH, month);	//计算到费的日期
			
			Calendar cal2 = Calendar.getInstance();
			cal2.setTime(dateToday);
			cal2.add(Calendar.DATE, -1);	//计算昨天的日期
			
			if( cal2.getTime().before( cal.getTime())){
//				System.out.println("未到期");
			}else{
//				System.out.println("逾期");
				TbVip vip = new TbVip();
				vip.setVipId(allVipLst.get(i).getVipId());
				lst.add(vip);
			}			
		}
		
		return lst;
	}
	
	
	
}
