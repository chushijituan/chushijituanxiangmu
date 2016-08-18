package com.bookmall.dao;

import java.sql.SQLException;

import com.bookmall.bean.Admin;

public interface AdminDao {
	public boolean findAdmin(String adminname,String adminpwd) throws ClassNotFoundException, SQLException;//管理员登录,根据姓名密码
	public Admin updateAdmin(Admin admin) throws ClassNotFoundException, SQLException;//修改管理员密码
}
