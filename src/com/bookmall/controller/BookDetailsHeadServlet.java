package com.bookmall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmall.bean.Book;
import com.bookmall.service.BookService;
import com.bookmall.service.impl.BookServiceImpl;


@WebServlet("/servlet/BookDetailsHeadServlet")
public class BookDetailsHeadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int bid=Integer.parseInt(request.getParameter("bid"));
		BookService bs=new BookServiceImpl();
		HttpSession session=request.getSession();
		try {
			Book detailsbook=bs.getBookById(bid);
			session.setAttribute("detailsbook", detailsbook);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/jsp/bookdetails.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
