package com.soft.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Page<T> {
	
	private int curPage;
	private int pageSize;
	private int totalPage;
	private List<T> pageList;
	private int totalRecord;
	private int curPageIndex;
	
	//搜索条件
	private int vipState;
	private String startDate;
	private String carNum;
	
	
	
	//国杰
	private long paId;
	
	
	//海龙
	private String ruleName;
	private long ruleId;
	
	
	public Page() {
		super();
	}


	public long getPaId() {
		return paId;
	}

	public void setPaId(long paId) {
		this.paId = paId;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getCurPageIndex() {
		return curPageIndex;
	}

	public void setCurPageIndex(int curPageIndex) {
		this.curPageIndex = curPageIndex;
	}

	public int getVipState() {
		return vipState;
	}

	public void setVipState(int vipState) {
		this.vipState = vipState;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}


	public String getRuleName() {
		return ruleName;
	}


	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}


	public long getRuleId() {
		return ruleId;
	}


	public void setRuleId(long ruleId) {
		this.ruleId = ruleId;
	}


	public Page(int curPage, int pageSize, int totalPage, List<T> pageList, int totalRecord, int curPageIndex,
			int vipState, String startDate, String carNum, long paId, String ruleName, long ruleId) {
		super();
		this.curPage = curPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.pageList = pageList;
		this.totalRecord = totalRecord;
		this.curPageIndex = curPageIndex;
		this.vipState = vipState;
		this.startDate = startDate;
		this.carNum = carNum;
		this.paId = paId;
		this.ruleName = ruleName;
		this.ruleId = ruleId;
	}
	
	
}
