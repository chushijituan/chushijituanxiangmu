package com.bookmall.service.impl;

import java.sql.SQLException;

import com.bookmall.bean.User;
import com.bookmall.dao.UserDao;
import com.bookmall.dao.impl.UserDaoImpl;
import com.bookmall.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao=null;
	public UserServiceImpl() {
		userDao=new UserDaoImpl();
	}
	@Override
	public User registerUser(User user) throws ClassNotFoundException, SQLException {
		return userDao.registerUser(user);
	}

	@Override
	public boolean login(String loginname, String loginpass) throws ClassNotFoundException, SQLException {
		return userDao.findUser(loginname, loginpass);
	}

	@Override
	public User updateUser(User user) throws ClassNotFoundException, SQLException {
		return userDao.updateUser(user);
	}
	@Override
	public User findUser(String loginname)throws ClassNotFoundException, SQLException {
		return userDao.findUser1(loginname);
	}
	@Override
	public User findUser1(int cosuid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return userDao.findUser2(cosuid);
	}
	
	

}
