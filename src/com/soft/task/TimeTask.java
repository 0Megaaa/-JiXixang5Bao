package com.soft.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeTask {
	@Scheduled(cron = "0 0 12 * * ?")
//	@Scheduled (cron = "0/2 * * * * ? ")
    public void taskCycle() {
        System.out.println("Time Task Test");
       
    }
}
