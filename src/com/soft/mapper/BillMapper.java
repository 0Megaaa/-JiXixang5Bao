package com.soft.mapper;

import java.util.List;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbBill;
import com.soft.bean.ViewBill;

@MyAnnotation
public interface BillMapper {

	public List<ViewBill> getBillList(String startTime,String endTime);
	public long getBillCount(String startTime,String endTime);
	public void addBill(TbBill tbBill);
}
