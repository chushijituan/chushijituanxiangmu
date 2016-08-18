<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>订单列表</title>
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
}

#name {
	margin-left: 5px;
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
	background-image: url("../img/order_img/title_background.png");
}

#table {
	padding-top: 10px;
}

#table_body {
	padding-top: 5px;
}

#table_body_title {
	padding-left: 5px;
	background-image: url("../img/order_img/tr_background.png");
}

#table_body tr {
	height: 15px;
}

#img {
	text-align: left;
}

#xxx {
	text-align: center;
}
</style>
</head>
<body>
	<div id="body">
		<div id="name">${user.loginname }的订单</div>
		<div id="top">
			<span> <a
				href="${pageContext.request.contextPath }/jsp/generate_orderitem_1.jsp?status=1">未付款</a>&nbsp;|
				<a
				href="${pageContext.request.contextPath }/jsp/generate_orderitem_2.jsp?status=2">已付款</a>&nbsp;|
				<a
				href="${pageContext.request.contextPath }/jsp/generate_orderitem_3.jsp?status=3">已发货</a>&nbsp;|
				<a
				href="${pageContext.request.contextPath }/jsp/generate_orderitem_4.jsp?status=4">交易成功</a>&nbsp;|
				<a
				href="${pageContext.request.contextPath }/jsp/generate_orderitem_5.jsp?status=5">已取消</a>
			</span>
		</div>
		<div id="table">
			<table cellpadding="0" cellspacing="0">
				<tr id="title">
					<td width="40%">商品信息</td>
					<td width="20%">金额</td>
					<td width="20%">订单状态</td>
					<td width="20%">操作</td>
				</tr>
			</table>
		</div>

		<html:forEach items="${pb.beanList }" var="order">

			<tr class="tt">
				<td width="320px">订单号：<a
					href="<html:url value='/servlet/OrderServlet?method=load&oid=${order.oid }'/>">${order.oid }</a></td>
				<td width="200px">下单时间：${order.ordertime }</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr style="padding-top: 10px; padding-bottom: 10px;">
				<td colspan="2"><html:forEach items="${order.orderItemList }"
						var="orderItem">
						<a class="link2" href="<html:url value='/BookServlet?method=load&bid=${orderItem.book.bid }'/>"> <img border="0" src="<html:url value='/${orderItem.book.image_b }'/>" />
						</a>
					</html:forEach></td>
				<td width="115px"><span class="price_t">&yen;${order.total }</span>
				</td>
				<td width="142px"><html:choose>
						<html:when test="${order.status eq 1 }">等待付款</html:when>
						<html:when test="${order.status eq 2 }">准备发货</html:when>
						<html:when test="${order.status eq 3 }">等待确认</html:when>
						<html:when test="${order.status eq 4 }">交易成功</html:when>
						<html:when test="${order.status eq 5 }">已取消</html:when>
					</html:choose></td>
				<td><a
					href="<html:url value='/servlet/OrderServlet?method=load&oid=${order.oid }'/>">查看</a><br />
					<html:if test="${order.status eq 1 }">
						<a
							href="<html:url value='/servlet/OrderServlet?method=paymentPre&oid=${order.oid }'/>">支付</a>
						<br />
						<a
							href="<html:url value='/servlet/OrderServlet?method=load&oid=${order.oid }&btn=cancel'/>">取消</a>
						<br />
					</html:if> <html:if test="${order.status eq 3 }">
						<a
							href="<html:url value='/servlet/OrderServlet?method=load&oid=${order.oid }&btn=confirm'/>">确认收货</a>
						<br />
					</html:if></td>
			</tr>
		</html:forEach>
	</div>

	<table>
		<tr></tr>
	</table>
</body>
</html>


