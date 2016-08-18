<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath }/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
</head>
<body>
	<div class="top top-div-margin-bottom">
		<div class="top-container div-center  page-size">
			<div class="float-left   top-div-margin-top">欢迎注册购书网</div>
			<div class=" top-div-margin-top float-right">6666年06月06日 星期日</div>
		</div>
	</div>
	<div class="header">
		<h1 class="headerLogo">
			<img alt="logo" src="../img/login_img/logo.jpg">
		</h1>
		<div class="headerNav">
			<a target="_blank" href="../index.jsp">主页</a> 
			<a target="_blank"
				href="${pageContext.request.contextPath }/jsp/sellerregister.jsp">卖家注册</a>
			<a target="_blank"
				href="${pageContext.request.contextPath }/jsp/userlogin.jsp">用户登录</a>
			<a target="_blank"
				href="${pageContext.request.contextPath }/jsp/sellerlogin.jsp">用户注册</a>
		</div>
	</div>
	<div class="banner">
		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout: fixed;">
				<div class="error-box"></div>
				<form action="../servlet/doSellerloginServlet" method="post">
					<div class="fm-item">
						<h1>&nbsp;  卖家登陆</h1>
						<label for="logonId" class="form-label2">账号：</label>
						<p>
							<input type="text" id=sname name="sname" class="i-text" />
						<div id="snameerror" style="font-family: 楷体;">${snameerror}</div>
						</p>
						<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item">
						<label for="logonId" class="form-label2">密码：</label>
						<p>
							<input type="password" id="spassword" class="i-text"
								name="spassword" /><span id="spassworderror"></span>
						</p>
						<div class="ui-form-explain"></div>
					</div>


					<div class="fm-item">
						<label for="logonId" class="form-label2"></label> <input
							type="submit" value="" tabindex="4" id="send-btn"
							class="btn-login">
						<div class="ui-form-explain"></div>
					</div>

				</form>


			</div>
		</div>
		<div class="bd">
			<ul>
				<li
					style="background: url(../img/login_img/bg.jpg) #CCE1F3 center 0 no-repeat;"></li>
				<li
					style="background: url(../img/login_img/bg.jpg) #BCE0FF center 0 no-repeat;"></li>
			</ul>
		</div>
	</div>
	<div class=" div-center  page-size footer">

		<p>书中自有黄金屋，书中自有颜如玉</p>

	</div>
</body>
</html>