<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-3.0.0.js"></script>
<script type="text/javascript" src="../js/ajaxupload.js"></script>
<script type="text/javascript">
$(function(){
	//上传图片
	new AjaxUpload('#addLabProdPic', {
		action: '../servlet/saveimagServlet', 
		name: 'picFile',
		responseType: 'json',
		onSubmit : function(file , ext){
			if (ext && /^(jpg|png|bmp)$/.test(ext.toLowerCase())){
				this.setData({
					'picName': file
				});
			} else {
				alert("请上传格式为 jpg|png|bmp 的图片！");
				return false;				
			}
		},
		onComplete : function(file,response){
			if(response.error) {
				alert(response.error);
				return;
			}
			$('#viewImg').attr('src',response.picUrl);
		}		
	});
});
function check(form) {
	var re=/^(\d{4})-(0\d{1}|1[0-2])-(0\d{1}|[12]\d{1}|3[0-1])$/;  
	if(re.test($('#publishtime').val())==false){
		alert("请输入正确的日期格式(yyyy-MM-dd)");
		return false;
	}
	return true;
}

function getData() {
	var pname = $("#pname").val();  
    $.ajax({          
         url:"../servlet/catechangeServlet",  
         data:{pname : pname},  
         type : "post",    
         cache : false,    
         dataType : "json",   
         error:function(){  
            alert("error occured!!!");  
         },  
         success:function(data){  
         if(data!="0"){  
            var cname = document.getElementById('cname');  
            //清空数组  
            cname.length=0; 
            for(var i=0;i<data.length;i++){  
                 var xValue=data[i].id;    
                 var xText=data[i].name;    
                 var option=new Option(xText,xValue);    
                 cname.add(option);    
            }  
          }else{  
        	  var cname = document.getElementById('cname');  
              //清空数组  
              cname.length=0; 
          }  
       }  
   });  
}
</script>
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
		width: 800px;
		height: 600px;
		margin: auto;
	}
	.main-left{
		width:300px;
		height: 600px;
		float: left;
	}
	.main-right{
		margin-left:10px;
		width: 480px;
		height: 600px;
		float: left;
	}
	.form{
		width:300px;
		height:400px;
		margin:auto;
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
		<div class="main-left">
			<p><img id="viewImg" width="250px" height="300px" src="../img/${book.image }"></p>
		</div>
		<div class="main-right">
			<form class="form" name="form" action="../servlet/updatebookServlet" method="get"  onsubmit="return check(this)">
		
			<p>图书名&nbsp;:<input type="text" name="bname" value="${book.bname }"></p>
			<p>作者&nbsp;&nbsp;:<input type="text" name="author" value="${book.author }"></p>
			<p>价格&nbsp;&nbsp;:<input type="text" name="price" value="${book.price }"></p>
			<p>折扣&nbsp;&nbsp;:<input type="text" name="discount" value="${book.discount }"></p>
			<p>现价&nbsp;&nbsp;:<input type="text" name="currprice" value="${book.currprice }"></p>
			<p>出版社&nbsp;:<input type="text" name="press" value="${book.press }"></p>
			<p>出版时间:<input type="date" name="publishtime" id="publishtime" value="${book.publishtime }"></p>
			<p>种类&nbsp;&nbsp;:
				<select name="pname" id="pname" onchange="getData()">
					<c:forEach items="${listpcate }" var="pcate">
						<c:choose>
							<c:when test="${pcate.cname}==${pcategory.cname} ">
							<option value="${pcate.cname }" selected="selected">${pcate.cname }</option>
							</c:when>
							<c:otherwise>
								<option value="${pcate.cname }">${pcate.cname }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
				<select name="cname" id="cname">
					<c:forEach items="${listccate }" var="ccate">
						<c:choose>
							<c:when test="${ccate.cname}==${ccategory.cname} ">
							<option value="${ccate.cname }" selected="selected">${ccate.cname }</option>
							</c:when>
							<c:otherwise>
								<option value="${ccate.cname }">${ccate.cname }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</p>
			<p>
			图片&nbsp;&nbsp;:<button id="addLabProdPic">选择图片
			</button>
			</p>
			<p><input type="submit" value="修改">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="返回" onclick="window.location.href='../jsp/shopindex.jsp'"><p>
			<p><input type="hidden" name="bid" value="${book.bid }"><p>
		</form>
		</div>
	</div>
</body>
</html>