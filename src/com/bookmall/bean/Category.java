package com.bookmall.bean;

public class Category {
	private int cid;
	private String cname;
	private int pid;
	private String cdesc;
	
	public Category() {
	}
	public Category(int cid, String cname, int pid, String cdesc) {
		this.cid = cid;
		this.cname = cname;
		this.pid = pid;
		this.cdesc = cdesc;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getDesc() {
		return cdesc;
	}
	public void setDesc(String cdesc) {
		this.cdesc = cdesc;
	}
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", pid=" + pid
				+ ", cdesc=" + cdesc + "]";
	}
	
}
