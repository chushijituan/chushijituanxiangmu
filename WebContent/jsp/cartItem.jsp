<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<script type="text/javascript" src="../js/jquery-3.0.0.js"></script>
<script type="text/javascript">
var flag=0;
	//全选
	function ChkAllClick(sonName, cbAllId){ 
		
		
	
		
		flag++;
		var arrSon = document.getElementsByName(sonName); 
		var cbAll = document.getElementById(cbAllId); 
		
		
		for(i=0;i<arrSon.length;i++) { 
			if(flag%2==1){
			 
				arrSon[i].click(); 
			}else{
				arrSon[i].selected=false;
			}
		}
	}
	//加减按钮
	$.each($('input[class*=text_box]'),function(i,t){
		subtotal($(t));
	});
	function setTotal(){
		var s=0; 
		$("#tab .subtotal").each(function(){
		
			if($(this).parent().siblings("#firsttd").find("input").is(':checked')){
				s+=parseFloat($(this).html()); 
			}
		});
		$("#total").html(s.toFixed(1));
	}
	$(function(){
		
		$.each($('.subtotal'),function(){
			
			$(this).html(parseFloat($(this).parent().prev().find('.price').html())*parseFloat($(this).parent().prev().prev().find('.text_box').val()));
		});
		
		var sum=0;
		$('.subtotal').each(function(){
			sum+=parseFloat($(this).html());
		});
		$('#total').html(sum);
		
		$(".add").click(function(){
			var t=$(this).parent().find('input[class*=text_box]');
			t.val(parseInt(t.val())+1);
			if(isNaN(t.val())){
				t.val(1);
			}
			subtotal(t)
		});
		$(".min").click(function(){ 
			var t=$(this).parent().find('input[class*=text_box]'); 
			t.val(parseInt(t.val())-1);
			if(parseInt(t.val())<=0 || isNaN(t.val())){ 
				t.val(1);
			}
			subtotal(t);
		});
		$('input[class*=text_box]').keyup(function(){
			var t=$(this);
			t.val(parseInt(t.val()));
			if (isNaN(t.val()) || parseInt(t.val()) <= 0) {
		        t.val(1);
		    }
		    if (t.val(parseInt(t.val())) != t.val()) {
		        t.val(parseInt(t.val()));
		    }
		    subtotal(t);
		});
		function subtotal(sum){
			var subtotal=0;
			subtotal=(parseFloat(sum.parent().siblings('.price').find('.price').html()))*parseInt(sum.val());
			sum.parent().siblings('.subprice').find('.subtotal').html(subtotal.toFixed(2));
		
			setTotal();
		}
		setTotal();
	});
	
	function onupdatenum(){
		
		var selectedId=$('input:checkbox:checked');
		
		
		if(selectedId.length==0){
			alert("请选中条目");
			
		}else{
			
			var path="../servlet/CartItemOnUpdateNumServlet";
			
			selectedId.each(function(i) {
				var id;
				var num;
				
				id=$(this).val();
				num=$('#'+id).val();
				if(i==0){
					path=path+"?bookidonlist="+id+"&booknumList="+num;
				}else{
					path=path+"&bookidonlist="+id+"&booknumList="+num;
				}
				
				
				
				
			});
			
			location.href=path;
		}
		
		
	}
	
	
</script>
<style type="text/css">
	#cartall{
		width: 1000px;
		height: 1000px;
		margin: 0px auto;
	}
	
	#carttop{
		width: 900px;
		height: 90px;
		margin: 0px auto;
	}
	
	#carthead{
		width: 800px;
		height: 1000px;
		margin: 10px auto;
	}
	
	#cartboday{
		width: 800px;
		height: 50px;
		margin: 10px auto;
	}
	
	#cartbott{
		margin: 10px auto;
	}
	
	#cart1{
		width:800px;
		height: 50px;
		font-style: normal;
	}
	
	#topfont{
		font-size: x-large;
		font-style: oblique;
	}
</style>
</head>
<body>
	<!-- 第一层DIV -->
	<div id="cartall">
		<!-- 第二层DIV -->
		<div id="carttop">
			<!-- 第一个表格 -->
			<table rules="none" width="200px" >
				<tr>
					<td><img src="../img/cartlogo_png/cartlogo.png"></td>
					<td><h3>BooksMall</h3></td>
				</tr>
			</table>
			<!-- 第一个表格结束 -->
		</div>
		<!-- 第二层DIV结束 -->
			<!-- 第三层DIV -->
			<div id="carthead">
			<form action="../servlet/CartItemDeleteBookServlet" method="get" name="bidlistall">
				<!-- 第二个表格 -->
				<table id="cart1" align="center" border="1" rules="none">
					<tr>
						<th colspan="2" align="left">&nbsp;&nbsp;&nbsp;用户&nbsp;:&nbsp;&nbsp;&nbsp;${user.loginname }</th>
						<th colspan="3" align="right">您的购物车&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</th>
					</tr>
				</table>
				<!-- 第二个表格 结束-->
				<!-- 第三个表格 -->
				<table align="center"  border="1" rules="none" id="cartboday">
					<tr>
						<th valign="middle" align="left">&nbsp;&nbsp;&nbsp;<input name="chkAll" id="chkAll" title="全选" onClick="ChkAllClick('bookidonlist','chkAll')" type="button" value="全选"/></th>
						<th valign="middle" align="left">商品信息</th>
						<th valign="middle" align="center">数量</th>
						<th valign="middle" align="center">单价</th>
						<th valign="middle" align="center">小计</th>
						<th valign="middle" align="center">操作</th>
					</tr>
					<c:forEach items="${cartItemAnBookList }" var="CartItemAnBook">
					<tr id="tab">
							<td valign="middle" id="firsttd">&nbsp;&nbsp;&nbsp;<input type="checkbox" onclick="setTotal()" name="bookidonlist" value="${CartItemAnBook.bid}"></td>
							<td>${CartItemAnBook.bname }</td>
							<td valign="middle" align="center">
								<input class="min" name="" type="button" value="-" /> 
								<input class="text_box" name="booknumList" type="text" value="${CartItemAnBook.quantity}" size="1px" id="${CartItemAnBook.bid}"/> 
								<input class="add" name="" type="button" value="+" id="but" />
							</td>
							<td valign="middle" align="center" id="price" class="price"><span class="price">${CartItemAnBook.currprice}</span> </td>
							<td valign="middle" align="center" id="price" class="subprice" ><span class="subtotal" >${CartItemAnBook.currprice}</span></td>
							<td valign="middle" align="center"><a href="../servlet/CartItemDelOneBookServlet?bid=${CartItemAnBook.bid}">删除</a></td>
					</tr>
					</c:forEach>
				</table>
				<!-- 第三个表格 结束-->
				<!-- 第四个表格 -->
				
				<table align="center" border="1" rules="none" width="800px" height="50px" id="cartbott">
					<tr>
						<td valign="middle" align="left"><input type="submit" value="删除选中" ></td>
						<td valign="middle" align="right" colspan="3">合计:<label id="total"></label></td>
						<td valign="middle" align="center"><input type="button" name="jiesuan" value="结算" onclick="onupdatenum()"></td>
					</tr>
				</table>
				</form>
				<!-- 第四个表格 结束-->
			</div>
			<!-- 第三层DIV结束 -->
	</div>
	<!-- 第一层DIV结束 -->
</body>
</html>