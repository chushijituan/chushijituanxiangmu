<%@page import="com.bookmall.service.impl.ShopServiceImpl"%>
<%@page import="com.bookmall.service.ShopService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.bookmall.bean.* ,java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function add() {
		document.form.action="../servlet/toaddbookServlet";
		document.form.submit();
	}
</script>
<style type="text/css">
body{margin: 0px;padding: 0px;}
	.top{
		width: 1366px;
		height: 75px;
		font-size:20px;
		text-align: center;
	}
	.top-left{
		width:205px;
		height: 74px;
		background-image: url("../img/shop_img/1.png");
		float: left;
		margin-left: 50px;
	}
	.top-right{
		width:205px;
		height: 74px;
		background-image: url("../img/shop_img/1.png");
		float: right;
		margin-right: 50px;
	}
	.title{
		font-size: 60px;
		float: left;
		width: 850px;
		height: 74px;
		line-height:74px;
		text-align:center;
	}
	.title p{
		line-height:74px;
		
		height:74px;
	}
	.bootom{
		margin-top:1px;
		width:1366px;
		height: 600px;
		background-color:#F2F2F2;
	}
	.left{
		width:280px;
		height:600px;
		float: left;
		
	}
	.right{
		width: 1000px;
		height: 600px;
		float: left;
		margin-left: 20px;
	}
	.form{
	width:250px;
	margin-left: 10px;
	font-size: 13px;
	}
	.form table{
		font-size: 20px;
		width: 250px;
	}
	.form table tr{
		height:30px;
		margin-top: 20px;
		margin-bottom: 20px;
	}
	.form table td{
		width: 150px;
	}
	.form2{
		width: 1050px;
		height: 600px;
		border: 1px solid #d3d1d1;
	}
	.form2 table{
		font-size: 20px;
		margin-bottom: 20px;
	}
	.form2 table tr{
		height:30px;
		margin-top: 20px;
		margin-bottom: 20px;
	}
	.form2 table td{
	 width: 100px;
	 text-align: center;
	 padding-top: 10px;
}
	.tdicon{
	width: 120px;
	text-align: center;
	}
</style>
</head>
<body>
	<div class="top">
		<div class="top-left"></div>
			<div class="title">
				${sessionScope.shop.shopname }
			</div>	
		<div class="top-right"></div>	
	</div>
	<div class="bootom">
		<div class="left">
			<div class="form" >
				<form name="form">
				<table>
					<tr><td>店铺名:${sessionScope.shop.shopname }</td></tr>
					<tr><td>店主:${sessionScope.seller.sname }</td></tr>
					<tr><td>创建时间:${sessionScope.shop.createtime }</td></tr>
					<tr><td>描述:</td></tr>
					<tr><td><textarea rows="10" cols="30">${sessionScope.shop.shopdesc }</textarea> </td></tr>	
					<tr><td>图书信息:<input type="button" value="添加图书" onclick="add()">&nbsp; <input type="button" value="返回" onclick="window.location.href='../jsp/sellerindex.jsp'"></td></tr>
				</table>
			</form>	
			</div>
		</div>
		<div class="right">
			<div class="form2">
				<table  cellpadding="0" cellspacing="0">
					<tr>
							<td>图片</td>
							<td>图书名</td>
							<td>作者</td>
							<td>原价</td>
							<td>现价</td>
							<td>折扣</td>
							<td>出版社</td>
							<td>出版时间</td>
							<td>种类</td>
							<td>操作</td>
					</tr>
					<c:choose>
						<c:when test="${sessionScope.booklist==null}">
							<tr>
								<td>&nbsp; </td>
								<td>&nbsp; </td>
								<td>&nbsp; </td>
								<td>&nbsp; </td>
								<td>&nbsp; </td>
								<td>&nbsp; </td>
								<td>&nbsp; </td>
								<td>&nbsp; </td>
								<td>&nbsp; </td>
								<td>&nbsp; </td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach items="${sessionScope.booklist}" var="book">
								<tr>
									<td><img src="../img/${book.image }"></td>
									<td>${book.bname }</td>
									<td>${book.author }</td>
									<td>${book.price }</td>
									<td>${book.currprice }</td>
									<td>${book.discount }</td>
									<td class="tdicon">${book.press }</td>
									<td class="tdicon">${book.publishtime }</td>
									<td>${book.cname }</td>
									<td class="tdicon"><a href="../servlet/toupdatebookServlet?bid=${book.bid }">修改</a>
									<a href="../servlet/deletebookServlet?bid=${book.bid }">删除</a></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</div>
	</div>	
</body>
</html>