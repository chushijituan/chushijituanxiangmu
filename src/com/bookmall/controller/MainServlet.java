package com.bookmall.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmall.bean.Book;
import com.bookmall.bean.Category;
import com.bookmall.bean.Pages;
import com.bookmall.service.BookService;
import com.bookmall.service.CategoryService;
import com.bookmall.service.impl.BookServiceImpl;
import com.bookmall.service.impl.CategoryServiceImpl;
import com.bookmall.utils.PageUtil;


@WebServlet("/servlet/MainServlet")
public class MainServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		
		CategoryService cs=new CategoryServiceImpl();
		BookService bs=new BookServiceImpl();
		
		List<Category> categorys1=null;
		List<Category> categorys2=null;
		List<Category> categorys3=null;
		List<Category> categorys4=null;
		List<Category> categorys5=null;
		List<Category> categorys6=null;
		List<Book> books=null;
		
		Pages page=null;
		
		String searchstyle="all";
		
		int pageindex=1;
		int pagecount=0;
		int pagesize=6;
		int start=0;
		int end=0;
		String sql="select count(*) from BOOK";
		
		
		
		
		try {
			
			page=PageUtil.getPage(pageindex, pagesize, sql);
			pagecount=page.getPageCount();
			start=page.getStart();
			end=page.getEnd();
			
			
			
			categorys1 = cs.getCidBypid(1);
			categorys2 = cs.getCidBypid(2);
			categorys3 = cs.getCidBypid(3);
			categorys4 = cs.getCidBypid(4);
			categorys5 = cs.getCidBypid(5);
			categorys6 = cs.getCidBypid(6);
			
			books=bs.getBookBypage(start, end);
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
		
		
		
		session.setAttribute("categorys1", categorys1);
		session.setAttribute("categorys2", categorys2);
		session.setAttribute("categorys3", categorys3);
		session.setAttribute("categorys4", categorys4);
		session.setAttribute("categorys5", categorys5);
		session.setAttribute("categorys6", categorys6);
		
		session.setAttribute("books", books);
		
		
		
		session.setAttribute("pageindex", pageindex);
		session.setAttribute("pagecount", pagecount);
		
		session.setAttribute("searchstyle", searchstyle);
		
		
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

}
