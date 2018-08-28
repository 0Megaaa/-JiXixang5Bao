package com.soft.bean;

import org.springframework.stereotype.Component;

@Component
public class TbRule {
	private long ruleid;
	private String passfh;
	private String pass3h;
	private String pass5h;
	private String pass8h;
	private String rulename;
	private String rulestate;
	public TbRule(long ruleid, String passfh, String pass3h, String pass5h, String pass8h, String rulename,
			String rulestate) {
		super();
		this.ruleid = ruleid;
		this.passfh = passfh;
		this.pass3h = pass3h;
		this.pass5h = pass5h;
		this.pass8h = pass8h;
		this.rulename = rulename;
		this.rulestate = rulestate;
	}
	public TbRule() {
		super();
	}
	public long getRuleid() {
		return ruleid;
	}
	public void setRuleid(long ruleid) {
		this.ruleid = ruleid;
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
	public String getRulename() {
		return rulename;
	}
	public void setRulename(String rulename) {
		this.rulename = rulename;
	}
	public String getRulestate() {
		return rulestate;
	}
	public void setRulestate(String rulestate) {
		this.rulestate = rulestate;
	}

	
}
