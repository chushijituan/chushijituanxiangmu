package com.bookmall.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmall.bean.User;
import com.bookmall.service.UserService;
import com.bookmall.service.impl.UserServiceImpl;

/**
 * Servlet implementation class showComuserInfoServlet
 */
@WebServlet("/servlet/showComuserInfoServlet")
public class showComuserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showComuserInfoServlet() {
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
		String loginname=request.getParameter("loginname");
		String loginpass=request.getParameter("loginpass");
		String email=request.getParameter("email");
		String uphone=request.getParameter("uphone");
		//System.out.println("name"+loginname);
		User user=(User) session.getAttribute("user");
		//System.out.println("usererer"+user);
		user.setLoginname(loginname);
		user.setLoginpass(loginpass);
		user.setEmail(email);
		user.setUphone(uphone);
		//System.out.println("12345"+user);
		UserService uService=new UserServiceImpl();
		try {
			uService.updateUser(user);
			session.setAttribute("user", user);
			//System.out.println("1234"+user);
			request.getRequestDispatcher("/jsp/comuserinfo.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
