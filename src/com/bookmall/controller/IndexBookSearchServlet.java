package com.bookmall.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookmall.bean.Book;
import com.bookmall.bean.Pages;
import com.bookmall.service.BookService;
import com.bookmall.service.impl.BookServiceImpl;
import com.bookmall.utils.PageUtil;

/**
 * Servlet implementation class IndexBookSearchServlet
 */
@WebServlet("/servlet/IndexBookSearchServlet")
public class IndexBookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String method="";
		
		String getsearchstyle="";
		if(request.getParameter("method")!=null){
			method=request.getParameter("method");
		}
		
		if(request.getParameter("searchstyle")!=null){
			getsearchstyle=request.getParameter("searchstyle");
		}
		
		
		BookService bs=new BookServiceImpl();
		Pages page=null;
		List<Book> books=null;
		
		int pagecount=0;
		int pagesize=6;
		int start=0;
		int end=0;
		int pageindex=1;
		
		String searchstyle="";
		
		
		
		if("searchbyname".equals(method)||getsearchstyle.equals("byname")){
			
			String bookname="";
			
			if(request.getParameter("pageindex")!=null&&!request.getParameter("pageindex").equals("")){
				pageindex=Integer.parseInt(request.getParameter("pageindex"));
			}
			
			if(request.getParameter("bookname")!=null){
				bookname=request.getParameter("bookname");
			}else{
				bookname=(String) session.getAttribute("booknameforsearch");
			}
			
	
			
			String sql="select count(*) from BOOK where BNAME like '%"+bookname+"%'";
			
			
			try {
				page=PageUtil.getPage(pageindex, pagesize, sql);
				pagecount=page.getPageCount();
				start=page.getStart();
				end=page.getEnd();
				
				books=bs.getBookLikeName(bookname, start, end);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			searchstyle="byname";
			session.setAttribute("searchstyle", searchstyle);
			
			session.setAttribute("books", books);
			session.setAttribute("pageindex", pageindex);
			session.setAttribute("pagecount", pagecount);
			
			String booknameforsearch=bookname;
			session.setAttribute("booknameforsearch", booknameforsearch);
			
			
			
			
			
		}else if("searchbycategory".equals(method)||getsearchstyle.equals("bycategory")){
			
			int cid=0;
			
			if(request.getParameter("pageindex")!=null&&!request.getParameter("pageindex").equals("")){
				pageindex=Integer.parseInt(request.getParameter("pageindex"));
			}
			
			if(request.getParameter("cid")!=null){
				cid=Integer.parseInt(request.getParameter("cid"));
			}else{
				cid=(int) session.getAttribute("cidforsearch");
			}
				
			
				String sql="select count(*) from BOOK where cid="+cid;
				
				try {
					page=PageUtil.getPage(pageindex, pagesize, sql);
					pagecount=page.getPageCount();
					start=page.getStart();
					end=page.getEnd();
					
					books=bs.getBookByCid(cid, start, end);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				session.setAttribute("books", books);
				session.setAttribute("pageindex", pageindex);
				session.setAttribute("pagecount", pagecount);
				
				searchstyle="bycategory";
				session.setAttribute("searchstyle", searchstyle);
				
				
				int cidforsearch=cid;
				session.setAttribute("cidforsearch", cidforsearch);
				
			
			
			
			
			
		}else if("searchbyindex".equals(method)||getsearchstyle.equals("all")){
			
			
			String sql="select count(*) from BOOK";
		
				
		
			
			if(request.getParameter("pageindex")!=null&&!request.getParameter("pageindex").equals("")){
				pageindex=Integer.parseInt(request.getParameter("pageindex"));
			}
			
			
			
			
			try {
				page=PageUtil.getPage(pageindex, pagesize, sql);
				pagecount=page.getPageCount();
				start=page.getStart();
				end=page.getEnd();
				books=bs.getBookBypage(start, end);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.setAttribute("books", books);
			session.setAttribute("pageindex", pageindex);
			session.setAttribute("pagecount", pagecount);
			
			
			
		}
		
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