<!-- 
	<html:forEach items="i">
		<html:choose>
			<html:when test="1">
	<div id="table_body">
		<div id="table_body_title">
			<table>
				<tr>
					<td width="60px">订单号：</td>
					<td width="250px">${order.oid }</td>
					<td width="80px">订单时间：</td>
					<td id="timer">${order.ordertime }</td>
				</tr>
			</table>
		</div>
		<div id="table_new">
			<table>
				<tr>
					<th width="40%" rowspan="4" id="img"><img src="img/order_img/test.png"></th>
					<td width="20%" id="xxx" rowspan="4">￥${order.total }</td>
					<td width="20%" id="xxx" rowspan="4">未付款</td>
					<td width="20%" ></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_show.jsp">查看</a></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_delete.jsp">取消</a></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_out.jsp">确认</a></td>
				</tr>
			</table>
		</div>
	</div>
			</html:when>
			<html:when test="2">
	<div id="table_body">
		<div id="table_body_title">
			<table>
				<tr>
					<td width="60px">订单号：</td>
					<td width="250px">22222222222</td>
					<td width="80px">订单时间：</td>
					<td id="timer"></td>
				</tr>
			</table>
		</div>
		<div id="table_new">
			<table>
				<tr>
					<th width="40%" rowspan="4" id="img"><img src="img/order_img/test.png"></th>
					<td width="20%" id="xxx" rowspan="4">66.6  ￥</td>
					<td width="20%" id="xxx" rowspan="4">已付款</td>
					<td width="20%" ></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_show.jsp">查看</a></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_delete.jsp">取消</a></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_out.jsp">确认</a></td>
				</tr>
			</table>
		</div>
	</div>
			</html:when>
			<html:when test="3">
	<div id="table_body">
		<div id="table_body_title">
			<table>
				<tr>
					<td width="60px">订单号：</td>
					<td width="250px">22222222222</td>
					<td width="80px">订单时间：</td>
					<td id="timer"></td>
				</tr>
			</table>
		</div>
		<div id="table_new">
			<table>
				<tr>
					<th width="40%" rowspan="4" id="img"><img src="img/order_img/test.png"></th>
					<td width="20%" id="xxx" rowspan="4">66.6  ￥</td>
					<td width="20%" id="xxx" rowspan="4">已发货</td>
					<td width="20%" ></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_show.jsp">查看</a></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_delete.jsp">删除</a></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="#"></a></td>
				</tr>
			</table>
		</div>
	</div>
			</html:when>
			<html:when test="4">
	<div id="table_body">
		<div id="table_body_title">
			<table>
				<tr>
					<td width="60px">订单号：</td>
					<td width="250px">22222222222</td>
					<td width="80px">订单时间：</td>
					<td id="timer"></td>
				</tr>
			</table>
		</div>
		<div id="table_new">
			<table>
				<tr>
					<th width="40%" rowspan="4" id="img"><img src="img/order_img/test.png"></th>
					<td width="20%" id="xxx" rowspan="4">66.6  ￥</td>
					<td width="20%" id="xxx" rowspan="4">交易成功</td>
					<td width="20%" ></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_show.jsp">查看</a></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_delete.jsp">删除</a></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="#"></a></td>
				</tr>
			</table>
		</div>
	</div>
			</html:when>
			<html:when test="5">
	<div id="table_body">
		<div id="table_body_title">
			<table>
				<tr>
					<td width="60px">订单号：</td>
					<td width="250px">22222222222</td>
					<td width="80px">订单时间：</td>
					<td id="timer"></td>
				</tr>
			</table>
		</div>
		<div id="table_new">
			<table>
				<tr>
					<th width="40%" rowspan="4" id="img"><img src="img/order_img/test.png"></th>
					<td width="20%" id="xxx" rowspan="4">66.6  ￥</td>
					<td width="20%" id="xxx" rowspan="4">已取消</td>
					<td width="20%" ></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_show.jsp">查看</a></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="../jsp/generate_orderitem_delete.jsp">删除</a></td>
				</tr>
				<tr>
					<td width="20%" id="xxx"><a href="#"></a></td>
				</tr>
			</table>
		</div>
	</div>
			</html:when>
		</html:choose>
	</html:forEach>

	 -->