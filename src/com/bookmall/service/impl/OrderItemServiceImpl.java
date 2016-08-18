package com.bookmall.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.bookmall.bean.Order;
import com.bookmall.bean.OrderItem;
import com.bookmall.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService{

	@Override
	public void loadOrderItem(Order order) throws ClassNotFoundException,
			SQLException {
		
	}

	@Override
	public List<OrderItem> toOrderItemList(List<Map<String, Object>> mapList) {

		return null;
	}

	@Override
	public OrderItem toOrderItem(Map<String, Object> map) {

		return null;
	}

}
