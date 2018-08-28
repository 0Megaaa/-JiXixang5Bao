package com.soft.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbAppointment;
import com.soft.mapper.AppointMapper;
@Service
public class AppointBizImpl implements AppointBiz {
@Resource 
AppointMapper appointMapper;
	@Override
	public TbAppointment insetApp(TbAppointment appointment) {
		// TODO Auto-generated method stub
		int flag=0;   //0为数据库没有数据。
		//先查，数据库是否有这个数据。
	TbAppointment appointment2=	appointMapper.queryAppoint(appointment);
	if (appointment2==null) {
		appointMapper.insertAppoint( appointment);
		//插入车位表。（需增加一个字段，预约外键。）
		
		
		//下发到客户端。
		
	}else {
		//有数据不能再插入。
		flag=1;
	}
	
	TbAppointment appointment3=	appointMapper.queryAppoint(appointment);
	appointment3.setFlag(flag);
		
		return appointment3;
	}

}
