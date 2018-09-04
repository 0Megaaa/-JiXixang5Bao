package com.soft.biz;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbParkPlace;
import com.soft.mapper.CarParkCheckMapper;
import com.soft.mapper.ModifyParkMapper;

@Service
public class ParkModifyBizImpl implements ParkModifyBiz {

	@Resource
	private ModifyParkMapper modifyParkMapper;

	@Override
	public void updateById(TbParkPlace ParkPlace) {
		modifyParkMapper.updateById(ParkPlace);
	}

	@Override
	public void deleted() {
		modifyParkMapper.deleted();
		
	}

	@Override
	public long findAllNum() {
		// TODO Auto-generated method stub
		return modifyParkMapper.findAllNum();
	}

	@Override
	public void updateUnPrefixById(TbParkPlace ParkPlace) {
		modifyParkMapper.updateUnPrefixById(ParkPlace);
		// TODO Auto-generated method stub
		
	}

 
 

	 

}
