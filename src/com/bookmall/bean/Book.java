package com.bookmall.bean;

import java.sql.Date;

public class Book {
	private int bid;
	private String  bname;
	private String author;
	private double price;
	private double currprice;
	private double discount;
	private String press;
	private Date publishtime;
	private int cid;
	private String image;
	private int shopid;
	private String cname;
	
	public Book() {
		super();
	}
	//���book����
	public Book(String bname, String author, double price, double currprice,
			double discount, String press, Date publishtime, int cid,
			String image, int shopid) {
		super();
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.currprice = currprice;
		this.discount = discount;
		this.press = press;
		this.publishtime = publishtime;
		this.cid = cid;
		this.image = image;
		this.shopid = shopid;
	}
	//��ѯbook����
	public Book(int bid, String bname, String author, double price,
			double currprice, double discount, String press, Date publishtime,
			int cid, String image,int shopid) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.currprice = currprice;
		this.discount = discount;
		this.press = press;
		this.publishtime = publishtime;
		this.cid = cid;
		this.image = image;
		this.shopid=shopid;
	}

	
	//���Ӳ�ѯ
	public Book(int bid, String bname, String author, double price,
			double currprice, double discount, String press, Date publishtime,
			int cid, String image, int shopid, String cname) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.currprice = currprice;
		this.discount = discount;
		this.press = press;
		this.publishtime = publishtime;
		this.cid = cid;
		this.image = image;
		this.shopid = shopid;
		this.cname = cname;
	}
	//����book����
	public Book(int bid,String bname, String author, double price, double currprice,
			double discount, String press, Date publishtime, int cid,
			String image) {
		super();
		this.bid=bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.currprice = currprice;
		this.discount = discount;
		this.press = press;
		this.publishtime = publishtime;
		this.cid = cid;
		this.image = image;
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCurrprice() {
		return currprice;
	}
	public void setCurrprice(double currprice) {
		this.currprice = currprice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPublishtime() {
		return publishtime;
	}
	public void setPublishtime(Date publishtime) {
		this.publishtime = publishtime;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", author=" + author
				+ ", price=" + price + ", currprice=" + currprice
				+ ", discount=" + discount + ", press=" + press
				+ ", publishtime=" + publishtime + ", cid=" + cid + ", image="
				+ image + ", shopid=" + shopid + "]";
	}
	
}
