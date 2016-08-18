package com.bookmall.controller;

import java.io.IOException;
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
 * Servlet implementation class CartItemInsertBookServlet
 */
@WebServlet("/servlet/CartItemInsertBookServlet")
public class CartItemInsertBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartItemInsertBookServlet() {
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
				
		//��ȡҳ��ͼ�����Ϣ
		String bookidstr = request.getParameter("bookid");
		String bookQuantityStr = request.getParameter("booknum");
				
		//ȥsession�����ֵ
		User user = (User)request.getSession().getAttribute("user");
						
		//ȡ��user�е�cosuid
		int cosuid = user.getCosuid();
		int bookid = Integer.parseInt(bookidstr);
		int quantity = Integer.parseInt(bookQuantityStr);
		//System.out.println(cosuid);
		/*		
		//���ﳵ����
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(quantity);
		cartItem.setBid(bookid);
		cartItem.setCosuid(cosuid);
		*/
		//System.out.println(cartItem);
				
		CartItemService cartItemService = new CartItemServiceImpl();
			int quantityAll = -1;
		try {
			
			//���μ��빺�ﳵ����ͬ��������������
			if(cartItemService.selectCartItemQuantity(bookid, user.getCosuid())!=0){
				int quantitys = cartItemService.selectCartItemQuantity(bookid, user.getCosuid());
				
				quantityAll = quantitys + Integer.parseInt(bookQuantityStr);
				cartItemService.updateCartItemByBidAndcosuid(quantityAll, bookid, user.getCosuid());
			}else{
				
				
				//���ﳵ����
				CartItem cartItem = new CartItem();
				cartItem.setQuantity(Integer.parseInt(bookQuantityStr));
				cartItem.setBid(bookid);
				cartItem.setCosuid(cosuid);
				//��ӹ��ﳵ
				cartItemService.insertCartItemBycartItemId(cartItem);
				//������ID�޸��������
				//cartItemService.updateCartItemBycartItemId(Integer.parseInt(bookQuantityStr), bookid);
			}
					
			
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
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
