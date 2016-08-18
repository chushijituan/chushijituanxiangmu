package com.bookmall.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookmall.bean.Seller;

public interface SellerDao {
	public Seller registerSeller(Seller seller) throws ClassNotFoundException, SQLException;//ע��
	public boolean findSeller(String sname,String spassword) throws SQLException, ClassNotFoundException;//���ң���¼���������������
	public Seller updateSeller(Seller seller) throws ClassNotFoundException, SQLException;//�޸�seller�û���Ϣ
	public boolean deleteSeller(int sid) throws ClassNotFoundException, SQLException;//�����������ɾ�������û�
	public List<Seller> getAllSellers() throws ClassNotFoundException, SQLException;
	public Seller findSeller1(String sname) throws ClassNotFoundException, SQLException;
	public boolean deleteShop(int sid) throws ClassNotFoundException, SQLException;
}
