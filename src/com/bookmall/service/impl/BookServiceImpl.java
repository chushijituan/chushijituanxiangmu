package com.bookmall.service.impl;

import java.util.List;

import com.bookmall.bean.Book;
import com.bookmall.dao.BookDao;
import com.bookmall.dao.impl.BookDaoImpl;
import com.bookmall.service.BookService;

public class BookServiceImpl implements BookService{

	@Override
	public void addBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		bd.addBook(book);
		
	}

	@Override
	public void deletBookById(int bookid) throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		bd.deletBookById(bookid);
	}

	@Override
	public void updateBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		bd.updateBook(book);
		
	}

	@Override
	public Book getBookById(int bookid) throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		return bd.getBookById(bookid);
	}

	@Override
	public List<Book> getBookByName(String bname) throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		return bd.getBookByName(bname);
	}

	@Override
	public List<Book> getBookAll() throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		return bd.getBookAll();
	}

	@Override
	public List<Book> getBookByshopid(int shopid) throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		return bd.getBookByshopid(shopid);
	}

	@Override
	public List<Book> getBookShopid(int shopid) throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		return bd.getBookShopid(shopid);
	}

	@Override
	public List<Book> getBookBypage(int start,int end) throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		return bd.getBookBypage(start,end);
	}

	@Override
	public List<Book> getBookLikeName(String bname,int start,int end) throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		return bd.getBookLikeName(bname,start,end);
	}

	@Override
	public List<Book> getBookByCid(int cid,int start,int end) throws Exception {
		// TODO Auto-generated method stub
		BookDao bd=new BookDaoImpl();
		return bd.getBookByCid(cid,start,end);
	}

	


}
