package com.bookmall.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.jdbc.JdbcUtils;

import com.bookmall.bean.Order;
import com.bookmall.bean.PageBean;
import com.bookmall.dao.OrderDao;
import com.bookmall.dao.impl.OrderDaoImpl;
import com.bookmall.service.OrderService;
import com.bookmall.utils.DBUtil;

public class OrderServiceImpl implements OrderService{
	
	OrderDao orderDao = new OrderDaoImpl();
	
	//��ѯ����״̬
	@Override
	public int findStatus(int oid) throws SQLException, ClassNotFoundException {
		return orderDao.findStatus(oid);
	}

	//�޸Ķ���״̬
	@Override
	public void updateStatus(int oid, int status)
			throws ClassNotFoundException, SQLException {
		orderDao.updateStatus(oid, status);
		
	}

	//���ض���
	@Override
	public Order load(int oid) throws ClassNotFoundException, SQLException {
		DBUtil.getConnection();
		Order order = orderDao.load(oid);
		JdbcUtils.commitTransaction();
		return order;
	}

	//���ɶ���
	@Override
	public void add(Order order) throws ClassNotFoundException, SQLException {
		
		orderDao.add(order);
		
		
	}

	//�ҵĶ���
	@Override
	public PageBean<Order> findByUser(int uid, int pc)
			throws ClassNotFoundException, SQLException {
		DBUtil.getConnection();
		PageBean<Order> pb = orderDao.findByUser(uid, pc);
		JdbcUtils.commitTransaction();
		return pb;
	}

	//��ѯ����
	@Override
	public PageBean<Order> findAll(int pc) throws ClassNotFoundException,
			SQLException {
		DBUtil.getConnection();
		PageBean<Order> pb = orderDao.findAll(pc);
		JdbcUtils.commitTransaction();
		return pb;
	}

	//��״̬��ѯ
	@Override
	public PageBean<Order> findByStatus(int status, int pc)
			throws ClassNotFoundException, SQLException {
		DBUtil.getConnection();
		PageBean<Order> pb = orderDao.findByStatus(status, pc);
		JdbcUtils.commitTransaction();
		return pb;
	}

	@Override
	public List<Order> getOrderByUserId(int userid) throws SQLException,
			ClassNotFoundException {
		
		return  orderDao.getOrderByUserId(userid);
	}

	@Override
	public void updateorder(Order order) throws SQLException,
			ClassNotFoundException {
		orderDao.updateorder(order);
		
	}

	@Override
	public int getorderid() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return orderDao.getorderid();
	}

	@Override
	public void insertorderitembyorderid(Order order) throws SQLException,
			ClassNotFoundException {
	
		orderDao.insertorderitembyorderid(order);
	}

}
