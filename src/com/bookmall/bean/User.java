package com.bookmall.bean;

public class User {

	private int cosuid; 
	private String loginname; 
	private String loginpass; 
	private String email; 
	private String uphone;

	public User() {

	}

	public int getCosuid() {
		return cosuid;
	}

	public void setCosuid(int cosuid) {
		this.cosuid = cosuid;

	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpass() {
		return loginpass;
	}

	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUphone() {
		return uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	@Override
	public String toString() {
		return "User [cosuid=" + cosuid + ", loginname=" + loginname
				+ ", loginpass=" + loginpass + ", email=" + email + ", uphone="
				+ uphone + "]";
	}

}