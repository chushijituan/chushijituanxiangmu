package com.bookmall.service;

import java.sql.SQLException;

import com.bookmall.bean.Seller;

public interface SellerService {
	//����ע��
	public Seller registerSeller(Seller seller) throws ClassNotFoundException, SQLException;
	//�����޸��������Ϣ
	public boolean loginSeller(String sname,String spassword) throws ClassNotFoundException, SQLException;
	//�����޸�������Ϣ
	public Seller updateSeller(Seller seller) throws ClassNotFoundException, SQLException;
	
	public Seller findSeller(String sname) throws ClassNotFoundException, SQLException;
}
