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
 * Servlet implementation class doUpdateSellerServlet
 */
@WebServlet("/servlet/doUpdateSellerServlet")
public class doUpdateSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doUpdateSellerServlet() {
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
		HttpSession session=request.getSession();
		String spassword=request.getParameter("spassword");
		String semail=request.getParameter("semail");
		String sphone=request.getParameter("sphone");
		Seller seller=(Seller) session.getAttribute("seller");
		seller.setSpassword(spassword);
		seller.setSemail(semail);
		seller.setSphone(sphone);
		SellerService sellerService=new SellerServiceImpl();
		if(spassword==null){
			request.getRequestDispatcher("/jsp/sellerindex.jsp").forward(request, response);
		}else{
			try {
				sellerService.updateSeller(seller);	
				session.setAttribute("seller", seller);
				request.getRequestDispatcher("/jsp/sellerindex.jsp").forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
