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

import com.bookmall.bean.User;
import com.bookmall.service.AdminService;
import com.bookmall.service.SellerService;
import com.bookmall.service.UserService;
import com.bookmall.service.impl.AdminServiceImpl;
import com.bookmall.service.impl.SellerServiceImpl;
import com.bookmall.service.impl.UserServiceImpl;

/**
 * Servlet implementation class doUserChangeServlet
 */
@WebServlet("/servlet/doUserChangeServlet")
public class doUserChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doUserChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int cosuid=Integer.parseInt(request.getParameter("cosuid"));
		String loginname=request.getParameter("loginname");
		String loginpass=request.getParameter("loginpass");
		String email=request.getParameter("email");
		String uphone=request.getParameter("uphone");
		//System.out.println(loginname);
		//System.out.println(email);
		//System.out.println(uphone);
		
		UserService userService=new UserServiceImpl();
		AdminService adminService=new AdminServiceImpl();
		User user;
		try {
			user = userService.findUser(loginname);
			user.setCosuid(cosuid);
			user.setLoginname(loginname);
			user.setEmail(email);
			user.setUphone(uphone);
			user.setLoginpass(loginpass);
		//	System.out.println(user);
			
			adminService.updateUser(user);
			
		//	System.out.println(user);
			
			try {
				List<User> userList=new ArrayList<>();
				userList=adminService.getAllUser();
				//System.out.println(111);
				/*for (int i = 0; i < userList.size(); i++) {
					System.out.println(userList.get(i));
				}*/
				request.getSession().setAttribute("userList", userList);
				response.sendRedirect("/BookMallProject/jsp/comusermanager.jsp");
				
			} catch (Exception e) {
				e.printStackTrace();
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
		doGet(request, response);
	}

}
