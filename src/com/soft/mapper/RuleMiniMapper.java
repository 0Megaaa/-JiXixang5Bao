package com.soft.mapper;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.TbRulePlace;

@MyAnnotation
public interface RuleMiniMapper {

	TbRulePlace queryRule();
	
	
}
