package com.soft.mapper;


import java.util.List;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbStaff;



@MyAnnotation
public interface StaffMapper {
	
	public TbStaff login(TbStaff staff);
	public List<TbStaff> findAll();
	public void staffupdate(TbStaff tbStaff);
	public void staffdelete(TbStaff tbStaff);
	public List<TbStaff>userChangeManage();
	public TbStaff selectuser(TbStaff tbStaff);
	public void updateuser(TbStaff tbStaff);
	public void updatepwd(TbStaff tbStaff);
}
