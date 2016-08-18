package com.bookmall.test;

import java.util.List;

import com.bookmall.bean.Book;
import com.bookmall.service.BookService;
import com.bookmall.service.impl.BookServiceImpl;

public class testBookDao {
	public static void main(String[] args) throws Exception {
		BookService bs=new BookServiceImpl();
		java.sql.Date publish=java.sql.Date.valueOf("2013-4-5");
		//添加图书对象
		//Book book=new Book("WEB开发","樊梦园",80,56,0.6,"清华大学出版社",publish,1,"book/4.jpg",1);
		//bs.addBook(book);
		//bs.deletBookById(6);
		Book book=new Book(5,"WEB开发","储振浩",80,56,0.6,"清华大学出版社",publish,1,"book/4.jpg",1);
		bs.updateBook(book);
		book=bs.getBookById(5);
		System.out.println(book);
		List<Book> list=bs.getBookByName("WEB开发");
		System.out.println(book);
		list=bs.getBookAll();
		for(Book bk:list)
		System.out.println(bk);
	}
}
