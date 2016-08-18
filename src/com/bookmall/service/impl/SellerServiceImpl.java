package com.bookmall.service.impl;

import java.sql.SQLException;

import com.bookmall.bean.Seller;
import com.bookmall.dao.SellerDao;
import com.bookmall.dao.impl.SellerDaoImpl;
import com.bookmall.service.SellerService;

public class SellerServiceImpl implements SellerService {
	SellerDao sellerDao=null;
	public SellerServiceImpl() {
		sellerDao=new SellerDaoImpl();
	}
	@Override
	public Seller registerSeller(Seller seller) throws ClassNotFoundException, SQLException {
		return sellerDao.registerSeller(seller);
	}
	@Override
	public boolean loginSeller(String sname, String spassword) throws ClassNotFoundException, SQLException {
		return sellerDao.findSeller(sname, spassword);
	}
	@Override
	public Seller updateSeller(Seller seller) throws ClassNotFoundException, SQLException {
		return sellerDao.updateSeller(seller);
	}
	@Override
	public Seller findSeller(String sname) throws ClassNotFoundException, SQLException {
		return sellerDao.findSeller1(sname);
	}
	
}
