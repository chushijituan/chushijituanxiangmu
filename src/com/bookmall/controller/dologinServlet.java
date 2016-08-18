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
import org.apache.jasper.tagplugins.jstl.core.Out;

import com.bookmall.bean.Admin;
import com.bookmall.bean.User;
import com.bookmall.dao.AdminDao;
import com.bookmall.dao.impl.AdminDaoImpl;
import com.bookmall.dao.impl.UserDaoImpl;
import com.bookmall.service.AdminService;
import com.bookmall.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class dologin
 */
@WebServlet("/servlet/dologinServlet")
public class dologinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dologinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminname=request.getParameter("adminname");
		String adminpwd =request .getParameter("adminpwd");
		AdminService aService=new AdminServiceImpl();
		HttpSession session=request.getSession();
		try {
			boolean flag=aService.loginAdmin(adminname, adminpwd);
			if(flag){
				session.setAttribute("adminname",adminname);
				request.getRequestDispatcher("/jsp/adminindex.jsp").forward(request,response);
			}
			else {
				String adminnameerror="用户名或密码错误";
				session.setAttribute("adminnameerror", adminnameerror);
				response.sendRedirect("/BookMallProject/jsp/adminlogin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
