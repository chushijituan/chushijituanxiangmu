package com.bookmall.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Book;
import com.bookmall.bean.CartItemAnBook;
import com.bookmall.bean.User;
import com.bookmall.service.CartItemService;
import com.bookmall.service.impl.CartItemServiceImpl;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/servlet/CartServlet")
public class CartItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		
		CartItemService cartitemService = new CartItemServiceImpl();
		
	
		User user = (User)request.getSession().getAttribute("user");
		
	
		List<CartItemAnBook> cartItemAnBookList = new ArrayList<CartItemAnBook>();
		
		if(user!=null){
			try {

			
				cartItemAnBookList = cartitemService.selectCartItemAnBookByCosuid(user.getCosuid());
				
				for (CartItemAnBook cartItemAnBook : cartItemAnBookList) {
					System.out.println(cartItemAnBook.getBid()+"xx");
				}
				request.getSession().setAttribute("cartItemAnBookList", cartItemAnBookList);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		request.getRequestDispatcher("../jsp/cartItem.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
