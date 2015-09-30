package com.tg.entity;

//医生诊断模型
public class Diagnose {
	private int dia_id;
	private int d_id;
	private int u_id;
	private int m_id;
	private String condition;//病情,例：高血压
	private String state;//病况,例:严重
	private String reportname;
	private String report;//健康报告（从report表中取）
	private String d_date;//医生诊断时间
	public Diagnose(){
		
	}
	
	public String getReportname() {
		return reportname;
	}

	public void setReportname(String reportname) {
		this.reportname = reportname;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getDia_id() {
		return dia_id;
	}
	public void setDia_id(int dia_id) {
		this.dia_id = dia_id;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	public String getD_date() {
		return d_date;
	}
	public void setD_date(String d_date) {
		this.d_date = d_date;
	}

	@Override
	public String toString() {
		return "Diagnose [dia_id=" + dia_id + ", d_id=" + d_id + ", u_id="
				+ u_id + ", m_id=" + m_id + ", condition=" + condition
				+ ", state=" + state + ", reportname=" + reportname
				+ ", report=" + report + ", d_date=" + d_date + "]";
	}
	
	
}
