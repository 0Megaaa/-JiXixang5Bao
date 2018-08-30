package com.soft.biz;

import java.util.List;

import com.soft.bean.TbStaff;

public interface StaffBiz {

	public TbStaff login(TbStaff staff);
	public List<TbStaff> findAll();//查找全部 拉取用户信息
	public void staffupdate(TbStaff tbStaff);//状态更新
	public void staffdelete(TbStaff tbStaff);//用户删除
	public List<TbStaff>userChangeManage();//用户修改信息
	public TbStaff selectuser(TbStaff tbStaff);//用户修改信息查询全部
	public void updateuser(TbStaff tbStaff);//更新用户信息
	public void updatepwd(TbStaff tbStaff);//更新用户密码
}
