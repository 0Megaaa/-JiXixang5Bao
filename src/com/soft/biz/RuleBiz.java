package com.soft.biz;



import com.soft.bean.Page;
import com.soft.bean.TbRule;

public interface RuleBiz {

	// public List<TbRule> findAll( );

	// 分页查询
	public Page<TbRule> findAll(Page p);
	//删除
	public int delete(long ruleid);
	//启动
	public int open(long ruleid);
	//添加规则
	public int addRule(TbRule Rule);
	//跳转修改规则
	public TbRule findById(TbRule Rule);
	
	//修改规则
	public int modifyDo(TbRule Rule);
}
