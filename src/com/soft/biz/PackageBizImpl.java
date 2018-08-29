package com.soft.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.soft.bean.Page;
import com.soft.bean.TbPackages;
import com.soft.bean.TbVip;
import com.soft.mapper.PackageMapper;

@Service
public class PackageBizImpl implements PackageBiz {

	@Resource
	private PackageMapper packageMapper;
	
	@Override
	public Page<TbPackages> getPackageList(Page page) {
		page.setCurPage(page.getCurPage()==0?1:page.getCurPage());
		page.setPageSize(5);
		RowBounds rb = new RowBounds((page.getCurPage()-1)*page.getPageSize(),page.getPageSize());
		page.setPageList(packageMapper.getPackageList(page,rb));
		page.setTotalRecord(packageMapper.getPackageList(page).size());
		int all = page.getTotalRecord();
		int size = page.getPageSize();
		page.setTotalPage(all%size ==0?all/size:all/size+1);	//总页数
		page.setCurPageIndex(page.getPageSize()*(page.getCurPage()-1)+1);
		return page;
	}

	@Override
	public TbPackages getPackageById(String paId) {
		
		return packageMapper.getPackageById(paId);
	}

	@Override
	public int updatePackage(TbPackages pack) {
		
		return packageMapper.updatePackage(pack);
	}

	@Override
	public int deletePackage(String paId) {
		//删除前先先判断是否有用户在使用该套餐
		List<TbVip> lst = packageMapper.findVipByPackageId(paId);
		if(lst.size()==0){		//说明没有用户在用这个套餐
			return packageMapper.deletePackage(paId);
		}else{
			return -1;
		}

	}
	@Override
	public int modifyCheck(String paId) {
		//删除前先先判断是否有用户在使用该套餐
		List<TbVip> lst = packageMapper.findVipByPackageId(paId);
		if(lst.size()==0){		//说明没有用户在用这个套餐
			return 1;
		}else{
			return -1;
		}
	}
	@Override
	public int addPackage(TbPackages pack) {
		
		return packageMapper.addPackage(pack);
		
	}

	@Override
	public Map<String, Object> timeCheck(String time) {
		
		Map<String, Object> checkMap = new HashMap<String, Object>();
		
		TbPackages pa = packageMapper.timeCheck(time);
		if(pa==null){
			checkMap.put("flag", true);
			checkMap.put("message", "套餐时长可用 :-)");
		}else{
			checkMap.put("flag", false);
			checkMap.put("message", "套餐时长已存在 :-(");
		}
		return checkMap;
	}

	

}
