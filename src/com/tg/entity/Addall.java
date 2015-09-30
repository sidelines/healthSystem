package com.tg.entity;

public class Addall {
	//用户表
	private int u_id;//客户id
	private String u_name;
	private int u_age;
	private String u_sex;
	private String u_username;
	private String u_password;
	//医生表
	private int d_id;//医生id
	private String d_name;
	private int d_age;
	private String d_sex;
	private String indications;//主治病症
	private String d_username;
	private String d_password;
	//病人病情监控数据表
	private int m_id;
	private int highpressure;//高压
	private int lowpressure;//低压
	private double temperature;//体温
	private int pulse;//脉搏
	private String ecg;//心电图（图片路径）
	private int warning;//是否需要预警
	private String m_date;//监控数据提交日期
	//医生诊断表
	private int dia_id;
	private String condition;//病情,例：高血压
	private String state;//病况,例:严重
	private String report;//健康报告（从report表中取）
	private String d_date;//医生诊断时间
	//简况报告表
	private int r_id;//健康报告id
	private String r_con;//对应病情;
	private String r_st;//对应病况
	private String r_re;//对应健康报告
	Addall(){
		
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public int getU_age() {
		return u_age;
	}
	public void setU_age(int u_age) {
		this.u_age = u_age;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getD_name() {
		return d_name;
	}
	public void setD_name(String d_name) {
		this.d_name = d_name;
	}
	public int getD_age() {
		return d_age;
	}
	public void setD_age(int d_age) {
		this.d_age = d_age;
	}
	public String getD_sex() {
		return d_sex;
	}
	public void setD_sex(String d_sex) {
		this.d_sex = d_sex;
	}
	public String getIndications() {
		return indications;
	}
	public void setIndications(String indications) {
		this.indications = indications;
	}
	public String getD_username() {
		return d_username;
	}
	public void setD_username(String d_username) {
		this.d_username = d_username;
	}
	public String getD_password() {
		return d_password;
	}
	public void setD_password(String d_password) {
		this.d_password = d_password;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getHighpressure() {
		return highpressure;
	}
	public void setHighpressure(int highpressure) {
		this.highpressure = highpressure;
	}
	public int getLowpressure() {
		return lowpressure;
	}
	public void setLowpressure(int lowpressure) {
		this.lowpressure = lowpressure;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public int getPulse() {
		return pulse;
	}
	public void setPulse(int pulse) {
		this.pulse = pulse;
	}
	public String getEcg() {
		return ecg;
	}
	public void setEcg(String ecg) {
		this.ecg = ecg;
	}
	public int getWarning() {
		return warning;
	}
	public void setWarning(int warning) {
		this.warning = warning;
	}
	public String getM_date() {
		return m_date;
	}
	public void setM_date(String m_date) {
		this.m_date = m_date;
	}
	public int getDia_id() {
		return dia_id;
	}
	public void setDia_id(int dia_id) {
		this.dia_id = dia_id;
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
		return "Addall [u_id=" + u_id + ", u_name=" + u_name + ", u_age="
				+ u_age + ", u_sex=" + u_sex + ", u_username=" + u_username
				+ ", u_password=" + u_password + ", d_id=" + d_id + ", d_name="
				+ d_name + ", d_age=" + d_age + ", d_sex=" + d_sex
				+ ", indications=" + indications + ", d_username=" + d_username
				+ ", d_password=" + d_password + ", m_id=" + m_id
				+ ", highpressure=" + highpressure + ", lowpressure="
				+ lowpressure + ", temperature=" + temperature + ", pulse="
				+ pulse + ", ecg=" + ecg + ", warning=" + warning + ", m_date="
				+ m_date + ", dia_id=" + dia_id + ", condition=" + condition
				+ ", state=" + state + ", report=" + report + ", d_date="
				+ d_date + ", r_id=" + r_id + ", r_con=" + r_con + ", r_st="
				+ r_st + ", r_re=" + r_re + "]";
	}
	
}
