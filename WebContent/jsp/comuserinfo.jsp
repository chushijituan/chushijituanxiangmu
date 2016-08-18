<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/BookMallProject/js/showComuserInfoJs.js" type="text/javascript"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet" />
<link href="../css/sellerIndex.css" rel="stylesheet" />
<script src="../js/jquery.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<script src="../js/sellerIndex.js" type="text/javascript"></script>
<title>用户信息</title>
</head>
<body>
	<div class="header">
		<img class="logo" src="../img/shop_img/logo.png" />
		<ul class="inline">
			<li><span><a href="../index.jsp" class="loginout">首页</a></span>
			</li>
			
			<li><span><a class="loginout"
					href="../servlet/removeUserSessionServlet">退出</a></span></li>
		</ul>
	</div>
	<div class="nav">
		<div class="nav-icon">
			<img src="../img/shop_img/client.png" />&nbsp;&nbsp;欢迎您${seller.sname }
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
									<span class="left-body font">个人信息</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="content-right">
					<div class="form ">
						<form action="../servlet/showComuserInfoServlet" method="post"
							id="form1" name="form1">
							<div>
								<div>
									<span>姓&nbsp;&nbsp;名：</span> &nbsp;&nbsp;&nbsp;<span> <input type="text"
										name="loginname" value="${user.loginname}" disabled
										id="loginname" onChange="return gd1()" /> <input id="radio1"
										type="radio" name="sfgd" value=1 checked="true"
										onclick="gd1()" />
									</span>
								</div>
								<div>
									<span>密&nbsp;&nbsp;码：</span>&nbsp;&nbsp;&nbsp;&nbsp; <span> <input
										type="password" name="loginpass" value="${user.loginpass}"
										disabled id="loginpass" onChange="return gd2()" /> <input
										id="radio2" type="radio" name="sfgd" value=1 checked="true"
										onclick="gd2()" />
									</span>
								</div>
								<div>
									<span>确认密码：</span> <span> <input type="password"
										name="loginpass1" value="${user.loginpass}" disabled
										id="loginpass1" onChange="return gd3()" /> <input id="radio3"
										type="radio" name="sfgd" value=1 checked="true"
										onclick="gd3()" />
									</span>
								</div>
								<div>
									<span>Email： &nbsp;</span><span> &nbsp;&nbsp;<input type="text"
										name="email" value="${user.email}" disabled id="email"
										onChange="return gd4()" /> <input id="radio4" type="radio"
										name="sfgd" value=1 checked="true" onclick="gd4()" />
									</span>
								</div>
								<div>
									<span>phone： &nbsp;</span> <span> &nbsp;&nbsp;<input type="text"
										name="uphone" value="${user.uphone}" disabled id="uphone"
										onChange="return gd5()" /> <input id="radio5" type="radio"
										name="sfgd" value=1 checked="true" onclick="gd5()" />
									</span>
								</div>
								<div>
									<input type="submit" name="submit" id="submit"
										onclick="form1.loginname.disabled=false;form1.loginpass.disabled=false;form1.loginpass1.disabled=false;form1.email.disabled=false;form1.uphone.disabled=false;"
										value="保存" /> <a href="../index.jsp"><input type="button" name="取消" value="取消"/></a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>