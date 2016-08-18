package com.bookmall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.bookmall.bean.Seller;
import com.bookmall.bean.Shop;
import com.bookmall.service.ShopService;
import com.bookmall.service.impl.ShopServiceImpl;

/**
 * Servlet implementation class addshopServlet
 */
@WebServlet("/servlet/addshopServlet")
public class addshopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	java.sql.Date sysdate;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addshopServlet() {
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
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		ShopService ss=new ShopServiceImpl();
		Seller seller=(Seller) request.getSession().getAttribute("seller");
		try {
				if(ss.getShopBysid(seller.getSid())!=null){
				response.getWriter().print("<script>alert('您已注册店铺');location.href='../jsp/sellerindex.jsp';</script>");
				}
				else{
					String shopname=request.getParameter("shopname");
					String shopdesc=request.getParameter("shopdesc");
					Shop shop=new Shop(shopname,seller.getSid(),shopdesc);
					ss.addShop(shop);
					response.sendRedirect("../jsp/sellerindex.jsp");
				}
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	}
}