package com.bookmall.service;

import java.sql.SQLException;

import com.bookmall.bean.Seller;

public interface SellerService {
	//卖家注册
	public Seller registerSeller(Seller seller) throws ClassNotFoundException, SQLException;
	//卖家修改自身的信息
	public boolean loginSeller(String sname,String spassword) throws ClassNotFoundException, SQLException;
	//卖家修改自身信息
	public Seller updateSeller(Seller seller) throws ClassNotFoundException, SQLException;
	
	public Seller findSeller(String sname) throws ClassNotFoundException, SQLException;
}
