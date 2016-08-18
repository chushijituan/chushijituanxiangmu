package com.bookmall.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Seller;
import com.bookmall.bean.User;
import com.bookmall.service.SellerService;
import com.bookmall.service.UserService;
import com.bookmall.service.impl.SellerServiceImpl;
import com.bookmall.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AjaxChecksNameServlet
 */
@WebServlet("/servlet/AjaxChecksNameServlet")
public class AjaxChecksNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxChecksNameServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sname=request.getParameter("sname");
		//System.out.println(loginname);
		SellerService sellerService=new SellerServiceImpl();
		Seller seller=new Seller();
		
		try {
			seller=sellerService.findSeller(sname);
			//System.out.println(user);
			if(seller.getSname() != null&& seller.getSname()!=""){
				response.getWriter().print("true");
			}else {
				response.getWriter().print("false");
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
