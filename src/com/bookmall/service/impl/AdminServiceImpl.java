package com.bookmall.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bookmall.bean.Admin;
import com.bookmall.bean.Seller;
import com.bookmall.bean.User;
import com.bookmall.dao.AdminDao;
import com.bookmall.dao.SellerDao;
import com.bookmall.dao.UserDao;
import com.bookmall.dao.impl.AdminDaoImpl;
import com.bookmall.dao.impl.SellerDaoImpl;
import com.bookmall.dao.impl.UserDaoImpl;
import com.bookmall.service.AdminService;

public class AdminServiceImpl implements AdminService {
	AdminDao adminDao=null;
	UserDao userDao=null;
	SellerDao sellerDao=null;
	public AdminServiceImpl() {
		adminDao=new AdminDaoImpl();
		userDao=new UserDaoImpl();
		sellerDao=new SellerDaoImpl();
	}
	@Override
	public boolean loginAdmin(String adminname, String adminpwd) throws ClassNotFoundException, SQLException {
		
		return adminDao.findAdmin(adminname, adminpwd);
	}

	@Override
	public Admin updateAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		return adminDao.updateAdmin(admin);
	}

	@Override
	public List<User> getAllUser() throws ClassNotFoundException, SQLException {
		return userDao.getAllUser();
	}

	@Override
	public User updateUser(User user) throws ClassNotFoundException, SQLException {
		return userDao.updateUser(user);
	}

	

	@Override
	public List<Seller> getAllSellers() throws ClassNotFoundException, SQLException {
		return sellerDao.getAllSellers();
	}

	@Override
	public Seller updateSeller(Seller seller) throws ClassNotFoundException, SQLException {
		return sellerDao.updateSeller(seller);
	}

	@Override
	public boolean deleteSeller(int sid) throws ClassNotFoundException, SQLException {
		return sellerDao.deleteSeller(sid);
	}
	@Override
	public boolean deleteShop1(int sid) throws ClassNotFoundException, SQLException {
		return sellerDao.deleteShop(sid);
	}
	@Override
	public boolean deleteCARTITEM1(int cosuid) throws ClassNotFoundException, SQLException {
		return userDao.deleteCARTITEM(cosuid);
	}
	@Override
	public boolean deleteUSERORDER1(int cosuid) throws ClassNotFoundException, SQLException {
		return userDao.deleteUSERORDER(cosuid);
	}
	@Override
	public boolean deleteUser(int cosuid) throws ClassNotFoundException,SQLException {
		return userDao.deleteUser(cosuid);
	}

}
