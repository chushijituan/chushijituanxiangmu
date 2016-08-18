<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/css/style.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
</head>
<body class="no-js">
          <div class="wrap">
                <div class="logo">
                    <a href="#">
                        <img  width="341" height="68" alt="MY admin | admin">
                    </a>
                </div>
                <div class="social">
                    <a href="../index.jsp">主页</a>
                </div>
                <div class="separator"></div>
            </div>
            <div class="wrap">
                <h1>您好！管理员用户！</h1>
            </div>      
            <div class="wrap">
                <div class="features-columns clearfix">
                    <div class="features-column">
                        <span class="ico-bulb"></span>
                        <h3>用户管理</h3>
                        <p><a href="../servlet/ComuserManagerServlet">点此前往</a></p>
                    </div>
                    <div class="features-column">
                        <span class="ico-rocket"></span>
                        <h3>店铺管理</h3>
                        <p><a href="../servlet/toshopmanagerServlet">点此前往</a></p>
                    </div>
                    <div class="features-column">
                        <span class="ico-flag"></span>
                        <h3>卖家管理</h3>
                        <p><a href="../servlet/SellerManagerServlet">点此前往</a></p>
                    </div>
                </div>
            
            </div>
        
       
</body>
</html>