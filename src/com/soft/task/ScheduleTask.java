package com.soft.task;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.soft.bean.ViewBill;
import com.soft.biz.BillBiz;


@Component
public class ScheduleTask {
	
	@Resource
	private BillBiz billBizImpl;
		
	//早班(8:00~16:00)
	@Scheduled (cron = "50 17 14 * * ? ")
    public void billForMorning() {
		System.out.println("3333333333333333333333");
		//step1 查出早班所有的收费记录，查询charge表，条件是时间，返回一个list
		List<ViewBill> lst = billBizImpl.getMorningList();
		for (int i = 0; i < lst.size(); i++) {
			ViewBill bill =  lst.get(i);
			System.out.println(bill.getCarNum());
		}
		//step2 计算当轮班的总金额
		System.out.println(billBizImpl.getMorningCount());
		System.out.println("-----早----");
    }
	
	//中班(16:00~00:00)
	@Scheduled (cron = "0 0 0 * * ? ")
    public void billForNoon() {
		List<ViewBill> lst = billBizImpl.getNoonList();
		for (int i = 0; i < lst.size(); i++) {
			ViewBill bill =  lst.get(i);
			System.out.println(bill.getCarNum());
		}
		System.out.println(billBizImpl.getNoonCount());
		System.out.println("-----中----");	
	}
	
	//晚班(00:00~08:00)
	@Scheduled (cron = "0 0 8 * * ? ")
    public void billForEvening() {
		List<ViewBill> lst = billBizImpl.getEveningList();
		for (int i = 0; i < lst.size(); i++) {
			ViewBill bill =  lst.get(i);
			System.out.println(bill.getCarNum());
		}
		System.out.println(billBizImpl.getEveningCount());
		System.out.println("-----晚----");
	}
	
}
