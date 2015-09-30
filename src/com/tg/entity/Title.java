package com.tg.entity;

public class Title {
	private int t_id;
	private int u_id;
	private int d_id;
	private String doctorname;
	private String title;
	private String context;
	private String t_date;
	
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getT_date() {
		return t_date;
	}
	public void setT_date(String t_date) {
		this.t_date = t_date;
	}
	@Override
	public String toString() {
		return "Title [t_id=" + t_id + ", u_id=" + u_id + ", d_id=" + d_id
				+ ", doctorname=" + doctorname + ", title=" + title
				+ ", context=" + context + ", t_date=" + t_date + "]";
	}
}
