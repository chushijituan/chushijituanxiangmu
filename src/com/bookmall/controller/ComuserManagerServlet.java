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

import com.bookmall.bean.Admin;
import com.bookmall.bean.User;
import com.bookmall.service.AdminService;
import com.bookmall.service.UserService;
import com.bookmall.service.impl.AdminServiceImpl;
import com.bookmall.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ComuserManagerServlet
 */
@WebServlet("/servlet/ComuserManagerServlet")
public class ComuserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComuserManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService adminService=new AdminServiceImpl();
		try {
			List<User> userList=new ArrayList<>();
			userList=adminService.getAllUser();
			for (int i = 0; i < userList.size(); i++) {
				System.out.println(userList.get(i));
			}
			request.getSession().setAttribute("userList", userList);
			response.sendRedirect("/BookMallProject/jsp/comusermanager.jsp");
			
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
