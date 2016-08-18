package com.bookmall.bean;

import java.util.ArrayList;
import java.util.List;

//CartItem(购物车条目)：5本相同的书quantity的数量为5，5本不同的书会有5个不同quantity
public class CartItem {
	
	private int cartitemid;	//购物车ID
	private int quantity;		//图书数量
	private int bid;			//图书ID
	private int cosuid;			//用户ID
	private List<CartItem> listBookDelete = new ArrayList<CartItem>();//批量删除图书集合
	private List<CartItem> listCartItemSelect = new ArrayList<CartItem>();//显示选中条目集合
	
	public int getCartitemid() {
		return cartitemid;
	}
	public void setCartitemid(int cartitemid) {
		this.cartitemid = cartitemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public int getCosuid() {
		return cosuid;
	}
	public void setCosuid(int cosuid) {
		this.cosuid = cosuid;
	}
	public List<CartItem> getListBookDelete() {
		return listBookDelete;
	}
	public void setListBookDelete(List<CartItem> listBookDelete) {
		this.listBookDelete = listBookDelete;
	}
	public List<CartItem> getListCartItemSelect() {
		return listCartItemSelect;
	}
	public void setListCartItemSelect(List<CartItem> listCartItemSelect) {
		this.listCartItemSelect = listCartItemSelect;
	}
	
	public CartItem(int cartitemid, int quantity, int bid, int cosuid, List<CartItem> listBookDelete,
			List<CartItem> listCartItemSelect) {
		super();
		this.cartitemid = cartitemid;
		this.quantity = quantity;
		this.bid = bid;
		this.cosuid = cosuid;
		this.listBookDelete = listBookDelete;
		this.listCartItemSelect = listCartItemSelect;
	}
	
	public CartItem() {
		super();
	}
	
	@Override
	public String toString() {
		return "CartItem [cartitemid=" + cartitemid + ", quantity=" + quantity + ", bid=" + bid + ", cosuid=" + cosuid
				+ ", listBookDelete=" + listBookDelete + ", listCartItemSelect=" + listCartItemSelect + "]";
	}
}
