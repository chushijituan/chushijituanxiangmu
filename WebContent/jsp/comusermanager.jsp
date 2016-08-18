<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/sellerIndex2.css" rel="stylesheet" />
<script src="../js/jquery.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../js/sellerIndex.js" type="text/javascript"></script>
</head>
<body>
	<div class="header">
		<img class="logo" src="../img/shop_img/logo.png" />
		<ul class="inline">
			<li><span><a href="../index.jsp" class="loginout">首页</a></span>
			</li>

			<li><span><a class="loginout" href="../jsp/userlogin.jsp">退出</a></span></li>
		</ul>
	</div>
	<div class="nav">
		<div class="nav-icon">
			<img src="../img/shop_img/client.png" />&nbsp;&nbsp;欢迎您${user.loginname}
		</div>
	</div>
	<div class="container-fluid content">
		<div class="row-fluid div-center">
			<div class="memu div-center">
				<div class="span2 content-left">
					<div class="accordion">
						<div class="accordion-group">
							<div class="accordion-heading">
								<a class="accordion-toggle" data-toggle="collapse"
									data-parent="#accordion2" href="#collapseOne"> <img
									class="left-icon" src="../img/shop_img/5026_settings.png" /><span
									class="left-title">系统设置</span>
								</a>
							</div>
							<div id="collapseOne" class="accordion-body collapse in">
								<div class="accordion-inner">
									<span class="left-body font"><a href="../servlet/ComuserManagerServlet">用户管理</a></span>
								</div>
								<div class="accordion-inner">
									<span class="left-body font"><a href="../servlet/toshopmanagerServlet">店铺管理</a></span>
								</div>
								<div class="accordion-inner">
									<span class="left-body font"><a href="../servlet/SellerManagerServlet">卖家管理</a></span>
								</div>
							</div>
							
						</div>
					</div>
				</div>
				<div class="content-right">
					<div class="form div-center">
						<form action="../servlet/doUserChangeServlet" method="post"
							id="form1" name="form1">
							<table border="1" cellpadding="0" cellspacing="0">
								<tr>
									<th>姓名</th>
									<th>Email</th>
									<th>Phone</th>
									<th>提交</th>
									<th>删除</th>
								</tr>
								<c:forEach items="${userList}" var="user">
									<tr>
										<input type="hidden" name="cosuid" value="${user.cosuid}" />
										<input type="hidden" name="loginpass" value="${user.loginpass}" />
										<td><input type="text" name="loginname"
											value="${user.loginname}" id="${user.loginname}" /></td>
										<td><input type="text" name="email" value="${user.email}"
											id="${user.loginname}" /></td>
										<td><input type="text" name="uphone"
											value="${user.uphone}" id="${user.loginname}" /></td>
										<td><input type="submit" name="提交" value="提交" /></td>
										<td><a
											href="../servlet/dodeleteUserServlet?cosuid=${user.cosuid}"><input
												type="button" name="删除" value="删除" /></a><span>${loginnameerror1}</span></td>
									</tr>
								</c:forEach>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>