package com.bookmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.itcast.commons.CommonUtils;
import cn.itcast.jdbc.TxQueryRunner;

import com.bookmall.bean.Book;
import com.bookmall.bean.Order;
import com.bookmall.bean.OrderItem;
import com.bookmall.dao.OrderItemDao;

public class OrderItemDaoImpl implements OrderItemDao{

	private QueryRunner qr = new TxQueryRunner();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	@Override
	public void loadOrderItem(Order order) throws ClassNotFoundException, SQLException {
		/*
		 * 1. ��sql���select * from t_orderitem where oid=?
		 * 2. ִ��֮���õ�List<OrderItem>
		 * 3. ���ø�Order����
		 */
		String sql = "select * from orderitem where oid=?";
		List<Map<String,Object>> mapList = qr.query(sql, new MapListHandler(), order.getOid());
		List<OrderItem> orderItemList = toOrderItemList(mapList);
		
		order.setOrderitemList(orderItemList);
	}

	
	//�Ѷ��Mapת���ɶ��OrderItem
	@Override
	public List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {
		List<OrderItem> orderItemList = new ArrayList<OrderItem>();
		for (Map<String, Object> map : mapList) {
			OrderItem orderItem = toOrderItem(map);
			orderItemList.add(orderItem);
		}
		return orderItemList;
	}

	
	//��һ��Mapת����һ��OrderItem
	public OrderItem toOrderItem(Map<String, Object> map) {
		OrderItem orderItem = CommonUtils.toBean(map, OrderItem.class);
		Book book = CommonUtils.toBean(map, Book.class);
		orderItem.setBook(book);
		return orderItem;
	}

}
