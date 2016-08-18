package com.bookmall.bean;

import java.sql.Date;

public class Shop {
	private int shopid;
	private String shopname;
	private Date createtime;
	private int sid;
	private String shopdesc;
	public Shop() {
		super();
	}
	//更新shop对象
	public Shop(int shopid, String shopname, Date createtime, String shopdesc) {
		super();
		this.shopid = shopid;
		this.shopname = shopname;
		this.createtime = createtime;
		this.shopdesc = shopdesc;
	}
	//添加shop对象
	public Shop(String shopname, int sid, String shopdesc) {
		super();
		this.shopname = shopname;
		this.sid = sid;
		this.shopdesc = shopdesc;
	}
	//查询shop对象
	public Shop(int shopid, String shopname, Date createtime, int sid,
			String shopdesc) {
		super();
		this.shopid = shopid;
		this.shopname = shopname;
		this.createtime = createtime;
		this.sid = sid;
		this.shopdesc = shopdesc;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getShopdesc() {
		return shopdesc;
	}
	public void setShopdesc(String shopdesc) {
		this.shopdesc = shopdesc;
	}
}
