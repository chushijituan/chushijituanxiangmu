package com.bookmall.bean;


import java.sql.Date;
import java.util.List;

public class Order {

	private int oid;
	private Date ordertime; // �µ�ʱ��
	private double total; // �ϼƽ��
	private int status; // ����״̬��1δ����, 2�Ѹ��δ����, 3�ѷ���δȷ���ջ�,
						// 4ȷ���ջ��˽��׳ɹ�,5��ȡ��(ֻ��δ�������ȡ��)
	private String address; // �ջ���ַ
	private int uid; // �û�id
	private User owner;// ������������
	private String receiver;// �ջ���
	private String rphone;// �ջ��˵绰����
	private List<OrderItem> orderitemList;

	public List<OrderItem> getOrderitemList() {
		return orderitemList;
	}

	public void setOrderitemList(List<OrderItem> orderitemList) {
		this.orderitemList = orderitemList;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getRphone() {
		return rphone;
	}

	public void setRphone(String rphone) {
		this.rphone = rphone;
	}

	public Order() {
		super();
	}

}
