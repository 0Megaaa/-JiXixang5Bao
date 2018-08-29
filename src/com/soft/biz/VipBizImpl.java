package com.soft.biz;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.soft.bean.Page;
import com.soft.bean.TbPackages;
import com.soft.bean.TbVip;
import com.soft.bean.ViewVip;
import com.soft.mapper.VipMapper;
import com.soft.tools.RefundTool;
import com.soft.tools.VipCheckTool;

@Service
public class VipBizImpl implements VipBiz {

	@Resource
	private VipMapper vipMapper;
	@Resource
	private RefundTool refundTool;
	@Resource
	private VipCheckTool vipCheckTool;
	
	@Override
	public Page<ViewVip> getVipPageInfo(Page page) {
		page.setCurPage(page.getCurPage()==0?1:page.getCurPage());
		page.setPageSize(5);
		RowBounds rb = new RowBounds((page.getCurPage()-1)*page.getPageSize(),page.getPageSize());
		page.setPageList(vipMapper.getVipList(page,rb));
		page.setTotalRecord(vipMapper.getVipList(page).size());
		int all = page.getTotalRecord();
		int size = page.getPageSize();
		page.setTotalPage(all%size ==0?all/size:all/size+1);	//总页数
		page.setCurPageIndex(page.getPageSize()*(page.getCurPage()-1)+1);
		return page;
	}

	@Override
	public List<TbPackages> getPackagesSelect() {
		return vipMapper.getPackagesSelect();
	}

	@Override
	public void addVip(ViewVip viewVip) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		viewVip.setStartDate(df.format(new Date()));
		viewVip.setVipState(1);
		vipMapper.addVip(viewVip);
	}

	@Override
	public TbPackages getPackageById(String paId) {
		return vipMapper.getPackageById(paId);
	}

	@Override
	public ViewVip getVipById(String vipId) {
		return vipMapper.getVipById(vipId);
	}

	@Override
	public String countRefund(String vipId) {
		//根据id查到开始日期，套餐时长，套餐价格
		ViewVip vip = vipMapper.getVipById(vipId);
		return refundTool.countRefund(vip.getStartDate(),vip.getPaTime(),vip.getPaPrice()); 
	}

	@Override
	public void deleteVip(String vipId) {
		vipMapper.deleteVip(vipId);
	}

	@Override
	public Map<String, Object> carNumCheck(String carNum) {
		
		Map<String, Object> checkMap = new HashMap<String, Object>();
		
		TbVip vip = vipMapper.carNumCheck(carNum);
		if(vip==null){
			checkMap.put("flag", true);
			checkMap.put("message", "车牌号未被注册");
		}else{
			checkMap.put("flag", false);
			checkMap.put("message", "车牌号已被注册");
		}
		return checkMap;
	}

	@Override
	public void clearVip() {
		
		try {
			
			int num = vipMapper.clearVip(vipCheckTool.getInvalidVipList(vipMapper.findAllVip()));
			System.out.println("更新"+num+"条");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
