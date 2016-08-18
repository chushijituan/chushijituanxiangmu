package com.bookmall.service;

import java.sql.SQLException;
import java.util.List;

import com.bookmall.bean.Order;
import com.bookmall.bean.PageBean;

public interface OrderService {

	// ��ѯ����״̬
	public int findStatus(int oid) throws SQLException, ClassNotFoundException;

	// �޸Ķ���״̬
	public void updateStatus(int oid, int status) throws ClassNotFoundException, SQLException;

	// ���ض���
	public Order load(int oid) throws ClassNotFoundException, SQLException;

	// ���ɶ���
	public void add(Order order) throws ClassNotFoundException, SQLException;

	// ���û���ѯ����
	public PageBean<Order> findByUser(int uid, int pc) throws ClassNotFoundException, SQLException;

	// ��ѯ����
	public PageBean<Order> findAll(int pc) throws ClassNotFoundException, SQLException;

	// ��״̬��ѯ
	public PageBean<Order> findByStatus(int status, int pc) throws ClassNotFoundException, SQLException;
	
	public List<Order> getOrderByUserId(int userid)throws SQLException, ClassNotFoundException;
	
	public void updateorder(Order order) throws SQLException,ClassNotFoundException ;
	
	public int getorderid()throws SQLException,ClassNotFoundException ;
	
	public void insertorderitembyorderid(Order order)throws SQLException,ClassNotFoundException ;

}
