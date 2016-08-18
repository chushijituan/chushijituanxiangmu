<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>已取消</title>
<style type="text/css">
*{margin: 0px;font-size: 14px;}
#body{width:900px;margin: auto; background-color: orange;margin-top: 100px;}

#top{padding-top: 10px;}

a{text-decoration:none;/*取消下划线*/ padding: 5px;}
table{width: 900px;}

#title td{
height:30px;
text-align: center;
background-image: url("../img/order_img/title_background.png");}

#table{padding-top: 10px;}

#table_body{padding-top:5px;}

#table_body_title{
padding-left:5px;
background-image: url("../img/order_img/tr_background.png");}

#table_body tr{height: 15px;}

#img{text-align: left;}

#xxx{text-align: center;}

</style>
</head>
<body>
<div id="body">
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
		<html:if test="${status }">
	<div id="table_body">
		<div id="table_body_title">
			<table>
				<tr>
					<td width="60px">订单号：</td>
					<td width="250px">
						<a href="<html:url value='/servlet/OrderServlet?method=load&oid=${order.oid }'/>">${order.oid }</a>
					</td>
					<td width="80px">订单时间：</td>
					<td>${order.ordertime }</td>
				</tr>
			</table>
		</div>
		<div id="table_new">
			<table>
				<tr>
					<th width="40%" rowspan="4" id="img">
						<html:forEach items="${order.orderItemList }" var="orderItem">
							<a class="link2" href="<html:url value='/BookServlet?method=load&bid=${orderItem.book.bid }'/>"> <img border="0" src="<html:url value='/${orderItem.book.image_b }'/>" /></a>
						</html:forEach></th>
					<td width="20%" id="xxx" rowspan="4">&yen;${order.total }</td>
					<td width="20%" id="xxx" rowspan="4">已取消</td>
					<td width="20%" ></td>
				</tr>
				<tr>
					<td width="20%" id="xxx">
						<a href="<html:url value='/servlet/OrderServlet?method=load&oid=${order.oid }'/>">查看</a>
					</td>
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
	</html:if>
	</html:forEach>
</div>

<table>
	<tr ></tr>
</table>
<script>
setInterval("timeStr=new Date().toLocaleString();timer.innerText=timeStr;")
</script>
</body>
</html>