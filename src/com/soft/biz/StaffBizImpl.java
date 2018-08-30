package com.soft.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbStaff;
import com.soft.mapper.StaffMapper;

@Service
public class StaffBizImpl implements StaffBiz {

	@Resource
	private StaffMapper staffMapper;

	@Override
	public TbStaff login(TbStaff staff0) {
		TbStaff staff = staffMapper.login(staff0);
		if (staff!=null) {
			return staff;
		} else {
			return null;
		}
	}

}
