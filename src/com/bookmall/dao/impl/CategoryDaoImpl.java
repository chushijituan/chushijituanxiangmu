package com.bookmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.bean.Category;
import com.bookmall.dao.CategoryDao;
import com.bookmall.utils.DBUtil;

public class CategoryDaoImpl implements CategoryDao{
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	
	@Override
	public Category getCidByname(String cname) throws Exception{
		// TODO Auto-generated method stub
		Category category=null; 
		conn=DBUtil.getConnection();
		String sql="select * from category where cname=? order by cid";
		pst=conn.prepareStatement(sql);
		pst.setString(1, cname);
		rs=pst.executeQuery();
		while(rs.next()){
			category=new Category(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
		}
		DBUtil.getClose(conn, pst, rs);
		return category;
	}
	
	@Override
	public List<Category> getCateBypid(int pid) throws Exception {
		// TODO Auto-generated method stub
		List<Category> list=new ArrayList<Category>();
		Category category=null; 
		conn=DBUtil.getConnection();
		String sql="select * from category where pid=? order by cid";
		pst=conn.prepareStatement(sql);
		pst.setInt(1, pid);
		rs=pst.executeQuery();
		while(rs.next()){
			category=new Category(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
			list.add(category);
		}
		DBUtil.getClose(conn, pst, rs);
		return list;
	}
	
	
	@Override
	public List<String> getCatePname() throws Exception {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		conn=DBUtil.getConnection();
		String sql="select cname from category where pid=0 order by cid" ;
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()){
			list.add(rs.getString(1));
		}
		DBUtil.getClose(conn, pst, rs);
		return list;
	}
	@Override
	public List<String> getCateCname() throws Exception {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		conn=DBUtil.getConnection();
		String sql="select cname from category where pid not in 0 order by cid";
		pst=conn.prepareStatement(sql);
		rs=pst.executeQuery();
		while(rs.next()){
			list.add(rs.getString(1));
		}
		DBUtil.getClose(conn, pst, rs);
		return list;
	}
	@Override
	public Category getCidBycid(int cid) throws Exception {
		// TODO Auto-generated method stub
		Category category=null; 
		conn=DBUtil.getConnection();
		String sql="select * from category where cid=? ";
		pst=conn.prepareStatement(sql);
		pst.setInt(1, cid);
		rs=pst.executeQuery();
		while(rs.next()){
			category=new Category(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4));
		}
		DBUtil.getClose(conn, pst, rs);
		return category;
	}
	
}
