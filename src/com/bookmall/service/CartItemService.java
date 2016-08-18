package com.bookmall.service;

import java.sql.SQLException;
import java.util.List;

import com.bookmall.bean.Book;
import com.bookmall.bean.CartItem;
import com.bookmall.bean.CartItemAnBook;

public interface CartItemService {

		
		public List<CartItem> selectCartItemByCosuid(int cosuid) throws ClassNotFoundException, SQLException;
		
		
		public List<Book> selectBookByCosuid(int cosuid) throws ClassNotFoundException, SQLException;
		
		
		public int selectCartItemQuantity(int bid,int cosuid) throws ClassNotFoundException, SQLException;
		
		
		public List<CartItemAnBook> selectCartItemAnBookByCosuid(int cosuid) throws ClassNotFoundException, SQLException;
		

		public void insertCartItemBycartItemId(CartItem cartItem) throws ClassNotFoundException, SQLException;
		
	
		public void updateCartItemBycartItemId(int quantity,int bid) throws ClassNotFoundException, SQLException;
		
		
		public void updateCartItemByBidAndcosuid(int quantity,int bid,int cosuid) throws ClassNotFoundException, SQLException;
		
	
		public void deleteCartItemBycartItemId(int bid,int cosuid) throws ClassNotFoundException, SQLException;
		
		public CartItem selectCartItem(int bid,int cosuid) throws ClassNotFoundException, SQLException;
		
		
}
