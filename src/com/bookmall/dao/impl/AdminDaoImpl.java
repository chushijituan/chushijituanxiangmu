package com.bookmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.driver.DBConversion;

import com.bookmall.bean.Admin;
import com.bookmall.dao.AdminDao;
import com.bookmall.utils.DBUtil;

public class AdminDaoImpl implements AdminDao {
	private Connection conn=null;
	private PreparedStatement ps =null;
	private ResultSet rs =null;

	@Override
	public boolean findAdmin(String adminname, String adminpwd) throws ClassNotFoundException, SQLException {
		boolean valid=false;
		conn=DBUtil.getConnection();

		String sql="select * from ADMINUSER where adminname=? and adminpwd=? ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, adminname);
		ps.setString(2, adminpwd);
		rs=ps.executeQuery();
		if(rs.next()){
			valid=true;
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}else{		
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}
	}

	@Override
	public Admin updateAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		conn=DBUtil.getConnection();
		String sql="update ADMINUSER set  adminpwd=? where adminid=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, admin.getAdminpwd());
		ps.setInt(2, admin.getAdminid());
		ps.executeUpdate();
		DBUtil.getClose(conn, ps,rs);
		return admin;
	}
	

}
