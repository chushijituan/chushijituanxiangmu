package com.bookmall.dao;

import java.sql.SQLException;

import com.bookmall.bean.Admin;

public interface AdminDao {
	public boolean findAdmin(String adminname,String adminpwd) throws ClassNotFoundException, SQLException;//����Ա��¼,������������
	public Admin updateAdmin(Admin admin) throws ClassNotFoundException, SQLException;//�޸Ĺ���Ա����
}
