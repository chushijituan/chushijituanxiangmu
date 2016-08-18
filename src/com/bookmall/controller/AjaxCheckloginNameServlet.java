package com.bookmall.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.User;
import com.bookmall.service.UserService;
import com.bookmall.service.impl.UserServiceImpl;

/**
 * Servlet implementation class AjaxCheckloginNameServlet
 */
@WebServlet("/servlet/AjaxCheckloginNameServlet")
public class AjaxCheckloginNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxCheckloginNameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String loginname=request.getParameter("loginname");
		//System.out.println(loginname);
		UserService userService=new UserServiceImpl();
		User user=new User();
		
		try {
			user=userService.findUser(loginname);
			//System.out.println(user);
			if(user.getLoginname() != null&& user.getLoginname()!=""){
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
