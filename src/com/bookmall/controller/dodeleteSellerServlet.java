package com.bookmall.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmall.bean.Seller;
import com.bookmall.bean.User;
import com.bookmall.service.AdminService;
import com.bookmall.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class dodeleteSellerServlet
 */
@WebServlet("/servlet/dodeleteSellerServlet")
public class dodeleteSellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dodeleteSellerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int sid=Integer.parseInt(request.getParameter("sid"));
		System.out.println(sid);
		AdminService adminService=new AdminServiceImpl();
		boolean flag;
		try {
			boolean flag1=adminService.deleteShop1(sid);
			flag = adminService.deleteSeller(sid);
			System.out.println(flag1);
			System.out.println(flag);
			if(flag){
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
			}else{
				
			}
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
		// TODO Auto-generated method stub
	}

}
