package com.tg.entity;

public class Doctor {
	private int d_id;
	private String d_name;
	private int d_age;
	private String d_sex;
	private String indications;//Ö÷ÖÎ²¡Ö¢
	private String d_username;
	private String d_password;
	public Doctor(){
		
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
	@Override
	public String toString() {
		return "Doctor [d_id=" + d_id + ", d_name=" + d_name + ", d_age="
				+ d_age + ", d_sex=" + d_sex + ", indications=" + indications
				+ ", d_username=" + d_username + ", d_password=" + d_password
				+ "]";
	}
	
}
