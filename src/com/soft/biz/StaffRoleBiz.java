package com.soft.biz;

import java.util.List;

import com.soft.bean.TbStaff;
import com.soft.bean.ViewTbStaffRole;

public interface StaffRoleBiz {
	public List<ViewTbStaffRole>findallview();
	public void roleupdate(TbStaff tbStaff);
}
