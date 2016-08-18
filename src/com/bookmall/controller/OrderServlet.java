package com.bookmall.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Book;
import com.bookmall.bean.CartItem;
import com.bookmall.bean.CartItemAnBook;
import com.bookmall.bean.Order;
import com.bookmall.bean.OrderItem;
import com.bookmall.bean.PageBean;
import com.bookmall.bean.User;
import com.bookmall.dao.impl.OrderItemDaoImpl;
import com.bookmall.service.BookService;
import com.bookmall.service.CartItemService;
import com.bookmall.service.CategoryService;
import com.bookmall.service.OrderService;
import com.bookmall.service.impl.BookServiceImpl;
import com.bookmall.service.impl.CartItemServiceImpl;
import com.bookmall.service.impl.CategoryServiceImpl;
import com.bookmall.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/servlet/OrderServlet")
public class OrderServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	OrderService orderService = new OrderServiceImpl();
	CartItemService cartItemService = new CartItemServiceImpl();
	CategoryService categoryService = new CategoryServiceImpl();

	/**
	 * 获取当前页码
	 * 
	 * @param req
	 * @return
	 */
	private int getPc(HttpServletRequest req) {
		int pc = 1;
		String param = req.getParameter("pc");
		if (param != null && !param.trim().isEmpty()) {
			try {
				pc = Integer.parseInt(param);
			} catch (RuntimeException e) {
			}
		}
		return pc;
	}

	/**
	 * 截取url，页面中的分页导航中需要使用它做为超链接的目标！
	 * 
	 * @param req
	 * @return
	 */
	/*
	 * http://localhost:8080/goods/BookServlet?methed=findByCategory&cid=xxx&pc=3
	 * /goods/BookServlet + methed=findByCategory&cid=xxx&pc=3
	 */
	private String getUrl(HttpServletRequest req) {
		String url = req.getRequestURI() + "?" + req.getQueryString();
		/*
		 * 如果url中存在pc参数，截取掉，如果不存在那就不用截取。
		 */
		int index = url.lastIndexOf("&pc=");
		if (index != -1) {
			url = url.substring(0, index);
		}
		return url;
	}

	
	
	
	// 加载订单
	public String load(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String oid = req.getParameter("oid");
		Order order;
		try {
			order = orderService.load(Integer.parseInt(oid));
			req.setAttribute("order", order);
			String btn = req.getParameter("btn");// btn说明了用户点击哪个超链接来访问本方法的
			req.setAttribute("btn", btn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(oid);
		return "f:/jsp/generate_orderitem_out.jsp";
	}

	// 生成订单
	public String createOrder(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 获取所有购物车条目的id，查询之
		 */
		List<CartItem> cartItemList = new ArrayList<CartItem>();
		User user = (User) req.getSession().getAttribute("user");
		CartItemService cs=new CartItemServiceImpl();
	
//		List<CartItemAnBook> cartitembooklist=(List<CartItemAnBook>) req.getSession().getAttribute("cartItemAnBookList");
//		List<Integer> bids=new ArrayList<Integer>();
//		
//		for (CartItemAnBook cartitembook : cartitembooklist) {
//			int bid=cartitembook.getBid();
//			System.out.println(bid);
//			bids.add(bid);
//		}
		
		int[] bookid=(int[]) req.getSession().getAttribute("checkedid");
		
		
		for (int i : bookid) {
			CartItem cart=new CartItem();
			try {
				cart=cs.selectCartItem(i, user.getCosuid());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cartItemList.add(cart);
		}
		
		
		try {
			
			
			
			if (cartItemList.size() == 0) {
				req.setAttribute("code", "error");
				req.setAttribute("msg", "您没有选择要购买的图书，不能下单！");
				return "f:/jsp/generate_orderitem_msg.jsp";
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		List<Integer> cartItemIds=new ArrayList<Integer>();
		
		for (CartItem cartItem : cartItemList) {
			int cartid=cartItem.getCartitemid();
			cartItemIds.add(cartid);
		}
		
		
		
		//获取总价
		double total=0;
		CartItemService cis=new CartItemServiceImpl();
		try {
			List<CartItemAnBook> cartitems= cis.selectCartItemAnBookByCosuid(user.getCosuid());
			
			for (CartItemAnBook cartItemAnBook : cartitems) {
				total+=cartItemAnBook.getCurrprice()*cartItemAnBook.getQuantity();
			}
			
			
			
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
		
		/*
		 * 2. 创建Order
		 */
		Order order = new Order();
		//order.setOid(Integer.parseInt(req.getParameter("oid")));// 设置主键
		//order.setOrdertime(java.sql.Date);// 下单时间
		order.setStatus(1);// 设置状态，1表示未付款
		
		//order.setAddress("");//设置收货地址
		//User owner = (User) req.getSession().getAttribute("sessionUser");
		//order.setOwner(user);// 设置订单所有者
		order.setTotal(total);
		order.setUid(user.getCosuid());
		order.setOwner(user);
		order.setOrdertime(new java.sql.Date(System.currentTimeMillis()));

		
		try {
			// 4. 调用service完成添加
			orderService.add(order);
			// 删除购物车条目
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		int oidfromservice=0;
		try {
			oidfromservice = orderService.getorderid();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		order.setOid(oidfromservice);
		
		

		
		
		List<OrderItem> orderitemList = new ArrayList<OrderItem>();
		BookService bs=new BookServiceImpl();
		
		for (CartItem cartItem : cartItemList) {
			OrderItem orderItem = new OrderItem();
			
			//orderItem.setOrderitemid(user.getCosuid());
			orderItem.setQuantity(cartItem.getQuantity());
			
			Book book=null;
			try {
				book = bs.getBookById(cartItem.getBid());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			double xiaoji=cartItem.getQuantity()*(book.getCurrprice());
			
			orderItem.setBook(book);
			orderItem.setSubtotal(xiaoji);
			orderItem.setBid(book.getBid());
			
		
			orderItem.setOrder(order);
			orderitemList.add(orderItem);  
		}
		
		order.setOrderitemList(orderitemList);
		
		
		
		
		
		try {
			orderService.insertorderitembyorderid(order);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

		
		
		/*
		 * 5. 保存订单，转发到generate_orderitem_out.jsp
		 */
		
		
//		int orderid=0;
//		double orderprice=0;
//		
//		try {
//			List<Order> userorder=orderService.getOrderByUserId(user.getCosuid());
//			
//			orderid=userorder.get(0).getOid();
//			orderprice=userorder.get(0).getTotal();
//			
//			
//		} catch (ClassNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
		
		
		
		req.getSession().setAttribute("order", order);
		
		return "f:/jsp/generate_orderitem_out.jsp";
	}

	// 我的订单
	public String myOrders(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 1. 得到pc：如果页面传递，使用页面的，如果没传，pc=1
		int pc = getPc(req);

		// 2. 得到url：...
		String url = getUrl(req);

		// 3. 从当前session中获取User
		User user = (User) req.getSession().getAttribute("user");

		try {
			// 4. 使用pc和cid调用service#findByUser得到PageBean
			PageBean<Order> pb;
			pb = orderService.findByUser(user.getCosuid(), pc);
			// 5. 给PageBean设置url，保存PageBean，转发到/jsp/generate_orderitem.jsp
			pb.setUrl(url);
			req.setAttribute("pb", pb);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "f:/jsp/generate_orderitem.jsp";
	}

}
