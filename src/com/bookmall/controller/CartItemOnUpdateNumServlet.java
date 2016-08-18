package com.bookmall.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.User;
import com.bookmall.service.CartItemService;
import com.bookmall.service.impl.CartItemServiceImpl;

/**
 * Servlet implementation class CartItemOnUpdateNumServlet
 */
@WebServlet("/servlet/CartItemOnUpdateNumServlet")
public class CartItemOnUpdateNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemOnUpdateNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		
		User user = (User)request.getSession().getAttribute("user");
		
		
		String[] bidString = request.getParameterValues("bookidonlist");
		String[] quantityStr = request.getParameterValues("booknumList");
		
		
		
		int[] bookid = new int[bidString.length];
		for (int i = 0; i < bidString.length; i++) {
			 bookid[i]= Integer.parseInt( bidString[i]);
		}
		
		int[] booknum = new int[quantityStr.length];
		for (int i = 0; i < quantityStr.length; i++) {
			booknum[i]= Integer.parseInt( quantityStr[i]);
		}
		
		request.getSession().setAttribute("checkedid",bookid );
		
		CartItemService cartItemService = new CartItemServiceImpl();
		
		for (int i = 0; i < booknum.length; i++) {
			for (int j = 0; j < bookid.length; j++) {
				try {
					
					if(cartItemService.selectCartItemQuantity(bookid[j], user.getCosuid())!=0){
						
						int quantity = cartItemService.selectCartItemQuantity(bookid[j], user.getCosuid());
						
						if(booknum[i]!=quantity){
							quantity=booknum[i];
							cartItemService.updateCartItemByBidAndcosuid(quantity, bookid[j], user.getCosuid());
						}else{
							cartItemService.updateCartItemByBidAndcosuid(quantity, bookid[j], user.getCosuid());
						}
						
					}else{
						
						
						cartItemService.updateCartItemBycartItemId(booknum[i], bookid[j]);
					}
					
					response.sendRedirect("../servlet/OrderServlet?method=createOrder");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
