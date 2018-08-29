package com.soft.biz;


import java.util.Map;

import com.soft.bean.Page;
import com.soft.bean.TbPackages;

public interface PackageBiz {
	
	public Page<TbPackages> getPackageList(Page<?> page);
	public TbPackages getPackageById(String paId);
	public int updatePackage(TbPackages pack);
	public int deletePackage(String paId);
	public int modifyCheck(String paId);
	public int addPackage(TbPackages pack);
	public Map<String, Object> timeCheck(String time);
}
