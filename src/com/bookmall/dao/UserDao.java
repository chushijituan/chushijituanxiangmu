package com.bookmall.dao;

import java.sql.SQLException;
import java.util.List;

import com.bookmall.bean.User;

public interface UserDao {
	public User registerUser(User user) throws ClassNotFoundException, SQLException;//ע��
	public boolean findUser(String loginname,String loginpass) throws SQLException, ClassNotFoundException;//���ҵ�¼�������������
	public User findUser1(String loginname) throws ClassNotFoundException, SQLException;
	public User updateUser(User user) throws SQLException, ClassNotFoundException;//�޸�user�û���Ϣ
	public boolean deleteUser(int cosuid) throws ClassNotFoundException, SQLException;
	public List<User> getAllUser() throws ClassNotFoundException, SQLException;
	public boolean deleteCARTITEM(int cosuid) throws ClassNotFoundException, SQLException;
	public boolean deleteUSERORDER(int cosuid) throws ClassNotFoundException, SQLException;
	public User findUser2(int cosuid) throws ClassNotFoundException, SQLException;
	
}
