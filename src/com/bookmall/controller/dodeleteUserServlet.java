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

import com.bookmall.bean.User;
import com.bookmall.service.AdminService;
import com.bookmall.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class dodeleteUserServlet
 */
@WebServlet("/servlet/dodeleteUserServlet")
public class dodeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dodeleteUserServlet() {
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
		int cosuid=Integer.parseInt(request.getParameter("cosuid"));
		//System.out.println(cosuid);
		AdminService adminService=new AdminServiceImpl();
		boolean flag;
		try {
			boolean flag1=adminService.deleteCARTITEM1(cosuid);
			boolean flag2=adminService.deleteUSERORDER1(cosuid);
			flag = adminService.deleteUser(cosuid);
			//System.out.println(flag1);
			//System.out.println(flag2);
			//System.out.println(flag);
			if(flag){
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
			}else{
				
				response.sendRedirect("/BookMallProject/jsp/comusermanager.jsp");
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
