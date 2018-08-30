package com.soft.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbStaff;
import com.soft.mapper.StaffMapper;

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
	@Override
	public List<TbStaff> findAll() {
		List<TbStaff>  staff2 =staffMapper.findAll();
		return staff2;
	}

	@Override
	public void staffupdate(TbStaff staff) {
        staffMapper.staffupdate(staff);
	}

	@Override
	public void staffdelete(TbStaff tbStaff) {
        staffMapper.staffdelete(tbStaff);		
	}

	@Override
	public List<TbStaff> userChangeManage() {
		List<TbStaff>tbStaff2=staffMapper.userChangeManage();
		return tbStaff2;
	}

	@Override
	public TbStaff selectuser(TbStaff tbStaff) {
		TbStaff tbStaff2 =	staffMapper.selectuser(tbStaff);
		return tbStaff2;
	}

	@Override
	public void updateuser(TbStaff tbStaff) {
		staffMapper.updateuser(tbStaff);
	}

	@Override
	public void updatepwd(TbStaff tbStaff) {
      staffMapper.updatepwd(tbStaff);		
	}

	
}
