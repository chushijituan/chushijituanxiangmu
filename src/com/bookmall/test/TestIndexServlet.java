package com.bookmall.test;

import java.io.IOException;
import java.sql.Date;
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
import com.bookmall.bean.User;


@WebServlet("/servlet/TestIndexServlet")
public class TestIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		
		Category category11=new Category(1, "≤‚ ‘11", 0, "xxxx");
		Category category12=new Category(1, "≤‚ ‘12", 0, "xxxx");
		Category category13=new Category(1, "≤‚ ‘13", 0, "xxxx");
		Category category14=new Category(1, "≤‚ ‘14", 0, "xxxx");
		Category category15=new Category(1, "≤‚ ‘15", 0, "xxxx");
		
		List<Category> categorys1=new ArrayList<Category>();
		categorys1.add(category11);
		categorys1.add(category12);
		categorys1.add(category13);
		categorys1.add(category14);
		categorys1.add(category15);
		
		session.setAttribute("categorys1", categorys1);
		
		
		
		
		
		
		Category category21=new Category(1, "≤‚ ‘21", 0, "xxxx");
		Category category22=new Category(1, "≤‚ ‘22", 0, "xxxx");
		Category category23=new Category(1, "≤‚ ‘23", 0, "xxxx");
		Category category24=new Category(1, "≤‚ ‘24", 0, "xxxx");
		Category category25=new Category(1, "≤‚ ‘25", 0, "xxxx");
	
		
		
		
		
		List<Category> categorys2=new ArrayList<Category>();
		categorys2.add(category21);
		categorys2.add(category22);
		categorys2.add(category23);
		categorys2.add(category24);
		categorys2.add(category25);
		
		session.setAttribute("categorys2", categorys2);
		
		
		
		
		
		
		
		
		Category category31=new Category(1, "≤‚ ‘31", 0, "xxxx");
		Category category32=new Category(1, "≤‚ ‘32", 0, "xxxx");
		Category category33=new Category(1, "≤‚ ‘33", 0, "xxxx");
		Category category34=new Category(1, "≤‚ ‘34", 0, "xxxx");
		Category category35=new Category(1, "≤‚ ‘35", 0, "xxxx");
		
		List<Category> categorys3=new ArrayList<Category>();
		categorys3.add(category31);
		categorys3.add(category32);
		categorys3.add(category33);
		categorys3.add(category34);
		categorys3.add(category35);
		
		session.setAttribute("categorys3", categorys3);
		
		
		
		Category category41=new Category(1, "≤‚ ‘41", 0, "xxxx");
		Category category42=new Category(1, "≤‚ ‘42", 0, "xxxx");
		Category category43=new Category(1, "≤‚ ‘43", 0, "xxxx");
		Category category44=new Category(1, "≤‚ ‘44", 0, "xxxx");
		Category category45=new Category(1, "≤‚ ‘45", 0, "xxxx");
		
		
		List<Category> categorys4=new ArrayList<Category>();
		categorys4.add(category41);
		categorys4.add(category42);
		categorys4.add(category43);
		categorys4.add(category44);
		categorys4.add(category45);
		
		session.setAttribute("categorys4", categorys4);
		
		
		Category category51=new Category(1, "≤‚ ‘51", 0, "xxxx");
		Category category52=new Category(1, "≤‚ ‘52", 0, "xxxx");
		Category category53=new Category(1, "≤‚ ‘53", 0, "xxxx");
		Category category54=new Category(1, "≤‚ ‘54", 0, "xxxx");
		Category category55=new Category(1, "≤‚ ‘55", 0, "xxxx");
		
		List<Category> categorys5=new ArrayList<Category>();
		categorys5.add(category51);
		categorys5.add(category52);
		categorys5.add(category53);
		categorys5.add(category54);
		categorys5.add(category55);
		
		session.setAttribute("categorys5", categorys5);
		
		
		Category category61=new Category(1, "≤‚ ‘61", 0, "xxxx");
		Category category62=new Category(1, "≤‚ ‘62", 0, "xxxx");
		Category category63=new Category(1, "≤‚ ‘63", 0, "xxxx");
		Category category64=new Category(1, "≤‚ ‘64", 0, "xxxx");
		Category category65=new Category(1, "≤‚ ‘65", 0, "xxxx");
		
		List<Category> categorys6=new ArrayList<Category>();
		categorys6.add(category61);
		categorys6.add(category62);
		categorys6.add(category63);
		categorys6.add(category64);
		categorys6.add(category65);
		
		session.setAttribute("categorys6", categorys6);
		
		
		List<Book> books=new ArrayList<Book>();
		Book book1=new Book();
		book1.setBname("≤‚ ‘ È1");
		book1.setCurrprice(10);
		book1.setAuthor("◊˜’ﬂ1");
		book1.setPress("≥ˆ∞Ê…Á1");
		book1.setPublishtime(Date.valueOf("1999-1-1"));
		
		Book book2=new Book();
		book2.setBname("≤‚ ‘ È2");
		book2.setCurrprice(20);
		book2.setAuthor("◊˜’ﬂ2");
		book2.setPress("≥ˆ∞Ê…Á2");
		book2.setPublishtime(Date.valueOf("1999-1-2"));
		
		Book book3=new Book();
		book3.setBname("≤‚ ‘ È3");
		book3.setCurrprice(30);
		book3.setAuthor("◊˜’ﬂ3");
		book3.setPress("≥ˆ∞Ê…Á3");
		book3.setPublishtime(Date.valueOf("1999-1-3"));
		
		Book book4=new Book();
		book4.setBname("≤‚ ‘ È4");
		book4.setCurrprice(40);
		book4.setAuthor("◊˜’ﬂ4");
		book4.setPress("≥ˆ∞Ê…Á4");
		book4.setPublishtime(Date.valueOf("1999-1-4"));
		
		Book book5=new Book();
		book5.setBname("≤‚ ‘ È5");
		book5.setCurrprice(50);
		book5.setAuthor("◊˜’ﬂ5");
		book5.setPress("≥ˆ∞Ê…Á5");
		book5.setPublishtime(Date.valueOf("1999-1-5"));
		
		Book book6=new Book();
		book6.setBname("≤‚ ‘ È6");
		book6.setCurrprice(60);
		book6.setAuthor("◊˜’ﬂ6");
		book6.setPress("≥ˆ∞Ê…Á6");
		book6.setPublishtime(Date.valueOf("1999-1-6"));
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
		session.setAttribute("books", books);
		
		
		int pageindex=2;
		int page_count=10;
		
		session.setAttribute("pageindex", pageindex);
		session.setAttribute("page_count", page_count);
		
		
		User user=new User();
		user.setLoginname("czh");
		session.setAttribute("user", user);
		
		response.sendRedirect("/BookMall/index.jsp");
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}

}
