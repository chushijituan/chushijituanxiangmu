package com.bookmall.bean;

public class CartItemAnBook {
	private int bid;		
	private String  bname;	
	private double currprice;	
	private int quantity;	
	
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
	
	
	public double getCurrprice() {
		return currprice;
	}
	public void setCurrprice(double currprice) {
		this.currprice = currprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public CartItemAnBook(int bid, String bname, double currprice, int quantity) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.currprice = currprice;
		this.quantity = quantity;
	}
	public CartItemAnBook() {
		super();
	}
	@Override
	public String toString() {
		return "CartItemAnBook [bid=" + bid + ", bname=" + bname
				+ ", currprice=" + currprice + ", quantity=" + quantity + "]";
	}
	
	
}
