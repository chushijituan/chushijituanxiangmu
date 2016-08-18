package com.bookmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.bean.Seller;
import com.bookmall.dao.SellerDao;
import com.bookmall.utils.DBUtil;

public class SellerDaoImpl implements SellerDao {
	private Connection conn=null;
	private PreparedStatement ps =null;
	private ResultSet rs =null;
	
	//���user�û���Ϣ
	@Override
	public Seller registerSeller(Seller seller) throws ClassNotFoundException, SQLException {
		conn=DBUtil.getConnection();
		String sql="insert into SELLER values (SE_11.nextval,?,?,?,?,?)";
		ps=conn.prepareStatement(sql);
		ps.setString(1, seller.getSname());
		ps.setString(2,seller.getSpassword());
		ps.setString(3, seller.getSemail());
		ps.setString(4, seller.getSidentification());
		ps.setString(5, seller.getSphone());
		ps.executeUpdate();
		return seller;
	}

	@Override
	public boolean findSeller(String sname, String spassword) throws SQLException, ClassNotFoundException {
		conn=DBUtil.getConnection();
		boolean valid=false;
		String sql="select * from SELLER where sname=? and spassword=? ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, sname);
		ps.setString(2, spassword);
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
	public Seller updateSeller(Seller seller) throws ClassNotFoundException, SQLException {
		conn=DBUtil.getConnection();
		String sql="update SELLER set sname=?,spassword=?,semail=?,sidentification=?,sphone=? where sid=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, seller.getSname());
		ps.setString(2,seller.getSpassword());
		ps.setString(3, seller.getSemail());
		ps.setString(4, seller.getSidentification());
		ps.setString(5, seller.getSphone());
		ps.setInt(6, seller.getSid());
		ps.executeUpdate();
		System.out.println(seller);
		DBUtil.getClose(conn, ps,rs);
		return seller;
		
	}

	@Override
	public boolean deleteSeller(int sid) throws ClassNotFoundException, SQLException {
		boolean valid=false;
		conn=DBUtil.getConnection();
		String sql="delete from SELLER where sid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1, sid);
		if(ps.executeUpdate()!=0){
			valid=true;
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}else{			
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}
	}

	@Override
	public List<Seller> getAllSellers() throws ClassNotFoundException, SQLException {
		List<Seller> list=new ArrayList<Seller>();
		conn=DBUtil.getConnection();
		String sql="select * from SELLER";
		ps=conn.prepareStatement(sql);
		rs=ps.executeQuery();
		while(rs.next()){
			Seller seller = new Seller();
			seller.setSid(rs.getInt("sid"));
			seller.setSname(rs.getString("sname"));
			seller.setSpassword(rs.getString("spassword"));
			seller.setSemail(rs.getString("semail"));
			seller.setSidentification(rs.getString("sidentification"));
			seller.setSphone(rs.getString("sphone"));
			list.add(seller);
		}
		DBUtil.getClose(conn, ps, rs);
		return list;
	}

	@Override
	public Seller findSeller1(String sname) throws ClassNotFoundException, SQLException {
		conn=DBUtil.getConnection();
		String sql="select * from SELLER where sname=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, sname);
		rs=ps.executeQuery();
		Seller seller=new Seller();
		while(rs.next()){
			seller.setSid(rs.getInt("sid"));
			seller.setSname(rs.getString("sname"));
			seller.setSpassword(rs.getString("spassword"));
			seller.setSidentification(rs.getString("sidentification"));
			seller.setSemail(rs.getString("semail"));
			seller.setSphone(rs.getString("sphone"));
		}
		return seller;
	}

	@Override
	public boolean deleteShop(int sid) throws ClassNotFoundException, SQLException {
		conn=DBUtil.getConnection();
		String sql="delete from SHOP where sid=?";
		ps=conn.prepareStatement(sql);
		ps.setInt(1,sid);
		ps.executeUpdate();
		boolean valid=false;
		if(ps.executeUpdate()!=0){
			valid=true;
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}else{			
			DBUtil.getClose(conn, ps, rs);
			return valid;
		}
		
	}

}
