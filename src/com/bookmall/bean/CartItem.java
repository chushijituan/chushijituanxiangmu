package com.bookmall.bean;

import java.util.ArrayList;
import java.util.List;

//CartItem(���ﳵ��Ŀ)��5����ͬ����quantity������Ϊ5��5����ͬ�������5����ͬquantity
public class CartItem {
	
	private int cartitemid;	//���ﳵID
	private int quantity;		//ͼ������
	private int bid;			//ͼ��ID
	private int cosuid;			//�û�ID
	private List<CartItem> listBookDelete = new ArrayList<CartItem>();//����ɾ��ͼ�鼯��
	private List<CartItem> listCartItemSelect = new ArrayList<CartItem>();//��ʾѡ����Ŀ����
	
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
