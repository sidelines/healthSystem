package com.tg.entity;

public class Report {
	private int r_id;//健康报告id
	private String r_con;//对应病情;
	private String r_st;//对应病况
	private String r_re;//对应健康报告
	public Report(){
		
	}
	public int getR_id() {
		return r_id;
	}
	public void setR_id(int r_id) {
		this.r_id = r_id;
	}
	public String getR_con() {
		return r_con;
	}
	public void setR_con(String r_con) {
		this.r_con = r_con;
	}
	public String getR_st() {
		return r_st;
	}
	public void setR_st(String r_st) {
		this.r_st = r_st;
	}
	public String getR_re() {
		return r_re;
	}
	public void setR_re(String r_re) {
		this.r_re = r_re;
	}
	@Override
	public String toString() {
		return "Report [r_id=" + r_id + ", r_con=" + r_con + ", r_st=" + r_st
				+ ", r_re=" + r_re + "]";
	}
	
}
