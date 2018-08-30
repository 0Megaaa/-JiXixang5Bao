package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class TbRulePlace {
	private long ruleId;
	private String passfh;
	private String pass3h;
	private String pass5h;
	private String pass8h;
	private String ruleName;
	private String ruleState;
	private String placeRemain;
private String appointSize;
	private String placeAll;
	public long getRuleId() {
		return ruleId;
	}
	public void setRuleId(long ruleId) {
		this.ruleId = ruleId;
	}
	public String getPassfh() {
		return passfh;
	}
	public void setPassfh(String passfh) {
		this.passfh = passfh;
	}
	public String getPass3h() {
		return pass3h;
	}
	public void setPass3h(String pass3h) {
		this.pass3h = pass3h;
	}
	public String getPass5h() {
		return pass5h;
	}
	public void setPass5h(String pass5h) {
		this.pass5h = pass5h;
	}
	public String getPass8h() {
		return pass8h;
	}
	public void setPass8h(String pass8h) {
		this.pass8h = pass8h;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRuleState() {
		return ruleState;
	}
	public void setRuleState(String ruleState) {
		this.ruleState = ruleState;
	}
	public String getPlaceRemain() {
		return placeRemain;
	}
	public void setPlaceRemain(String placeRemain) {
		this.placeRemain = placeRemain;
	}
	public String getAppointSize() {
		return appointSize;
	}
	public void setAppointSize(String appointSize) {
		this.appointSize = appointSize;
	}
	public String getPlaceAll() {
		return placeAll;
	}
	public void setPlaceAll(String placeAll) {
		this.placeAll = placeAll;
	}
	public TbRulePlace(long ruleId, String passfh, String pass3h, String pass5h, String pass8h, String ruleName,
			String ruleState, String placeRemain, String appointSize, String placeAll) {
		super();
		this.ruleId = ruleId;
		this.passfh = passfh;
		this.pass3h = pass3h;
		this.pass5h = pass5h;
		this.pass8h = pass8h;
		this.ruleName = ruleName;
		this.ruleState = ruleState;
		this.placeRemain = placeRemain;
		this.appointSize = appointSize;
		this.placeAll = placeAll;
	}
	public TbRulePlace() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
}
