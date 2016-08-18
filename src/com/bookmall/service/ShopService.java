package com.bookmall.service;

import java.util.List;

import com.bookmall.bean.Shop;

public interface ShopService {
	public void addShop(Shop shop) throws Exception;
	public void deleteShopById(int shopid) throws Exception;
	public void updateShop(Shop shop) throws Exception;
	public Shop getShopById(int shopid) throws Exception;
	public Shop getShopByName(String shopname) throws Exception;
	public Shop getShopBysid(int sid) throws Exception;
	public List<Shop> getShopAll() throws Exception;
}
