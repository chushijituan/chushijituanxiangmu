package com.bookmall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Seller;
import com.bookmall.bean.User;
import com.bookmall.service.AdminService;
import com.bookmall.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class SellerManagerServlet
 */
@WebServlet("/servlet/SellerManagerServlet")
public class SellerManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService adminService=new AdminServiceImpl();
		try {
			List<Seller> sellerList=new ArrayList<>();
			sellerList=adminService.getAllSellers();
			for (int i = 0; i < sellerList.size(); i++) {
				System.out.println(sellerList.get(i));
			}
			request.getSession().setAttribute("sellerList", sellerList);
			response.sendRedirect("/BookMallProject/jsp/sellermanager.jsp");
			
		} catch (Exception e) {
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
