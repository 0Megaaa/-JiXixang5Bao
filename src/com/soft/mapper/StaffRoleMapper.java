package com.soft.mapper;

import java.util.List;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbStaff;
import com.soft.bean.ViewTbStaffRole;

@MyAnnotation
public interface StaffRoleMapper {
public List<ViewTbStaffRole>findallview();
public void roleupdate(TbStaff tbStaff);
}
