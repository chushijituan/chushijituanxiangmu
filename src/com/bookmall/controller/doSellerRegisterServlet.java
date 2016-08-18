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
import com.bookmall.service.impl.SellerServiceImpl;

/**
 * Servlet implementation class doSellerRegisterServlet
 */
@WebServlet("/servlet/doSellerRegisterServlet")
public class doSellerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doSellerRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String sname=request.getParameter("sname");
		String spassword=request.getParameter("spassword");
		String spassword1=request.getParameter("spassword1");
		String semail=request.getParameter("semail");
		String sidentification=request.getParameter("sidentification");
		String sphone=request.getParameter("sphone");
		
		Seller seller=new Seller();
		seller.setSname(sname);
		seller.setSpassword(spassword);
		seller.setSemail(semail);
		seller.setSidentification(sidentification);
		seller.setSphone(sphone);
		if(sname!="")
		{
			if(spassword.equals(spassword1)){
				try {
					SellerService sellerService=new SellerServiceImpl();
					sellerService.registerSeller(seller);
					session.setAttribute("seller", seller);
					request.getRequestDispatcher("../index.jsp").forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				String spasserror1="两次密码不一致";
				session.setAttribute("seller", seller);
				session.setAttribute("spassword", spassword);
				session.setAttribute("spasserror1", spasserror1);
				response.sendRedirect("/BookMallProject/jsp/sellerregister.jsp");
			}
		}else{
			response.sendRedirect("/BookMallProject/jsp/sellerregister.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
