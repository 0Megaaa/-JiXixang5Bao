package com.soft.biz;


import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import com.soft.bean.Page;
import com.soft.bean.TbRule;
import com.soft.mapper.RuleMapper;

@Service
public class RuleBizImpl implements RuleBiz {

	@Resource
	private RuleMapper ruleMapper;

	@Override
	public Page<TbRule> findAll(Page page) {
		
		page.setCurPage(page.getCurPage()==0?1:page.getCurPage());
		page.setPageSize(5);
		RowBounds rb = new RowBounds((page.getCurPage()-1)*page.getPageSize(),page.getPageSize());
		page.setPageList(ruleMapper.getRuleList(page,rb));
		page.setTotalRecord(ruleMapper.getRuleList(page).size());
		int all = page.getTotalRecord();
		int size = page.getPageSize();
		page.setTotalPage(all%size ==0?all/size:all/size+1);	//总页数
		
		return page;
	}

	@Override
	public int delete(long ruleid) {
		
		ruleMapper.delete(ruleid);
		return 0;
	}

	@Override
	public int open(long ruleid) {
		ruleMapper.closeState();
		ruleMapper.open(ruleid);
		return 0;
	}

	@Override
	public int addRule(TbRule Rule) {
		ruleMapper.addRule(Rule);
		return 0;
	}

	@Override
	public TbRule findById(TbRule Rule) {
		TbRule Rule0 = ruleMapper.findById(Rule);
		return Rule0;
	}

	@Override
	public int modifyDo(TbRule Rule) {
		ruleMapper.modifyDo(Rule);
		return 0;
	}

 

 

 

}
