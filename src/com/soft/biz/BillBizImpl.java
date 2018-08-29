package com.soft.biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbBill;
import com.soft.bean.ViewBill;
import com.soft.mapper.BillMapper;

@Service
public class BillBizImpl implements BillBiz {
	
	@Resource
	private BillMapper billMapper;
	@Resource
	private TbBill tbBill;
	
	@Override
	public List<ViewBill> getMorningList() {
		return billMapper.getBillList(getTodayString()+" 08:00:00",getTodayString()+" 15:59:59");
	}
	@Override
	public List<ViewBill> getNoonList() {
		return billMapper.getBillList(getTodayString()+" 16:00:00",getTodayString()+" 23:59:59");
	}
	@Override
	public List<ViewBill> getEveningList() {
		return billMapper.getBillList(getTodayString()+" 00:00:00",getTodayString()+" 07:59:59");
	}
	
	
	@Override
	public long getMorningCount() {
		//计费
		long count = billMapper.getBillCount(getTodayString()+" 08:00:00",getTodayString()+" 15:59:59");
		this.tbBill.setScheduleType("早班");
		this.tbBill.setMoneyCount(count);
		this.addBill(this.tbBill);
		return count;
	}
	@Override
	public long getNoonCount() {
		long count = billMapper.getBillCount(getTodayString()+" 16:00:00",getTodayString()+" 23:59:59");
		this.tbBill.setScheduleType("中班");
		this.tbBill.setMoneyCount(count);
		this.addBill(this.tbBill);
		return count;
	}

	@Override
	public long getEveningCount() {
		long count =  billMapper.getBillCount(getTodayString()+" 00:00:00",getTodayString()+" 07:59:59");
		this.tbBill.setScheduleType("晚班");
		this.tbBill.setMoneyCount(count);
		this.addBill(this.tbBill);
		return count;
	}
	
	private String getTodayString(){
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		return df.format(day);
	}
	@Override
	public void addBill(TbBill tbBill) {
		
		tbBill.setScheduleDate(this.getTodayString());
		billMapper.addBill(tbBill);
		
	}
	
}
