package com.bookmall.dao;

import java.util.List;

import com.bookmall.bean.Book;

public interface BookDao {
	public void addBook(Book book) throws Exception;
	public void deletBookById(int bid) throws Exception;
	public void updateBook(Book book) throws Exception;
	public Book getBookById(int bid) throws Exception;
	public List<Book> getBookByName(String bname) throws Exception;
	public List<Book> getBookAll() throws Exception;
	public List<Book> getBookShopid(int shopid) throws Exception;
	public List<Book> getBookByshopid(int shopid) throws Exception;
	public List<Book> getBookBypage(int start,int end) throws Exception;
	public List<Book> getBookLikeName(String bname,int start,int end) throws Exception;
	public List<Book> getBookByCid(int cid,int start,int end) throws Exception;
	
}
