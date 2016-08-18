package com.bookmall.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookmall.bean.Order;
import com.bookmall.utils.PaymentUtil;


@WebServlet("/servlet/BuyServlet")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=GBK");
		
		Order order=new Order();
		order=(Order) request.getSession().getAttribute("order");

		String p0_Cmd = "Buy";// 业务类型，固定值为buy，即“买”
		String p1_MerId = "10001126856";// 在易宝注册的商号
		String p2_Order = order.getOid()+"";// 订单编号
		//String p3_Amt = order.getTotal()+"";// 支付的金额
		String p3_Amt="0.01";
		String p4_Cur = "CNY";// 交易种币，固定值为CNY，表示人民币
		String p5_Pid = "";// 商品名称
		String p6_Pcat = "";// 商品各类
		String p7_Pdesc = "";// 商品描述
		String p8_Url = "http://localhost:8080/BookMallProject/servlet/BackServlet";// 电商的返回页面，当支付成功后，易宝会重定向到这个页面
		String p9_SAF = "";// 送货地址
		String pa_MP = "";// 商品扩展信息
		String pd_FrpId = request.getParameter("pd_FrpId");// 支付通道，即选择银行
		String pr_NeedResponse = "1";// 应答机制，固定值为1
		
			

		// 密钥，由易宝提供，只有商户和易宝知道这个密钥。
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
		


		// 通过上面的参数、密钥、加密算法，生成hmac值
		// 参数的顺序是必须的，如果没有值也不能给出null，而应该给出空字符串。
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
				p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
				pd_FrpId, pr_NeedResponse, keyValue); 
		
		
		
		// 把所有参数连接到网关地址后面
		
		String url = "https://www.yeepay.com/app-merchant-proxy/node";
		url += "?p0_Cmd=" + p0_Cmd + 
				"&p1_MerId=" + p1_MerId +
				"&p2_Order=" + p2_Order + 
				"&p3_Amt=" + p3_Amt + 
				"&p4_Cur=" + p4_Cur + 
				"&p5_Pid=" + p5_Pid + 
				"&p6_Pcat=" + p6_Pcat + 
				"&p7_Pdesc=" + p7_Pdesc + 
				"&p8_Url=" + p8_Url + 
				"&p9_SAF=" + p9_SAF + 
				"&pa_MP=" + pa_MP + 
				"&pd_FrpId=" + pd_FrpId + 
				"&pr_NeedResponse=" + pr_NeedResponse + 
				"&hmac=" + hmac;
		
		String url2=new String(url.getBytes("utf8"),"gbk");

		// 重定向到网关

		response.sendRedirect(url2);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
		
	}

}
