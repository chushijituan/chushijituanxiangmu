package com.bookmall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Book;
import com.bookmall.bean.Category;
import com.bookmall.service.BookService;
import com.bookmall.service.CategoryService;
import com.bookmall.service.impl.BookServiceImpl;
import com.bookmall.service.impl.CategoryServiceImpl;

/**
 * Servlet implementation class toupdatebook
 */
@WebServlet("/servlet/toupdatebookServlet")
public class toupdatebookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toupdatebookServlet() {
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
		String bid=request.getParameter("bid");
		BookService bs=new BookServiceImpl();
		CategoryService cs=new CategoryServiceImpl();
		List<Category> listpcate=new ArrayList<Category>();
		List<Category> listccate=new ArrayList<Category>();
		try {
			List<String> cnamelist=cs.getCateCname();
			List<String> pnamelist=cs.getCatePname();
			Book book=bs.getBookById(Integer.parseInt(bid));
			Category ccategory=cs.getCateBycid(book.getCid());
			Category pcategory=cs.getCateBycid(ccategory.getPid());
			request.setAttribute("book", book);
			for(String pname:pnamelist){
				Category pcate=cs.getCidByname(pname);
				
				listpcate.add(pcate);
			}
			for(String cname:cnamelist){
				Category ccate=cs.getCidByname(cname);
				
				listccate.add(ccate);
			}
			
			request.setAttribute("ccategory", ccategory);
			request.setAttribute("pcategory", pcategory);
			request.setAttribute("listpcate",listpcate);
			request.setAttribute("listccate", listccate);
			request.getRequestDispatcher("../jsp/updatebook.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
