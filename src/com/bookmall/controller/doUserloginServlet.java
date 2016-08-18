package com.bookmall.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmall.bean.Admin;
import com.bookmall.bean.User;
import com.bookmall.service.UserService;
import com.bookmall.service.impl.UserServiceImpl;

/**
 * Servlet implementation class doUserloginServlet
 */
@WebServlet("/servlet/doUserloginServlet")
public class doUserloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doUserloginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginname=request.getParameter("loginname");
		String loginpass=request.getParameter("loginpass");
		UserService userService=new UserServiceImpl();
		HttpSession session=request.getSession();
		try {
			boolean flag=userService.login(loginname, loginpass);
			if(flag){
				session.setAttribute("loginname", loginname);
				User user=userService.findUser(loginname);
				
				session.setAttribute("user", user);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}else{
				String loginnameerror="用户名或密码错误";
				session.setAttribute("loginnameerror", loginnameerror);
				response.sendRedirect(request.getContextPath()+"/jsp/userlogin.jsp");
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
