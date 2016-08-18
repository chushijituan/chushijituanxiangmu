package com.bookmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.bean.Book;
import com.bookmall.bean.CartItem;
import com.bookmall.bean.CartItemAnBook;
import com.bookmall.dao.CartItemDao;
import com.bookmall.utils.DBUtil;

public class CartItemDaoImpl implements CartItemDao{
	
	public Connection connection = null;
	public PreparedStatement pStatement = null;
	public ResultSet resultSet = null;

	
	@Override
	public List<CartItem> selectCartItemByCosuid(int cosuid) throws ClassNotFoundException, SQLException {
		connection = DBUtil.getConnection();
		String sql = "select * from cartitem where cosuid=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, cosuid);
		resultSet = pStatement.executeQuery();
		List<CartItem> list = new ArrayList<CartItem>();
		CartItem cartItem = null;
		while(resultSet.next()){
			cartItem = new CartItem();
			cartItem.setCartitemid(resultSet.getInt("cartItemId"));	
			cartItem.setQuantity(resultSet.getInt("quantity"));		
			cartItem.setBid(resultSet.getInt("bid"));				
			cartItem.setCosuid(resultSet.getInt("cosuid"));			
			list.add(cartItem);
		}
		DBUtil.getClose(connection, pStatement, resultSet);
		return list;
	}
	
	
	@Override
	public List<Book> selectBookByCosuid(int cosuid) throws ClassNotFoundException, SQLException {
		connection = DBUtil.getConnection();
		String sql = "select bname,currprice,bid from book where bid in (select bid from cartitem where cosuid=?)";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, cosuid);
		resultSet = pStatement.executeQuery();
		List<Book> list = new ArrayList<Book>();
		Book book = null;
		while(resultSet.next()){
			book = new Book();
			book.setBid(resultSet.getInt("bid"));					
			book.setBname(resultSet.getString("bname"));			
			
			book.setCurrprice(resultSet.getDouble("currprice"));			
			
			list.add(book);
		}
		DBUtil.getClose(connection, pStatement, resultSet);
		return list;
	}
	
	
	
	
	@Override
	public int selectCartItemQuantity(int bid,int cosuid) throws ClassNotFoundException, SQLException {
		int quantity = 0;
		connection = DBUtil.getConnection();
		String sql = "select quantity from cartitem where bid=? and cosuid=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, bid);
		pStatement.setInt(2, cosuid);
		resultSet = pStatement.executeQuery();
		while(resultSet.next()){
			quantity = resultSet.getInt(1);
		}
		DBUtil.getClose(connection, pStatement, resultSet);
		return quantity;
	}
	
	
	@Override
	public List<CartItemAnBook> selectCartItemAnBookByCosuid(int cosuid) throws ClassNotFoundException, SQLException {
		connection = DBUtil.getConnection();
		String sql = "select c.bid,b.bname,b.currprice,c.quantity from book b, cartitem c where b.bid=c.bid and c.cosuid=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, cosuid);
		resultSet = pStatement.executeQuery();
		List<CartItemAnBook> list = new ArrayList<CartItemAnBook>();
		CartItemAnBook cartItemAnBook = null;
		while(resultSet.next()){
			cartItemAnBook = new CartItemAnBook();
			cartItemAnBook.setBid(resultSet.getInt("bid"));				
			cartItemAnBook.setBname(resultSet.getString("bname"));		
			cartItemAnBook.setCurrprice(resultSet.getDouble("currprice"));		
			cartItemAnBook.setQuantity(resultSet.getInt("quantity"));																//ͼ������
			list.add(cartItemAnBook);
		}
		DBUtil.getClose(connection, pStatement, resultSet);
		
		return list;
	}
	

	@Override
	public void insertCartItemBycartItemId(CartItem cartItem) throws ClassNotFoundException, SQLException {
		connection = DBUtil.getConnection();
		String sql = "insert into cartitem values(SE_3.nextval,?,?,?)";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, cartItem.getQuantity());
		pStatement.setInt(2, cartItem.getBid());
		pStatement.setInt(3, cartItem.getCosuid());
		pStatement.executeUpdate();
		DBUtil.getClose(connection, pStatement, null);
	}

	//�޸Ĺ��ﳵ���������
	@Override
	public void updateCartItemBycartItemId(int quantity,int bid) throws ClassNotFoundException, SQLException {
		connection = DBUtil.getConnection();
		String sql = "update cartitem set quantity=? where bid=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, quantity);
		pStatement.setInt(2, bid);
		pStatement.executeUpdate();
		DBUtil.getClose(connection, pStatement, null);
	}
	

		@Override
		public void updateCartItemByBidAndcosuid(int quantity,int bid,int cosuid) throws ClassNotFoundException, SQLException {
		connection = DBUtil.getConnection();
		String sql = "update cartitem set quantity=? where bid=? and cosuid=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, quantity);
		pStatement.setInt(2, bid);
		pStatement.setInt(3, cosuid);
		pStatement.executeUpdate();
		DBUtil.getClose(connection, pStatement, null);
	}


	
	@Override
	public void deleteCartItemBycartItemId(int bid,int cosuid) throws ClassNotFoundException, SQLException {
		connection = DBUtil.getConnection();
		String sql = "delete from cartitem where bid=? and cosuid=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, bid);
		pStatement.setInt(2, cosuid);
		pStatement.executeUpdate();
		DBUtil.getClose(connection, pStatement, null);
	}


	@Override
	public CartItem selectCartItem(int bid, int cosuid)
			throws ClassNotFoundException, SQLException {
		CartItem cartitem=new CartItem();
		
		connection = DBUtil.getConnection();
		String sql = "select * from cartitem where bid=? and cosuid=?";
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, bid);
		pStatement.setInt(2, cosuid);
		resultSet = pStatement.executeQuery();
		if(resultSet.next()){
			cartitem=new CartItem();
			cartitem.setCartitemid(resultSet.getInt(1));
			cartitem.setQuantity(resultSet.getInt(2));
			cartitem.setBid(resultSet.getInt(3));
			cartitem.setCosuid(resultSet.getInt(4));
			
			
		}
		DBUtil.getClose(connection, pStatement, resultSet);
		
		
		
		
		
		return cartitem;
	}

}
