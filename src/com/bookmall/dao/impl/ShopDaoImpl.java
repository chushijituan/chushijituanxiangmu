package com.bookmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.bean.Shop;
import com.bookmall.dao.ShopDao;
import com.bookmall.utils.DBUtil;

public class ShopDaoImpl implements ShopDao{
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	java.sql.Date sysdate;
	@Override
	public void addShop(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConnection();
			String sql="insert into shop values(SE_12.nextval,?,sysdate,?,?)";
			pst=conn.prepareStatement(sql);
			//1.shopid 2.shopname 3.createtime 4.shopdesc 5.shopid 
			pst.setString(1, shop.getShopname());
			pst.setInt(2, shop.getSid());
			pst.setString(3, shop.getShopdesc());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.getClose(conn, pst, null);
		}
		
	}

	@Override
	public void deleteShopById(int shopid) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConnection();
			String sql="delete from shop where shopid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, shopid);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.getClose(conn, pst, null);
		}
	}

	@Override
	public void updateShop(Shop shop) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConnection();
			String sql="update shop set shopname=?,createtime=?, shopdesc=? where shopid=?";
			pst=conn.prepareStatement(sql);
			//1.shopname 2.createtime 3.shopdesc 4.shopid 
			pst.setString(1, shop.getShopname());
			pst.setDate(2, shop.getCreatetime());
			pst.setString(3, shop.getShopdesc());
			pst.setInt(4, shop.getShopid());
			pst.executeUpdate();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.getClose(conn, pst, null);
		}
	}

	@Override
	public Shop getShopById(int shopid) throws Exception {
		// TODO Auto-generated method stub
		Shop shop=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from shop where shopid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, shopid);
			rs=pst.executeQuery();
			while(rs.next()){
				//1.shopid 2.shopname 3.createtime 4.shopdesc 5.shopid 
				shop=new Shop(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4),rs.getString(5));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.getClose(conn, pst, rs);
		}
		return shop;
	}

	@Override
	public Shop getShopByName(String shopname) throws Exception {
		// TODO Auto-generated method stub
		Shop shop=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from shop where shopname=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, shopname);;
			rs=pst.executeQuery();
			while(rs.next()){
				shop=new Shop(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4),rs.getString(5));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.getClose(conn, pst, rs);
		}
		return shop;
	}
	
	@Override
	public List<Shop> getShopAll() throws Exception {
		List<Shop> list=new ArrayList<Shop>();
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConnection();
			String sql="select * from shop";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				Shop shop=new Shop();
				//1.shopid 2.shopname 3.createtime 4.shopdesc 5.shopid 
				shop.setShopid(rs.getInt(1));
				shop.setShopname(rs.getString(2));
				shop.setCreatetime(rs.getDate(3));
				shop.setSid(rs.getInt(4));
				shop.setShopdesc(rs.getString(5));
				list.add(shop);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.getClose(conn, pst, rs);
		}
		return list;
	}

	@Override
	public Shop getShopBysid(int sid) throws Exception {
		// TODO Auto-generated method stub
		conn=DBUtil.getConnection();
		Shop shop=null;
		String sql="select * from shop where sid=?";
		pst=conn.prepareStatement(sql);
		pst.setInt(1, sid);
		rs=pst.executeQuery();
		while(rs.next()){
			shop=new Shop(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5));
		}
		DBUtil.getClose(conn, pst, rs);
		return shop;
	}
	
}
