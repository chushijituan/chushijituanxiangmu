package com.bookmall.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.service.OrderService;
import com.bookmall.service.impl.OrderServiceImpl;
import com.bookmall.utils.PaymentUtil;






@WebServlet("/servlet/BackServlet")
public class BackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		/*
		 * 易宝会提供一系列的结果参数，我们获取其中需要的即可
		 * 获取支付结果：r1_Code，1表示支付成功。
		 * 获取支付金额：r3_Amt
		 * 获取电商的订单号：r6_Order
		 * 获取结果返回类型：r9_BType，1表示重定向返回，2表示点对点返回，
		 *     但点对点我们收不到，因为我们的ip都是局域网ip。
		 */
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		
		
		String hmac=request.getParameter("hmac");
		String p1_MerId=request.getParameter("p1_MerId");
		String r0_Cmd=request.getParameter("r0_Cmd");
		
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");
		
		
		
		boolean flag=PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);
		
		
		if(flag!=false){
			if(r1_Code.equals("1")) {
				
				if(r9_BType.equals("1")) {
					response.getWriter().print("<h1>支付成功！</h1>");//其实支付不成功时根本易宝根本就不会返回到本Servlet
					response.getWriter().print("支付金额为：" + r3_Amt + "<br/>");
					response.getWriter().print("订单号为：" + r6_Order + "<br/>");
					response.getWriter().print("<a href='/BookMallProject/servlet/MainServlet'>返回首页</a>");
					OrderService os=new OrderServiceImpl();
					try {
						os.updateStatus(Integer.parseInt(r6_Order), 2);
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else if(r9_BType.equals("2")){
					response.getWriter().print("success");
				}
			}
		}
		
		
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
		
		
	}

}
