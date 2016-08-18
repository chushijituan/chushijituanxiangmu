package com.bookmall.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Book;
import com.bookmall.bean.Seller;
import com.bookmall.bean.Shop;
import com.bookmall.service.BookService;
import com.bookmall.service.ShopService;
import com.bookmall.service.impl.BookServiceImpl;
import com.bookmall.service.impl.ShopServiceImpl;

/**
 * Servlet implementation class toshopindexServlet
 */
@WebServlet("/servlet/toshopindexServlet")
public class toshopindexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toshopindexServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		ShopService ss=new ShopServiceImpl();
		BookService bs=new BookServiceImpl();
		Seller seller=(Seller)request.getSession().getAttribute("seller");
		try {
			Shop shop = ss.getShopBysid(seller.getSid());
			if(shop==null){
				PrintWriter out=response.getWriter();
				out.print("<script>alert('你还没有注册');location.href='../jsp/sellerindex.jsp';</script>");
			//	request.getRequestDispatcher("../jsp/sellerindex.jsp").forward(request, response);
			}
			else{
					List<Book> booklist=bs.getBookShopid(shop.getShopid());
					request.getSession().setAttribute("booklist", booklist);
					request.getSession().setAttribute("shop",shop);
					request.getSession().setAttribute("seller", seller);
					response.sendRedirect("../jsp/shopindex.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
