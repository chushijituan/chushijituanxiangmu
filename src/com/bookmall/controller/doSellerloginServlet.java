package com.bookmall.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmall.bean.Seller;
import com.bookmall.service.SellerService;
import com.bookmall.service.UserService;
import com.bookmall.service.impl.SellerServiceImpl;
import com.bookmall.service.impl.UserServiceImpl;

/**
 * Servlet implementation class doSellerloginServlet
 */
@WebServlet("/servlet/doSellerloginServlet")
public class doSellerloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doSellerloginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname=request.getParameter("sname");
		String spassword=request.getParameter("spassword");
		SellerService sellerService=new SellerServiceImpl();
		HttpSession session=request.getSession();
		try {
			boolean flag=sellerService.loginSeller(sname, spassword);
			Seller seller=sellerService.findSeller(sname);
			//System.out.println("seller222"+seller);
			if(flag){
				session.setAttribute("seller", seller);
				session.setAttribute("sname", sname);
				request.getRequestDispatcher("/servlet/doSellerIndexServlet").forward(request, response);
			}else{
				String snameerror="用户名或密码错误";
				session.setAttribute("snameerror", snameerror);
				response.sendRedirect(request.getContextPath()+"/jsp/sellerlogin.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
