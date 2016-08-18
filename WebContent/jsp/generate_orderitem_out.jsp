<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单确认</title>
<style type="text/css">
* {
	margin: 0px;
	font-size: 14px;
}

#body {
	width: 900px;
	margin: auto;
	background-color: orange;
	margin-top: 100px;
	position: relative; /*相对定位*/
}

#top {
	padding-top: 10px;
}

a {
	text-decoration: none; /*取消下划线*/
	padding: 5px;
}

table {
	width: 900px;
}

#title td {
	height: 30px;
	text-align: center;
	background-image: url("img/order_img/title_background.png");
}

#table {
	padding-top: 10px;
}

#table_body {
	padding-top: 5px;
}

#table_body_title {
	padding-left: 5px;
	background-image: url("img/order_img/tr_background.png");
}

#table_body tr {
	height: 15px;
}

#xxx {
	text-align: center;
}

#btn {
	width: 100px;
	float: right;
	margin-right: 60px;
}

#btn {
	padding-top: 10px;
}

#btn_buy {
	padding: 5px;
}

#btn_buy input {
	width: 125px;
	height: 35px;
}

#btn_clear {
	padding: 5px;
}

#btn_clear input {
	width: 125px;
	height: 35px;
}
</style>

<script type="text/javascript">
function queren(){
	document.frm.action="/BookMallProject/servlet/AddressServlet";
	 document.frm.submit();
	
}

function quxiao(){
	document.frm.action="/BookMallProject/jsp/generate_orderitem.jsp";
	document.frm.submit();
	
}


</script>

</head>
<body>
	<div id="body">
		<div id="name">${user.loginname }的订单</div>
		
		<div id="top">
			<table cellpadding="0" cellspacing="0">
				<tr>
					<td width="60px">订单号：</td>
					<td width="200px">${order.oid }</td>
					<td width="80px">下单时间：</td>
					<td id="timer">${order.ordertime }</td>
				</tr>
			</table>
		</div>
		<div>
			<div>收货人信息</div>
			<div>
			收货人姓名：<input type="text" name="receiver">
			收货人地址：<input type="text" name="address">
			收货人电话：<input type="text" name="rphone">
			</div>
		</div>
		<div id="table">
			<div>商品清单</div>
			<table cellpadding="0" cellspacing="0">
				<tr id="title">
					<td width="40%">商品名称</td>
					<td width="20%">单价</td>
					<td width="20%">数量</td>
					<td width="20%">小计</td>
				</tr>
			</table>
		</div>
		<html:forEach items="${order.orderitemList }" var="item">
			<div id="table_body">
				<div id="table_new">
					<table>
						<tr>
							<th width="40%" rowspan="4" id="img">${item.book.bname } </th>
							<th width="20%" id="xxx" rowspan="4">${item.book.currprice }</th>
							<th width="20%" id="xxx" rowspan="4">${item.quantity }</th>
							<th width="20%" id="xxx" rowspan="4">${item.subtotal }</th>
						</tr>
					</table>
				</div>
			</div>
		</html:forEach>
		
		<div id="btn">
			<div>合&nbsp;&nbsp;计：<span class="price_t">&yen;${order.total }</span></div>
		<form action="" name="frm">
		
			<div id="btn_buy">
				<input type="button" name="yes" value="确     认"
					style="background-image: url('../img/order_img/button_buy.png');"
					onclick="queren()"/>
					
					
			</div>
			<div id="btn_clear">
				<input type="button" name="no" value="取     消"
					style="background-image: url('../img/order_img/button_clear.png');"
					onclick="quxiao()" />
			</div>
		</form>
			
		</div>


	
			

	</div>

	<table>
		<tr></tr>
	</table>
</body>
</html>
