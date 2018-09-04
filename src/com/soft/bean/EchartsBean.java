package com.soft.bean;

import java.util.List;

public class EchartsBean {

	// 表中的x轴类别
	private List<String> xAxisCategory;
	// 表中的数据
	private List<Double> datas1;

	// 表中的数据
	private List<Double> datas2;

	// 表中的数据
	private List<Double> datas3;
	public EchartsBean() {
	}

	public EchartsBean(List<String> xAxisCategory, List<Double> datas1, List<Double> datas2) {
		super();
		this.xAxisCategory = xAxisCategory;
		this.datas1 = datas1;
		this.datas2 = datas2;
	}

	public List<Double> getDatas1() {
		return datas1;
	}

	public void setDatas1(List<Double> datas1) {
		this.datas1 = datas1;
	}

	public List<String> getxAxisCategory() {
		return xAxisCategory;
	}

	public void setxAxisCategory(List<String> xAxisCategory) {
		this.xAxisCategory = xAxisCategory;
	}

	public List<Double> getDatas2() {
		return datas2;
	}

	public void setDatas2(List<Double> datas2) {
		this.datas2 = datas2;
	}

	public List<Double> getDatas3() {
		return datas3;
	}

	public void setDatas3(List<Double> datas3) {
		this.datas3 = datas3;
	}

}