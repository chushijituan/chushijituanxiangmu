package com.bookmall.service;

import java.sql.SQLException;

import com.bookmall.bean.User;

public interface UserService {
	//�û�ע��
	public User registerUser(User user) throws ClassNotFoundException, SQLException;
	//�û���¼
	public boolean login(String loginname,String loginpass) throws ClassNotFoundException, SQLException;
	//�û��޸�������Ϣ
	public User updateUser(User user) throws ClassNotFoundException, SQLException;
	public User findUser(String loginname) throws ClassNotFoundException, SQLException;
	public User findUser1(int cosuid) throws ClassNotFoundException, SQLException;
	
}
	