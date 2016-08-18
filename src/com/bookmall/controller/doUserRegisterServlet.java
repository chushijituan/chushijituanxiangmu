package com.bookmall.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.bookmall.bean.User;
import com.bookmall.service.UserService;
import com.bookmall.service.impl.UserServiceImpl;

/**
 * Servlet implementation class doUserRegisterServlet
 */
@WebServlet("/servlet/doUserRegisterServlet")
public class doUserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doUserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String loginname=request.getParameter("loginname");
		String loginpass=request.getParameter("loginpass");
		String loginpass1=request.getParameter("loginpass1");
		String email=request.getParameter("email");
		String uphone=request.getParameter("uphone");
		
		User user=new User();
		user.setLoginname(loginname);
		user.setLoginpass(loginpass1);
		user.setEmail(email);
		user.setUphone(uphone);
		if(loginname!=""){
			if(loginpass.equals(loginpass1)){
				try {
					UserService uService=new UserServiceImpl();
					uService.registerUser(user);
					session.setAttribute("user", user);
					request.getRequestDispatcher("../index.jsp").forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				String loginpasserror1="两次密码不一致";
				session.setAttribute("user", user);
				session.setAttribute("loginpass1", loginpass1);
				session.setAttribute("loginpasserror1", loginpasserror1);
				response.sendRedirect("/BookMallProject/jsp/userregister.jsp");
			}
		}else{			
			response.sendRedirect("/BookMallProject/jsp/userregister.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
