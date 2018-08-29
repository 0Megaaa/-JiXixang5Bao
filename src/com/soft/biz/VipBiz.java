package com.soft.biz;

import java.util.List;
import java.util.Map;

import com.soft.bean.Page;
import com.soft.bean.TbPackages;
import com.soft.bean.TbVip;
import com.soft.bean.ViewVip;

public interface VipBiz {
	
	//增加会员，会员退费，分页查询会员（条件：会员是否过期，车牌号，开始日期）
	
	public Page<ViewVip> getVipPageInfo(Page<?> page);
	public List<TbPackages> getPackagesSelect();
	public void addVip(ViewVip viewVip);
	public TbPackages getPackageById(String paId);
	public ViewVip getVipById(String vipId);
	public String countRefund(String vipId);	
	public void deleteVip(String vipId);
	public Map<String , Object> carNumCheck(String carNum);
	public void clearVip();
	
}
