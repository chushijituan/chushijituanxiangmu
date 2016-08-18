package com.bookmall.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bookmall.bean.Book;
import com.bookmall.dao.BookDao;
import com.bookmall.utils.DBUtil;


public class BookDaoImpl implements BookDao{
	Connection conn=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	/*
	 *���book��Ϣ(addBook) 
	 */
	@Override
	public void addBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConnection();
			String sql="insert into book values(SE_14.nextval,?,?,?,?,?,?,?,?,?,?)";
			pst=conn.prepareStatement(sql);
			//1.bid 2.bname 3.author 4.price 5.currprice 6.discount 7.press 8.publishtime 9.cid 10.image 11.shopid 
			pst.setString(1,book.getBname());
			pst.setString(2, book.getAuthor());
			pst.setDouble(3, book.getPrice());
			pst.setDouble(4, book.getCurrprice());
			pst.setDouble(5, book.getDiscount());
			pst.setString(6, book.getPress());
			pst.setDate(7, book.getPublishtime());
			pst.setInt(8, book.getCid());
			pst.setString(9, book.getImage());
			pst.setInt(10, book.getShopid());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
				DBUtil.getClose(conn, pst, null);
		}
		
		 
	}

	@Override
	public void deletBookById(int bid) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConnection();
			String sql="delete from book where bid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, bid);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.getClose(conn, pst, null);
		}
		
	}

	@Override
	public void updateBook(Book book) throws Exception {
		// TODO Auto-generated method stub
		try {
			conn=DBUtil.getConnection();
			String sql="update book set bname=?,author=?,price=?,currprice=?,discount=?,press=?,publishtime=?,cid=?,image=? where bid=?";
			//1.bname 2.author 3.price 4.currprice 5.discount 6.press 7.publishtime 8.cid 9.image 10.shopid 11.bid
			pst=conn.prepareStatement(sql);
			pst.setString(1, book.getBname());
			pst.setString(2, book.getAuthor());
			pst.setDouble(3, book.getPrice());
			pst.setDouble(4, book.getCurrprice());
			pst.setDouble(5, book.getDiscount());
			pst.setString(6, book.getPress());
			pst.setDate(7,book.getPublishtime());
			pst.setInt(8,book.getCid());
			pst.setString(9, book.getImage());
			pst.setInt(10, book.getBid());
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.getClose(conn, pst, null);
		}

		
	}

	@Override
	public Book getBookById(int bid) throws Exception {
		// TODO Auto-generated method stub
		Book book=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from book where bid=?";
			pst=conn.prepareStatement(sql);
			pst.setInt(1, bid);
			rs=pst.executeQuery();
			while(rs.next()){
				//1.bid 2.bname 3.author 4.price 5.currprice 6.discount 7.press 8.publishtime 9.cid 10.image 11.shopid 
			 book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getDate(8),rs.getInt(9),rs.getString(10),rs.getInt(11));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.getClose(conn, pst, rs);
		}
		return book;
	}

	@Override
	public List<Book> getBookByName(String bname) throws Exception {
		// TODO Auto-generated method stub
		List<Book> list=new ArrayList<Book>();
		try {
			conn=DBUtil.getConnection();
			String sql="select * from book where bname=?";
			pst=conn.prepareStatement(sql);
			pst.setString(1, bname);
			rs=pst.executeQuery();
			while(rs.next()){
				//1.bid 2.bname 3.author 4.price 5.currprice 6.discount 7.press 8.publishtime 9.cid 10.image 11.shopid 
				Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getDate(8),rs.getInt(9),rs.getString(10),rs.getInt(11));
				list.add(book);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.getClose(conn, pst, rs);
		}
		return list;
	}

	@Override
	public List<Book> getBookAll() throws Exception {
		// TODO Auto-generated method stub
		List<Book> list=new ArrayList<Book>();
		try {
			conn=DBUtil.getConnection();
			String sql="select * from book";
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				//1.bid 2.bname 3.author 4.price 5.currprice 6.discount 7.press 8.publishtime 9.cid 10.image 11.shopid 
				Book book=new Book();
				book.setBid(rs.getInt(1));
				book.setBname(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setPrice(rs.getDouble(4));
				book.setCurrprice(rs.getDouble(5));
				book.setDiscount(rs.getDouble(6));
				book.setPress(rs.getString(7));
				book.setPublishtime(rs.getDate(8));
				book.setCid(rs.getInt(9));
				book.setImage(rs.getString(10));
				book.setShopid(rs.getInt(11));
				list.add(book);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			DBUtil.getClose(conn, pst, rs);
		}
		return list;
	}

	@Override
	public List<Book> getBookByshopid(int shopid) throws Exception {
		// TODO Auto-generated method stub
		List<Book> list=new ArrayList<Book>();
		conn=DBUtil.getConnection();
		String sql="select * from book where shopid=?";
		pst=conn.prepareStatement(sql);
		pst.setInt(1,shopid);
		rs=pst.executeQuery();
		while(rs.next()){
			Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getDate(8),rs.getInt(9),rs.getString(10),rs.getInt(11));
			list.add(book);
		}
		return list;
	}

	@Override
	public List<Book> getBookShopid(int shopid) throws Exception {
		// TODO Auto-generated method stub
		List<Book> list=new ArrayList<Book>();
		conn=DBUtil.getConnection();
		String sql="select book.*,category.cname from book,category where book.cid=category.cid and shopid=?";
		pst=conn.prepareStatement(sql);
		pst.setInt(1,shopid);
		rs=pst.executeQuery();
		while(rs.next()){
			Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getDate(8),rs.getInt(9),rs.getString(10),rs.getInt(11),rs.getString(12));
			list.add(book);
		}
		return list;
	}

	@Override
	public List<Book> getBookBypage(int start,int end) throws Exception {
		List<Book> books=new ArrayList<Book>();
		String sql="select * from (select b.*,ROWNUM r from (select * from BOOK) b) where r>=? and r<=?";
		conn=DBUtil.getConnection();
		pst=conn.prepareStatement(sql);
		pst.setInt(1,start);
		pst.setInt(2,end);
		rs=pst.executeQuery();
		while(rs.next()){
			Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getDate(8),rs.getInt(9),rs.getString(10),rs.getInt(11),rs.getString(12));
			books.add(book);
		}
		
		return books;
	}

	@Override
	public List<Book> getBookLikeName(String bname,int start,int end) throws Exception {
		
		List<Book> books=new ArrayList<Book>();
		String sql="select * from (select b.*,ROWNUM r from (select * from BOOK where BNAME like ? ) b) where r>=? and r<=?";
		conn=DBUtil.getConnection();
		pst=conn.prepareStatement(sql);
		
		pst.setString(1,"%"+bname+"%");
		pst.setInt(2,start);
		
		
		pst.setInt(3,end);
		
		
		rs=pst.executeQuery();
		while(rs.next()){
			Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getDate(8),rs.getInt(9),rs.getString(10),rs.getInt(11),rs.getString(12));
			books.add(book);
		
		}
		
		return books;
	}

	@Override
	public List<Book> getBookByCid(int cid,int start,int end) throws Exception {
		List<Book> books=new ArrayList<Book>();
		String sql="select * from (select b.*,ROWNUM r from (select * from BOOK where cid=? ) b) where r>=? and r<=?";
		conn=DBUtil.getConnection();
		pst=conn.prepareStatement(sql);
		
		pst.setInt(1, cid);
		pst.setInt(2,start);
		
		
		pst.setInt(3,end);
		
		
		rs=pst.executeQuery();
		while(rs.next()){
			Book book=new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5),rs.getDouble(6),rs.getString(7),rs.getDate(8),rs.getInt(9),rs.getString(10),rs.getInt(11),rs.getString(12));
			books.add(book);
		
		}
		
		return books;
	}
}
