package com.bookmall.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.bookmall.bean.Book;
import com.bookmall.bean.CartItem;
import com.bookmall.bean.CartItemAnBook;
import com.bookmall.dao.CartItemDao;
import com.bookmall.dao.impl.CartItemDaoImpl;
import com.bookmall.service.CartItemService;

public class CartItemServiceImpl implements CartItemService{

	CartItemDao cartitemDao = new CartItemDaoImpl();
	

	@Override
	public List<CartItem> selectCartItemByCosuid(int cosuid) throws ClassNotFoundException, SQLException {
		
		return cartitemDao.selectCartItemByCosuid(cosuid);
	}

	
	@Override
	public List<Book> selectBookByCosuid(int cosuid) throws ClassNotFoundException, SQLException {
		
		return cartitemDao.selectBookByCosuid(cosuid);
	}
	
	
	
	public int selectCartItemQuantity(int bid,int cosuid) throws ClassNotFoundException, SQLException{
		
		return cartitemDao.selectCartItemQuantity(bid, cosuid);
	}
	
	
	@Override
	public List<CartItemAnBook> selectCartItemAnBookByCosuid(int cosuid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return cartitemDao.selectCartItemAnBookByCosuid(cosuid);
	}

	
	@Override
	public void insertCartItemBycartItemId(CartItem cartItem) throws ClassNotFoundException, SQLException {
		
		cartitemDao.insertCartItemBycartItemId(cartItem);
		
	}

	
	@Override
	public void updateCartItemBycartItemId(int quantity, int bid) throws ClassNotFoundException, SQLException {
		cartitemDao.updateCartItemBycartItemId(quantity, bid);
		
	}
	
	
	@Override
	public void updateCartItemByBidAndcosuid(int quantity,int bid,int cosuid) throws ClassNotFoundException, SQLException {
		cartitemDao.updateCartItemByBidAndcosuid(quantity,bid, cosuid);
			
	}

	
	@Override
	public void deleteCartItemBycartItemId(int bid,int cosuid) throws ClassNotFoundException, SQLException {
		cartitemDao.deleteCartItemBycartItemId(bid,cosuid);
		
	}


	@Override
	public CartItem selectCartItem(int bid, int cosuid)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return cartitemDao.selectCartItem(bid, cosuid);
	}

}
