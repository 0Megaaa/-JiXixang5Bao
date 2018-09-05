package com.soft.biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft.bean.TbRulePlace;
import com.soft.mapper.RuleMiniMapper;
@Service
public class RuleMiniBizImpl  implements RuleMiniBiz{
@Resource
RuleMiniMapper ruleMiniMapper;
	@Override
	public TbRulePlace findRule() {
	
		return 	ruleMiniMapper.queryRule();
	}

	

	
	
	
	
	
	
	
}
