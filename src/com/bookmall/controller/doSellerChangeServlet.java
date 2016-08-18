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
import com.bookmall.service.AdminService;
import com.bookmall.service.SellerService;
import com.bookmall.service.impl.AdminServiceImpl;
import com.bookmall.service.impl.SellerServiceImpl;
/**
 * Servlet implementation class doServletChangeServlet
 */
@WebServlet("/servlet/doSellerChangeServlet")
public class doSellerChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doSellerChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int sid=Integer.parseInt(request.getParameter("sid"));
		String sname=request.getParameter("sname");
		String spassword=request.getParameter("spassword");
		String semail=request.getParameter("semail");
		String sidentification=request.getParameter("sidentification"); 
		String sphone=request.getParameter("sphone");
		System.out.println(sname);
		System.out.println(spassword);
		System.out.println(sphone);
		System.out.println(semail);
		System.out.println(sidentification);
		
		SellerService sellerService=new SellerServiceImpl();
		AdminService adminService=new AdminServiceImpl();
		Seller seller;
		try {
			seller=sellerService.findSeller(sname);
			seller.setSid(sid);
			seller.setSname(sname);
			seller.setSemail(semail);
			seller.setSpassword(spassword);
			seller.setSidentification(sidentification);
			seller.setSphone(sphone);
	     	System.out.println(seller);
			
			adminService.updateSeller(seller);
			
			System.out.println(seller);
			
			try {
				List<Seller> sellerList=new ArrayList<>();
				sellerList=adminService.getAllSellers();
				/*for (int i = 0; i < sellerList.size(); i++) {
					System.out.println(sellerList.get(i));
				}*/
				request.getSession().setAttribute("sellerList", sellerList);
				response.sendRedirect("/BookMallProject/jsp/sellermanager.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
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
