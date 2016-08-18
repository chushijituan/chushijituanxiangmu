package com.bookmall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Book;
import com.bookmall.bean.Category;
import com.bookmall.service.BookService;
import com.bookmall.service.CategoryService;
import com.bookmall.service.impl.BookServiceImpl;
import com.bookmall.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class updateSevlet
 */
@WebServlet("/servlet/updateSevlet")
public class updatebookSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatebookSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bid=request.getParameter("bid");
		String bname=request.getParameter("bname").trim();
		String author=request.getParameter("author").trim();
		String price=request.getParameter("price").trim();
		String discount=request.getParameter("discount").trim();
		String currprice=request.getParameter("currprice").trim();
		String press=request.getParameter("press");
		String publishtime=request.getParameter("publishtime");
		String cname=request.getParameter("cname");
		String image=request.getParameter("image");
	
		CategoryService cs=new CategoryServiceImpl();
		BookService bs=new BookServiceImpl();
		Category category=null;
		try {
			category = cs.getCidByname(cname);
			Book book=new Book(Integer.parseInt(bid),bname,author,Double.parseDouble(price),Double.parseDouble(currprice),Double.parseDouble(discount),press,java.sql.Date.valueOf(publishtime),category.getCid(),image);
			bs.updateBook(book);
			response.sendRedirect("../jsp/shopindex");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
