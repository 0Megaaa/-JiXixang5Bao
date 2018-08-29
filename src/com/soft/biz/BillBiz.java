package com.soft.biz;

import java.util.List;

import com.soft.bean.TbBill;
import com.soft.bean.ViewBill;

public interface BillBiz {

	public List<ViewBill> getMorningList();
	public List<ViewBill> getNoonList();
	public List<ViewBill> getEveningList();
	public long getMorningCount();
	public long getNoonCount();
	public long getEveningCount();
	public void addBill(TbBill tbBill);
}
