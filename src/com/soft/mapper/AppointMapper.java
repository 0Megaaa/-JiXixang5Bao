package com.soft.mapper;

import java.util.List;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbAppointment;
@MyAnnotation


public interface AppointMapper {
int insertAppoint(TbAppointment appointment);
	TbAppointment queryAppoint(TbAppointment appointment);
	List<TbAppointment>querySelfApp(TbAppointment appointment);
}
