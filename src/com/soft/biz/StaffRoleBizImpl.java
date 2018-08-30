package com.soft.biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbStaff;
import com.soft.bean.ViewTbStaffRole;
import com.soft.mapper.StaffRoleMapper;
@Service
public class StaffRoleBizImpl implements StaffRoleBiz{
@Resource

    private StaffRoleMapper staffRoleMapper;
	@Override
	public List<ViewTbStaffRole> findallview() {
		List<ViewTbStaffRole>staffRoles=staffRoleMapper.findallview();
		return staffRoles;
	}
	@Override
	public void roleupdate(TbStaff tbStaff) {
		 staffRoleMapper.roleupdate(tbStaff);
	}

}
