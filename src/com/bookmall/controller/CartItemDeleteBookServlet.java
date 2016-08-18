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
import com.bookmall.bean.CartItem;
import com.bookmall.bean.User;
import com.bookmall.service.CartItemService;
import com.bookmall.service.impl.CartItemServiceImpl;

/**
 * Servlet implementation class CartItemDeleteBookServlet
 */
@WebServlet("/servlet/CartItemDeleteBookServlet")
public class CartItemDeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemDeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//ȥsession�����ֵ
		User user = (User)request.getSession().getAttribute("user");
		
		//ȡ��user�е�cosuid
		int cosuid = user.getCosuid();
		
		CartItemService cartItemService = new CartItemServiceImpl();
		
		String[] bookidString = request.getParameterValues("bookidonlist");
		
		int[] bookid = new int[bookidString.length-1];
		for (int i = 0; i < bookidString.length-1; i++) {
			 bookid[i]= Integer.parseInt( bookidString[i]);
		}
		
		/*
		for (int i = 0; i < bookid.length; i++) {
			System.out.println(i);
		}
		*/
		
		
		for (int i = 0; i < bookid.length; i++) {
			try {
				cartItemService.deleteCartItemBycartItemId(bookid[i],cosuid);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		
		List<Book> bookList = new ArrayList<Book>();
		
		
		try {
			
			bookList = cartItemService.selectBookByCosuid(cosuid);
			
		} catch (Exception e) {
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
