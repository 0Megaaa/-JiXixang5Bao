package com.soft.mapper;


import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbParkPlace;
@MyAnnotation
public interface ModifyParkMapper {
	//情况前缀
	public void deleted();
//查找前缀
	public void updateById(TbParkPlace ParkPlace);
	//修改前缀
//	TbParkPlace findByPrefix(TbParkPlace ParkPlace);
}
