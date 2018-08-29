package com.soft.biz;

import java.util.List;

import com.soft.bean.TbAppointment;

public interface AppointBiz {

	TbAppointment insetApp(TbAppointment appointment);
	List<TbAppointment>querySelfApp(TbAppointment appointment);
}
