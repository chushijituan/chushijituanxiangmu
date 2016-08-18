<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登陆</title>
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
		</div>
	</div>
	<div class="banner">
		<div class="login-aside">
			<div id="o-box-up"></div>
			<div id="o-box-down" style="table-layout: fixed;">
				<div class="error-box"></div>
					<form action="../servlet/dologinServlet" method="post">
					<div class="fm-item">
						<h1>&nbsp;&nbsp;管理员</h1>
						<label for="logonId" class="form-label2">账号：</label>
						<p>
							<input type="text" id="adminname" name="adminname" class="i-text" />
							<div id="adminnameerror" style="font-family: 楷体;"> ${adminnameerror}</div>
						</p>
						<div class="ui-form-explain"></div>
					</div>

					<div class="fm-item">
						<label for="logonId" class="form-label2">密码：</label>
						<p>
							<input type="password" id="adminpwd" class="i-text"
								name="adminpwd" /><span id="adminpwderror"></span>
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