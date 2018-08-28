package com.soft.mapper;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbAppointment;
@MyAnnotation


public interface AppointMapper {
int insertAppoint(TbAppointment appointment);
	TbAppointment queryAppoint(TbAppointment appointment);
	
}
