package com.bookmall.test;

import java.sql.SQLException;
import java.util.ArrayList;
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
import com.bookmall.service.SellerService;
import com.bookmall.service.impl.SellerServiceImpl;

public class AllUserTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//test1();
		//test2();
		//test3();
		//test4();
		//test5();
		//test6();
		//test7();
		//test8();
		//test7();
		//test10();
		//test11();
	//	test12();
	}
	private static void test12() throws ClassNotFoundException, SQLException {
		List<User> userList=new ArrayList<User>();
		UserDao uDao =new UserDaoImpl();
		userList=uDao.getAllUser();
		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i));
		}
	}
	@SuppressWarnings("unused")
	private static void test11() throws ClassNotFoundException, SQLException {
		List<Seller> sellerList=new ArrayList<Seller>();
		SellerDao sellerDao=new SellerDaoImpl();
		sellerList=sellerDao.getAllSellers();
		for (int i = 0; i < sellerList.size(); i++) {
			System.out.println(sellerList.get(i));
		}
	}
	@SuppressWarnings("unused")
	private static void test1() throws ClassNotFoundException, SQLException {
		String adminname="admin1";
		String adminpwd="admin1";
		/*Admin admin=new Admin();
		admin.setAdminname(adminname);
		admin.setAdminpwd(adminpwd);*/
		AdminDao adminDao=new AdminDaoImpl();
		boolean ad=adminDao.findAdmin(adminname, adminpwd);
		System.out.println(ad);
	}
	@SuppressWarnings("unused")
	private static void test2() throws ClassNotFoundException, SQLException {
		Admin admin=new Admin();
		int adminid=1;
		String adminname="admin1";
		String adminpwd="admin1234";
		admin.setAdminid(adminid);
		admin.setAdminname(adminname);
		admin.setAdminpwd(adminpwd);
		AdminDao adminDao=new AdminDaoImpl();
		adminDao.updateAdmin(admin);
	}
	@SuppressWarnings("unused")
	private static void test3() throws ClassNotFoundException, SQLException{
		User user =new User();
		
		String loginname="wulei";
		String loginpass="wulei";
		String email="1234567@qq.com";
		String uphone="1234567";
		//user.setUid(cosuid);
		user.setLoginname(loginname);
		user.setLoginpass(loginpass);
		user.setEmail(email);
		user.setUphone(uphone);
		UserDao userDao=new UserDaoImpl();
		userDao.registerUser(user);
	}
	@SuppressWarnings("unused")
	private static void test4() throws ClassNotFoundException, SQLException {
		String loginname="wulei";
		String loginpss="wulei";
		UserDao userDao=new UserDaoImpl();
		boolean ad=userDao.findUser(loginname, loginpss);
		System.out.println(ad);
	}
	@SuppressWarnings("unused")
	private static void test5() throws ClassNotFoundException, SQLException{
		User user=new User();
		int cosuid=4;
		String loginname="wl";
		String loginpass="wl";
		String email="12333333@163.com";
		String uphone="11112222";
		user.setCosuid(cosuid);
		user.setLoginname(loginname);
		user.setLoginpass(loginpass);
		user.setEmail(email);
		user.setUphone(uphone);
		UserDao userDao=new UserDaoImpl();
		userDao.updateUser(user);
	}
	@SuppressWarnings("unused")
	private static void test6() throws ClassNotFoundException, SQLException{
		String loginname="wl";
		String loginpss="wl";
		UserDao userDao=new UserDaoImpl();
		boolean ad=userDao.findUser(loginname, loginpss);
		System.out.println(ad);
	}
	
	private static void test7() throws ClassNotFoundException, SQLException{
		Seller seller=new Seller();
		String sname="biaozha1";
		String spassword="biaozha1";
		String semail="199902029@163.com";
		String sidentification="1111222333311";
		String sphone="11222222";
		
		seller.setSname(sname);
		seller.setSpassword(spassword);
		seller.setSemail(semail);
		seller.setSphone(sphone);
		seller.setSphone(sphone);
		SellerService sellerService=new SellerServiceImpl();
		sellerService.registerSeller(seller);
	}
	@SuppressWarnings("unused")
	private static void test8() throws ClassNotFoundException, SQLException{
		String sname="wulei";
		String spassword="wulei";
		SellerDao sellerDao=new SellerDaoImpl();
		boolean ad=sellerDao.findSeller(sname, spassword);
		System.out.println(ad);
	}
	private static void test9() throws ClassNotFoundException, SQLException{
		Seller seller=new Seller();
		int sid=2;
		String sname="wulei";
		String spassword="wulei";
		String semail="1444444559@163.com";
		String sidentification="1111222333311";
		String sphone="112255520";
		seller.setSid(sid);
		seller.setSname(sname);
		seller.setSpassword(spassword);
		seller.setSemail(semail);
		seller.setSidentification(sidentification);
		seller.setSphone(sphone);
		SellerService sellerService=new SellerServiceImpl();
		sellerService.updateSeller(seller);
	}
	private static void test10() throws ClassNotFoundException, SQLException{
		int sid=1;
		SellerDao sellerDao=new SellerDaoImpl();
		boolean ad=sellerDao.deleteSeller(sid);
		System.out.println(ad);
	}
	
}
