package com.bookmall.service.impl;

import java.util.List;

import com.bookmall.bean.Shop;
import com.bookmall.dao.ShopDao;
import com.bookmall.dao.impl.ShopDaoImpl;
import com.bookmall.service.ShopService;

public class ShopServiceImpl implements ShopService{

	@Override
	public void addShop(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		ShopDao sd=new ShopDaoImpl();
		sd.addShop(shop);
	}

	@Override
	public void deleteShopById(int shopid) throws Exception {
		// TODO Auto-generated method stub
		ShopDao sd=new ShopDaoImpl();
		sd.deleteShopById(shopid);
	}

	@Override
	public void updateShop(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		ShopDao sd=new ShopDaoImpl();
		sd.updateShop(shop);
	}

	@Override
	public Shop getShopById(int shopid) throws Exception {
		// TODO Auto-generated method stub
		ShopDao sd=new ShopDaoImpl();
		return sd.getShopById(shopid);
	}

	@Override
	public Shop getShopByName(String shopname) throws Exception {
		// TODO Auto-generated method stub
		ShopDao sd=new ShopDaoImpl();
		return sd.getShopByName(shopname);
	}

	@Override
	public List<Shop> getShopAll() throws Exception {
		// TODO Auto-generated method stub
		ShopDao sd=new ShopDaoImpl();
		return sd.getShopAll();
	}

	@Override
	public Shop getShopBysid(int sid) throws Exception {
		// TODO Auto-generated method stub
		ShopDao sd=new ShopDaoImpl();
		return sd.getShopBysid(sid);
	}



}
