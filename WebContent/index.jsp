<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>购书网</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/index.css"   type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.0.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/index.js"></script>
</head>
	<body>

		<div id="top">
			<div id="top_div">
				<div id="welcome">
					欢迎来到购书网
				</div>
				
				<div id="login">
					<c:if test="${user==null }">
						<a id="logina" href="${pageContext.request.contextPath }/jsp/userlogin.jsp">请先登陆!</a>
					</c:if>
					
					<c:if test="${user!=null }">
						欢迎：${user.loginname }
					</c:if>
					
				</div>
				
				
				<div id="register">
					<a id="registera" href="${pageContext.request.contextPath }/jsp/userregister.jsp">注册</a>
					
				</div>
				
				<div id="guanzhu">
					<a id="grxxa" href="${pageContext.request.contextPath }/jsp/comuserinfo.jsp"> 个人信息</a>
					
				</div>
				
				<div id="my_taobao">
					<a id="wddda" href="${pageContext.request.contextPath }/jsp/generate_orderitem.jsp">我的订单</a>
					
				</div>
				
				<div id="gouwuche">
					<a id="gwca" href="${pageContext.request.contextPath }/servlet/CartServlet">购物车</a>
					
				</div>
			</div>
			
		</div>
		<div style="clear:both;height:0px;"></div>
		<div id="head">
			<div id="logo">
				
			</div>
			<div id="extra">
				
			</div>
			<div id="search">
				<div id="search_top">
					<form name="serchform" method="get">
						<p>
							<input type="text" id="txtSearch" name="txtSearch" />
							<input type="button" id="btnsearchbook" value="搜索图书 " onclick="searchbook()" />
						</p>
					</form>
				</div>
				<div id="search_bottom">
					<ul>
						<li><a>魔兽</a></li>
						<li><a>黑白</a></li>
						<li><a>诛仙</a></li>
						<li><a>左耳</a></li>
						<li><a>上瘾</a></li>
						<li><a>幻城</a></li>
						<li><a>异人</a></li>
					</ul>
				</div>
			</div>
		</div>
		
		<div id="main">
			<div id="main_top">
				<div id="items">
					<div id="fenlei">
						商品分类
					</div>
					<div class="item">
						欢迎来到购书网
					</div>
					
					
					
				</div>
			</div>
			<div id="main_center">
				<div id="main_center_body">
					<div id="list_ads">
						<div id="goods_list">

							<div class="good_item" id="1">
								教育
							</div>
							<div class="good_item" id="2">
								小说
							</div>
							<div class="good_item" id="3">
								童书
							</div>
							<div class="good_item" id="4">
								生活
							</div>
							<div class="good_item" id="5">
								科技
							</div>
							<div class="good_item" id="6">
								工具书
							</div>
							
						</div>
						<div id="ads_area">
							<div id="ads">
								
								<!-- 显示列表 -->
								
								<c:forEach items="${books}" var="book"  varStatus="bookindex">
								
									<div id="${bookindex.index }" class="booklist" >
									
									   <div class="bookname">
									   		${book.bname }
									   
									   </div>
										<div class="bookprice">
									   		${book.currprice }元
									   
									   </div>
										
										<div class="bookauthor">
									   		${book.author }
									   
									   </div>
									   
									   
									   <div class="bookpress">
									   		${book.press }
									   
									   </div>
									   
									   
									   <div class="bookpublishtime">
									   		${book.publishtime}
									   
									   </div>
									   
									   <div class="ckxq">
									   		<a href="${pageContext.request.contextPath }/servlet/BookDetailsHeadServlet?bid=${book.bid }">查看详情</a>
									   
									   </div>
									</div>
								
								
								</c:forEach>
								
								<div id="fenye">
									<c:if test="${pageindex>1}">
									
										<c:if test="${searchstyle=='all' }">
										
											<a href="javascript:go(1,'all');">首页</a>
											<a href="javascript:go(${pageindex }-1,'all');">上一页</a>
										
										</c:if>
										
										<c:if test="${searchstyle=='byname' }">
										
											<a href="javascript:go(1,'byname');">首页</a>
											<a href="javascript:go(${pageindex }-1,'byname');">上一页</a>
										
										</c:if>
										
										<c:if test="${searchstyle=='bycategory' }">
										
											<a href="javascript:go(1,'bycategory');">首页</a>
											<a href="javascript:go(${pageindex }-1,'bycategory');">上一页</a>
										
										</c:if>
    									
    			
    								</c:if>
    			
    			
    								<c:if test="${pageindex!=0}">
    								
    									<c:if test="${searchstyle=='all' }">
    										<a href="javascript:go(${pageindex },'all');">${pageindex }</a>
    									</c:if>
    									
    									<c:if test="${searchstyle=='byname' }">
    										<a href="javascript:go(${pageindex },'byname');">${pageindex }</a>
    									</c:if>
    									
    									<c:if test="${searchstyle=='bycategory' }">
    										<a href="javascript:go(${pageindex },'bycategory');">${pageindex }</a>
    									</c:if>
    								
    									
    			
    								</c:if>
    			
    								<c:if test="${pageindex<pagecount}">
    								
    									<c:if test="${searchstyle=='all' }">
    										<a href="javascript:go(${pageindex }+1,'all');">下一页</a>
											<a href="javascript:go(${pagecount },'all');">末页</a>
    									
    									</c:if>
    									
    									<c:if test="${searchstyle=='byname' }">
    										<a href="javascript:go(${pageindex }+1,'byname');">下一页</a>
											<a href="javascript:go(${pagecount },'byname');">末页</a>
    									
    									</c:if>
    									
    									<c:if test="${searchstyle=='bycategory' }">
    										<a href="javascript:go(${pageindex }+1,'bycategory');">下一页</a>
											<a href="javascript:go(${pagecount },'bycategory');">末页</a>
    									
    									</c:if>
    								
    									
    			
    								</c:if>
								
								
								</div>
								
								
								
							</div>
							<div id="adsother">
							
							
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
		
		<div class="whitespace">
			
		</div>	
		
		
		<div id="category1">
			<c:forEach items="${ categorys1}" var="cateitem1">
			
				<a class="ca1" href="${pageContext.request.contextPath }/servlet/IndexBookSearchServlet?pid=1&cid=${cateitem1.cid}&method=searchbycategory">${cateitem1.cname }</a>
			</c:forEach>
    		
    
    	</div>
    	
    	<div id="category2">
		
    		<c:forEach items="${ categorys2}" var="cateitem2">
			
				<a class="ca2" href="${pageContext.request.contextPath }/servlet/IndexBookSearchServlet?pid=2&cid=${cateitem2.cid}&method=searchbycategory">${cateitem2.cname}</a>
			</c:forEach>
    
    	</div>
    	
    	<div id="category3">
		
    		<c:forEach items="${ categorys3}" var="cateitem3">
			
				<a class="ca3" href="${pageContext.request.contextPath }/servlet/IndexBookSearchServlet?pid=3&cid=${cateitem3.cid}&method=searchbycategory">${cateitem3.cname}</a>
			</c:forEach>
    
    	</div>
    	
    	<div id="category4">
			<c:forEach items="${ categorys4}" var="cateitem4">
			
				<a class="ca4" href="${pageContext.request.contextPath }/servlet/IndexBookSearchServlet?pid=4&cid=${cateitem4.cid}&method=searchbycategory">${cateitem4.cname }</a>
			</c:forEach>
    		
    
    	</div>
    	
    	<div id="category5">
		
    		<c:forEach items="${categorys5}" var="cateitem5">
			
				<a class="ca5" href="${pageContext.request.contextPath }/servlet/IndexBookSearchServlet?pid=5&cid=${cateitem5.cid}&method=searchbycategory">${cateitem5.cname }</a>
			</c:forEach>
    
    	</div>
    	
    	<div id="category6">
		
    		<c:forEach items="${categorys6}" var="cateitem6">
			
				<a class="ca6" href="${pageContext.request.contextPath }/servlet/IndexBookSearchServlet?pid=6&cid=${cateitem6.cid}&method=searchbycategory">${cateitem6.cname }</a>
			</c:forEach>
    
    	</div>
		
		
	

	</body>
</html>