package com.bookmall.test;

import java.util.List;

import com.bookmall.bean.Shop;
import com.bookmall.service.ShopService;
import com.bookmall.service.impl.ShopServiceImpl;

public class testShopDao {
	public static void main(String[] args) throws Exception {
		ShopService ss=new ShopServiceImpl();
		Shop shop=new Shop("储氏书店",1,"古今中外，无所不有，没有最好，只有更好");
		ss.addShop(shop);
		//ss.deleteShopById(1);
		//Shop shop=new Shop(2,"储氏书店",java.sql.Date.valueOf("2013-8-1"),1,"古今中外，无所不有，没有最好，只有更好");
		//ss.updateShop(shop);
		List<Shop> list=ss.getShopAll();
		System.out.println(list);
	}
}
