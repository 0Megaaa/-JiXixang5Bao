package com.soft.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.soft.annotation.MyAnnotation;
import com.soft.bean.Page;
import com.soft.bean.TbRule;

@MyAnnotation
public interface RuleMapper {

	// public List<TbRule> findAll();
	//
	// public boolean open(TbRule Rule);
	// 抓取分页数据
	public List<TbRule> getRuleList(Page<?> p, RowBounds rb);

	// 抓取所有数据
	public List<TbRule> getRuleList(Page<?> p);

	// 删除
	public int delete(long ruleid);

	// 启动状态
	public int open(long ruleid);

	// 关闭所有状态
	public int closeState();
	
	//添加规则
	public int addRule(TbRule Rule);
	
	//跳转修改规则
	public TbRule findById(TbRule Rule);
	
	//修改规则
	public int modifyDo(TbRule Rule);
	
}
