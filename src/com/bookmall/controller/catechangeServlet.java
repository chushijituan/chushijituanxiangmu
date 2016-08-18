package com.bookmall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bookmall.bean.Category;
import com.bookmall.service.CategoryService;
import com.bookmall.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class catechangeServlet
 */
@WebServlet("/servlet/catechangeServlet")
public class catechangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public catechangeServlet() {
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
		String pname=request.getParameter("pname");
		CategoryService cs=new CategoryServiceImpl();
		JSONArray array=null;
		try {
			List<Category> listcate=cs.getCidBypid(cs.getCidByname(pname).getCid());
			array = new JSONArray();
			JSONObject cate = null;
			for(Category c:listcate){
				cate=new JSONObject();
				cate.put("id", c.getCname());
				cate.put("name",c.getCname());
				array.add(cate);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().print(array.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
