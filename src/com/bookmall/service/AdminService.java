package com.bookmall.service;

import java.sql.SQLException;
import java.util.List;

import com.bookmall.bean.Admin;
import com.bookmall.bean.Seller;
import com.bookmall.bean.User;

public interface AdminService {
	//����Ա��¼
	public boolean loginAdmin(String adminname, String adminpwd) throws ClassNotFoundException, SQLException;
	//����Ա�޸���������
	public Admin updateAdmin(Admin admin) throws ClassNotFoundException, SQLException;
	
	//����ͨ�û�����
	//����Ա�鿴���е��û���Ϣ
	public List<User> getAllUser() throws ClassNotFoundException, SQLException;
	//����Ա�޸��û���Ϣ
	public User updateUser(User user) throws ClassNotFoundException, SQLException;
	//����Աɾ���û�
	public boolean deleteUser(int cosuid) throws ClassNotFoundException, SQLException;
	
	//�����Ҳ���
	//�鿴����������Ϣ
	public List<Seller> getAllSellers() throws ClassNotFoundException, SQLException;
	//�޸�������Ϣ
	public Seller updateSeller(Seller seller) throws ClassNotFoundException, SQLException;
	//ɾ��������Ϣ
	public boolean deleteSeller(int sid) throws ClassNotFoundException, SQLException;
	public boolean deleteShop1(int sid) throws ClassNotFoundException, SQLException;
	public boolean deleteCARTITEM1(int cosuid) throws ClassNotFoundException, SQLException;
	public boolean deleteUSERORDER1(int cosuid) throws ClassNotFoundException, SQLException;
}
