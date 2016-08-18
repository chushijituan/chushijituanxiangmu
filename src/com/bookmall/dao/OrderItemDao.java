package com.bookmall.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bookmall.bean.Order;
import com.bookmall.bean.OrderItem;

public interface OrderItemDao {

	public void loadOrderItem(Order order) throws ClassNotFoundException, SQLException;
	
	public List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList);
	
}
