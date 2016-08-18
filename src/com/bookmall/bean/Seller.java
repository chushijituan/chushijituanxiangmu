package com.bookmall.bean;

public class Seller {

	private int sid;
	private String sname;
	private String spassword;
	private String semail;
	private String sidentification;
	private String sphone;

	public String getSphone() {
		return sphone;
	}

	public void setSphone(String sphone) {
		this.sphone = sphone;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSpassword() {
		return spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	public String getSemail() {
		return semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public String getSidentification() {
		return sidentification;
	}

	public void setSidentification(String sidentification) {
		this.sidentification = sidentification;
	}

	public Seller() {
		super();
	}

	@Override
	public String toString() {
		return "Seller [sid=" + sid + ", sname=" + sname + ", spassword="
				+ spassword + ", semail=" + semail + ", sidentification="
				+ sidentification + ", sphone=" + sphone + "]";
	}

}
