package com.soft.task;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.soft.biz.VipBiz;


@Component
public class VipCheckTask {
	
	@Resource
	private VipBiz vipBizImpl;
			

//    @Scheduled (cron = "0/10 * * * * ? ")
	@Scheduled (cron = "35 23 14 * * ? ")
    public void doVipChenck() {
    	
    	System.out.println("start");
    	
    	vipBizImpl.clearVip();
    	
    	System.out.println("success");
	}

}
