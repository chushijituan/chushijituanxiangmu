package com.bookmall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Category;
import com.bookmall.service.CategoryService;
import com.bookmall.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class toaddbookServlet
 */
@WebServlet("/servlet/toaddbookServlet")
public class toaddbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toaddbookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("charset=UTF-8");
		List<Category> listpcate=new ArrayList<Category>();
		List<Category> listccate=new ArrayList<Category>();
		CategoryService cs=new CategoryServiceImpl();
		try {
			List<String> pnamelist=cs.getCatePname();
			List<String> cnamelist=cs.getCateCname();
			for(String pname:pnamelist){
				Category pcategory=cs.getCidByname(pname);
				System.out.println(pcategory);
				listpcate.add(pcategory);
			}
			for(String cname:cnamelist){
				Category ccategory=cs.getCidByname(cname);
				System.out.println(ccategory);
				listccate.add(ccategory);
			}
			request.setAttribute("listpcate",listpcate);
			request.setAttribute("listccate", listccate);
			request.getRequestDispatcher("../jsp/addbook.jsp").forward(request, response);
		} catch (Exception e) {
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
