package com.bookmall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Book;
import com.bookmall.bean.Category;
import com.bookmall.bean.Shop;
import com.bookmall.service.BookService;
import com.bookmall.service.CategoryService;
import com.bookmall.service.impl.BookServiceImpl;
import com.bookmall.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class updateSevlet
 */
@WebServlet("/servlet/updatebookServlet")
public class updatebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatebookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("charset=UTF-8");
		Shop shop=(Shop) request.getSession().getAttribute("shop");
		System.out.println(123);
		String bid=request.getParameter("bid");
		System.out.println(bid);
		String bname=request.getParameter("bname");
		System.out.println(456);
		String author=request.getParameter("author");
		String price=request.getParameter("price");
		String discount=request.getParameter("discount");
		String currprice=request.getParameter("currprice");
		String press=request.getParameter("press");
		String publishtime=request.getParameter("publishtime");
		String[] cname=request.getParameterValues("cname");
		String ccname=cname[0];
//		ccname=new String(ccname.getBytes(),"UTF-8");
		String image="book_img/"+request.getSession().getAttribute("filename");
		System.out.println(image);
		CategoryService cs=new CategoryServiceImpl();
		BookService bs=new BookServiceImpl();
		Category category=null;
		try {
			category = cs.getCidByname(ccname);
			Book book=new Book(Integer.parseInt(bid),bname,author,Double.parseDouble(price),Double.parseDouble(currprice),Double.parseDouble(discount),press,java.sql.Date.valueOf(publishtime),category.getCid(),image,shop.getShopid());
			bs.updateBook(book);
			response.sendRedirect("../servlet/toshopindexServlet");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
