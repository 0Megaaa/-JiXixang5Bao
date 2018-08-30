package com.soft.mapper;


import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbStaff;



@MyAnnotation
public interface StaffMapper {
	
	public TbStaff login(TbStaff staff);
	
}
