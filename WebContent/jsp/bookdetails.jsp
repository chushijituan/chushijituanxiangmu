<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>商品详情</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bookdetails.css"   type="text/css"/>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-3.0.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/bookdetails.js"></script>
</head>
<body>
	<div id="main">
		<div id="top">
			${detailsbook.bname }
		
		</div>
		
		<div id="intro">
		
		
		
			<div id="left">
				<div id="picture">
				
				</div>
				
				<div id="pbuttom">
					${detailsbook.press }
				</div>
			
			
			</div>
			
			<div id="right">
				<div id="rmes">
					<div id="bcurrprice">
						现价：${detailsbook.currprice }元
					
					</div>
					
					<div id="bprice">
						原价：：${detailsbook.price }元
					
					</div>
					<div id="bdiscount">
						折扣：：${detailsbook.discount }折
					
					</div>
					<div id="bauthor">
						作者：：${detailsbook.author }
					
					</div>
					<div id="bpublictime">
						发布时间：${detailsbook.publishtime }
					
					</div>
				
					
				
				
				</div>
				<div id="rbuy">
				
					<form action=""  name="buyform">
						数量：<input type="text" id="buynum"  name="num" />&nbsp;本&nbsp;
						<input type="button"  id="jrgwc" value="加入购物车"  onclick="checknum()">
						<input type="hidden" id="bid" value="${detailsbook.bid }">
						
					</form>
				
					
				
				
				</div>
			
			
			</div>
		
		
		</div>
		
	
	
	
	
	
	</div>

</body>
</html>