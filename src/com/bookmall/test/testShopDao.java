package com.bookmall.test;

import java.util.List;

import com.bookmall.bean.Shop;
import com.bookmall.service.ShopService;
import com.bookmall.service.impl.ShopServiceImpl;

public class testShopDao {
	public static void main(String[] args) throws Exception {
		ShopService ss=new ShopServiceImpl();
		Shop shop=new Shop("�������",1,"�Ž����⣬�������У�û����ã�ֻ�и���");
		ss.addShop(shop);
		//ss.deleteShopById(1);
		//Shop shop=new Shop(2,"�������",java.sql.Date.valueOf("2013-8-1"),1,"�Ž����⣬�������У�û����ã�ֻ�и���");
		//ss.updateShop(shop);
		List<Shop> list=ss.getShopAll();
		System.out.println(list);
	}
}
