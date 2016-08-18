<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>卖家注册</title>
<script src="/BookMallProject/js/doSellerRegisterJs.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
<link href="${pageContext.request.contextPath }/css/demo.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
</head>
<body>
<div class="top top-div-margin-bottom">
			<div class="top-container div-center  page-size" >
				<div class="float-left   top-div-margin-top">
					欢迎注册购书网
				</div>
				<div class=" top-div-margin-top float-right">
				6666年06月06日  星期日
			</div>
			</div>		
		</div>
<div class="header">
	  <h1 class="headerLogo"><img alt="logo" src="../img/login_img/logo.jpg"></h1>
		<div class="headerNav">
			<a target="_blank" href="${pageContext.request.contextPath }/jsp/index.jsp">主页</a>
			<a target="_blank" href="${pageContext.request.contextPath }/jsp/sellerlogin.jsp">卖家登录</a>
			<a target="_blank" href="${pageContext.request.contextPath }/jsp/userregister.jsp">用户注册</a>
			<a target="_blank" href="${pageContext.request.contextPath }/jsp/userlogin.jsp">用户登录</a>	
		</div>
	</div>
	<div class="banner">
		  <div class="login-aside">
		   <div id="o-box-up"></div>
		   <div id="o-box-down"  style="table-layout:fixed;">
		   <div class="error-box"></div>
			<form action="../servlet/doSellerRegisterServlet" method="post" name="frm">
				<div class="fm-item">
					<label for="logonId" class="form-label">卖家名：</label>
                    <p><input type="text" id=sname name="sname" onblur="check()" value="${seller.sname}" /><span id="snameerror" style="font-family: 楷体;"></span></p>
				    <div class="ui-form-explain"></div>
				</div>
			    <div class="fm-item">
				   <label for="logonId" class="form-label">登录密码：</label>
				   <p><input type="password" id="spassword" name="spassword" value="${seller.spassword}"/><span id="spassworderror" style="font-family: 楷体;"></span></p>
			       <div class="ui-form-explain"></div>
			    </div>
			    <div class="fm-item">
				   <label for="logonId" class="form-label">确认密码：</label>
					<p><input type="password" id="spassword1" name="spassword1" value="${seller.spassword}"/><span id="spasswor1derror" style="font-family: 楷体;">${spasserror1}</span></p>
			       <div class="ui-form-explain"></div>
			    </div>
			    <div class="fm-item">
				   <label for="logonId" class="form-label">Email：</label>
				   <p><input type="text" id="semail" name="semail" onblur="checkEmail(this)" value="${seller.semail}"/><span id="semailerror" style="font-family: 楷体;"></span></p>
			       <div class="ui-form-explain"></div>
			    </div>
			    <div class="fm-item">
				   <label for="logonId" class="form-label">身份证号：</label>
                   <p><input type="text" id="sidentification" onblur="checksidentification(this)" name="sidentification" value="${seller.sidentification}"/><span id="sidentificationerror" style="font-family: 楷体;"></span></p>
			       <div class="ui-form-explain"></div>
			    </div>
			    <div class="fm-item form form1">
				   <label for="logonId" class="form-label">手机号：</label>
				   <p><input type="text" id="sphone" name="sphone" onblur="checkUphone()" value="${seller.sphone}"/><span id="sphoneerror" style="font-family: 楷体;"></span></p>            	
			       <div class="ui-form-explain"></div>
			   	   <div class="fm-item">
					   <label for="logonId" class="form-label"></label>
			       	   <p><input type="submit" id="" name="" value="注册"/>&nbsp;
			       	      <a href="../index.jsp"><input type="button" name="取消" value="取消"/></a></p>
					   
				       <div class="ui-form-explain"></div>
				   </div>
			    </div>
			</form>
		  </div>
	     </div>  
	     <div class="bd">
			<ul>
				<li style="background:url(../img/login_img/bg.jpg) #CCE1F3 center 0 no-repeat;"></li>
				<li style="background:url(../img/login_img/bg.jpg) #BCE0FF center 0 no-repeat;"></li>
			</ul>
	</div>
	</div>
	<div class=" div-center  page-size footer">        	
	      <p>书中自有黄金屋，书中自有颜如玉</p>
	        </div>
</body>
</html>