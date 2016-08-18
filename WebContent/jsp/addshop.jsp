<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商店注册</title>
<style type="text/css">
.top{
	width: 1367px;
	height: 100px;
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
.separator {
    height: 2px;
    font-size: 0;
    line-height: 0;
    background: #e4e7e7;
    clear: both;
}
	.main{
		width: 500px;
		height: 300px;
		margin: auto;
		background-color:#F2F2F2;
	}
	.form{
		font-size: 20px;
	}
	.form input[type=text]{
	height: 20px;
	width: 200px;
	border:solid 1px cadetblue;
	}
	.form input[type=submit]{
		width:75px;
		height: 25px;
	}
	.form input[type=button]{
		width:75px;
		height: 25px;
	}
</style>
</head>
	<body>
		<div class="top"><div class="top-left"></div><div class="top-right"></div></div><div class="separator"></div>
		<div class="main">
			<form class="form" action="../servlet/addshopServlet" method="post">
			<p><span>商  店  名:</span><input type="text" name="shopname" ></p>
			<p><span>商店描述:</span></p><textarea name="shopdesc" rows="10" cols="40"></textarea>
			<p>
				&nbsp;<input type="submit" value="确定">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="window.location.href='../jsp/shopindex.jsp'">
			</p>
		</form>
		</div>
	
	</body>
</html>