package com.bookmall.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Book;
import com.bookmall.bean.User;
import com.bookmall.service.CartItemService;
import com.bookmall.service.impl.CartItemServiceImpl;

/**
 * Servlet implementation class CartItemDelOneBookServlet
 */
@WebServlet("/servlet/CartItemDelOneBookServlet")
public class CartItemDelOneBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemDelOneBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String bookidStr = request.getParameter("bid");
		
		int bookid = Integer.parseInt(bookidStr);
		
		//ȥsession�����ֵ
		User user = (User)request.getSession().getAttribute("user");
				
	
		int cosuid = user.getCosuid();
		
	
		List<Book> bookList = new ArrayList<Book>();
				
		CartItemService cartItemService = new CartItemServiceImpl();
		
		try {
			
			cartItemService.deleteCartItemBycartItemId(bookid,cosuid);
			
		
			bookList = cartItemService.selectBookByCosuid(cosuid);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("bookList", bookList);
		
		request.getRequestDispatcher("../servlet/CartServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
