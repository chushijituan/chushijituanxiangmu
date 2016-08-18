<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="../css/bootstrap.min.css" rel="stylesheet" />
<title>Insert title here</title>
 <link href="../css/sellerIndex.css" rel="stylesheet" />
<script src="../js/SellerIndexJs.js" type="text/javascript"></script>
<script src="../js/sellerIndex.js"type="text/javascript"></script>
<script src="../js/jquery.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js"type="text/javascript"></script>
</head>
<body>
<div class="header">
        <img class="logo" src="../img/shop_img/logo.png" />
        <ul class="inline">
        	<li>
               <span><a href="../index.jsp" class="loginout">首页</a></span>
        	</li>
            <li>
              <span><a class="loginout" href="../jsp/addshop.jsp">注册商店</a></span>
            </li>
            <li>
              <span><a class="loginout" href="../servlet/toshopindexServlet">进入商店</a></span>
            </li>
            <li>
              <span><a class="loginout" href="../jsp/sellerlogin.jsp">退出</a></span>
            </li>
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
	                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion2" href="#collapseOne">
	                                <img class="left-icon" src="../img/shop_img/5026_settings.png" /><span class="left-title">系统设置</span>
	                            </a>
	                        </div>
	                        <div id="collapseOne" class="accordion-body collapse in">
	                            <div class="accordion-inner">
	                                <span class="left-body font"> 用户管理</span>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	             <div class="content-right">
			      	<div class="form div-center">
				      <form action="../servlet/doUpdateSellerServlet" method="post" id="form1" name="form1">
							<p>
								<span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</span>
									<input type="password" name="spassword" value="${seller.spassword}" disabled id="spassword" onChange="return gd1()"/>
									<input id="radio1" type="radio" name="sfgd" value=1 checked="true"    onclick="gd1()" />
							</p>
							<p>
									<span>确认密码:</span>
										<input type="password" name="spassword1" value="${seller.spassword}" disabled  id="spassword1" onChange="return gd2()" />
										<input id="radio2" type="radio" name="sfgd" value=1 checked="true"    onclick="gd2()" />  
							</p>			
							<p>
									<span>Email：  &nbsp;</span>		
									<input type="text" name="semail" value="${seller.semail}" disabled onChange="return gd3()" id="semail"/>
									<input id="radio3" type="radio" name="sfgd" value=1 checked="true"    onclick="gd3()" />  
							</p>
							<p>
									<span>phone：  &nbsp;</span>
										<input type="text" name="sphone" value="${seller.sphone}" disabled onChange="return gd4()" id="sphone"/>
										<input id="radio4" type="radio" name="sfgd" value=1 checked="true"    onclick="gd4()" />  
							</p>
							<p>
									<input type="submit" name="submit" id="submit" onclick="form1.spassword.disabled=false;form1.spassword1.disabled=false;form1.semail.disabled=false;form1.sphone.disabled=false;" value="保存" />
									<input type="submit" value="取消"/>
							</p>
						</form> 
					</div>
				</div>
            </div>
        </div>
    </div>
</body>
</html>