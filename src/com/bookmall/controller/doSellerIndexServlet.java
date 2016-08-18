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
import com.bookmall.bean.User;
import com.bookmall.service.SellerService;
import com.bookmall.service.impl.SellerServiceImpl;

/**
 * Servlet implementation class doSellerIndexServlet
 */
@WebServlet("/servlet/doSellerIndexServlet")
public class doSellerIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doSellerIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String sname=(String) session.getAttribute("sname");
		SellerService sellerService=new SellerServiceImpl();
		try {
			Seller seller=sellerService.findSeller(sname);
		//	response.getWriter().print(seller);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
