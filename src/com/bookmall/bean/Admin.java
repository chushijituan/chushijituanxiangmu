package com.bookmall.bean;

public class Admin {
	private int adminid;//管理员id
	private String adminname;//管理员姓名
	private String adminpwd;//管理员密码
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpwd() {
		return adminpwd;
	}
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminname=" + adminname
				+ ", adminpwd=" + adminpwd + "]";
	}
	
}
