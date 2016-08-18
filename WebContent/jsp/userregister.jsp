<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户注册</title>
<link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath }/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<script src="${pageContext.request.contextPath }/js/doUserRegisterJs.js" type="text/javascript"></script>
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
			<a target="_blank" href="../index.jsp">主页</a> <a target="_blank"
				href="${pageContext.request.contextPath }/jsp/userlogin.jsp">用户登录</a>
			<a target="_blank"
				href="${pageContext.request.contextPath }/jsp/sellerregister.jsp">卖家注册</a>
			<a target="_blank"
				href="${pageContext.request.contextPath }/jsp/sellerlogin.jsp">卖家登录</a>
		</div>
	</div>
	<div class="banner">
		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout: fixed;">
				<div class="error-box"></div>
				<form
					action="${pageContext.request.contextPath }/servlet/doUserRegisterServlet"
					method="post" name="frm">
					<div class="fm-item">
						<label for="logonId" class="form-label1">用户名：</label>
						<p>
							<input type="text" id=loginname name="loginname" onblur="check()"
								value="" /><span id="loginnameerror"
								style="font-family: 楷体;"></span>
						</p>
						<div class="ui-form-explain"></div>
					</div>
					<div class="fm-item">
						<label for="logonId" class="form-label1">登录密码：</label>
						<p>
							<input type="password" id="loginpass" name="loginpass"
								value="" /><span id="loginpasserror"
								style="font-family: 楷体;"></span>
						</p>
						<div class="ui-form-explain"></div>
					</div>
					<div class="fm-item">
						<label for="logonId" class="form-label1">确认密码：</label>
						<p>
							<input type="password" id="loginpass1" name="loginpass1"
								onblur="check1()" value="" /><span
								id="loginpasserror1" style="font-family: 楷体;">${loginpasserror1}</span>
						</p>
						<div class="ui-form-explain"></div>
					</div>
					<div class="fm-item">
						<label for="logonId" class="form-label1">Email：</label>
						<p>
							<input type="text" id="email" name="email"
								onblur="checkEmail(this)" value="" /><span
								id="emailerror" style="font-family: 楷体;"></span>
						</p>
						<div class="ui-form-explain"></div>
					</div>
					<div class="fm-item">
						<label for="logonId" class="form-label1">手机号：</label>
						<p>
							<input type="text" id="uphone" name="uphone"
								onblur="checkUphone()" value="" /><span
								id="uphoneerror" style="font-family: 楷体;"></span>
						</p>
						<div class="ui-form-explain"></div>
						<div class="fm-item form form1">
							<label for="logonId" class="form-label1"></label>
							<p>
								<input type="submit" id="" name="" value="注册" />&nbsp; <a
									href="../index.jsp"><input type="button" name="取消"
									value="取消" /></a>
							</p>
							<div class="ui-form-explain"></div>
						</div>
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