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

import com.bookmall.bean.CartItem;
import com.bookmall.bean.User;
import com.bookmall.service.CartItemService;
import com.bookmall.service.impl.CartItemServiceImpl;

/**
 * Servlet implementation class CartItemUpdateBookServlet
 */
@WebServlet("/servlet/CartItemUpdateBookServlet")
public class CartItemUpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemUpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
        
        List<CartItem> list=new ArrayList<CartItem>();
        List list2=new  ArrayList<>();
        for (CartItem cartItem : list) {
			cartItem.getBid();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
	
		String bookidString = request.getParameter("bookid");
		String bookQuantityStr = request.getParameter("booknum");
		User user = (User)request.getSession().getAttribute("user");
		
		if(user==null){
			response.sendRedirect(request.getContextPath()+"/jsp/userlogin.jsp");
		}else{
	
		int bookid = Integer.parseInt(bookidString);
		int bookQuantity = Integer.parseInt(bookQuantityStr);
		
		//��������ֵ
		CartItem cartItem = new CartItem();
		cartItem.setBid(bookid);
		cartItem.setQuantity(bookQuantity);
		System.out.println(cartItem);
				
		
		request.getSession().setAttribute("CartItem",cartItem);
				
		CartItemService cartItemService = new CartItemServiceImpl();
		
		try {
			
			if(cartItemService.selectCartItemQuantity(bookid, user.getCosuid())!=0){
				int quantity = cartItemService.selectCartItemQuantity(bookid, user.getCosuid());
				
				quantity = quantity + bookQuantity;
				cartItemService.updateCartItemByBidAndcosuid(quantity, bookid, user.getCosuid());
			}else{
				
				
				cartItemService.updateCartItemBycartItemId(bookQuantity, bookid);
			}
			
			request.getRequestDispatcher("../servlet/CartServlet").forward(request, response);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
