function check(){	
		var xmlHttp=window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.xmlHttp");
		xmlHttp.open("post","../servlet/AjaxChecksNameServlet?sname="+frm.sname.value,true);
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded charset='UTF-8'");
		xmlHttp.send(null);
		xmlHttp.onreadystatechange=function(){
			if(xmlHttp.readyState == 4 &&  xmlHttp.status == 200){
				if(xmlHttp.responseText=="true"){
				document.getElementById("snameerror").innerHTML="用户名已存在 ";
			}else{
				if(document.getElementById("sname").value!=""){
					document.getElementById("snameerror").innerHTML="用户名可用";
				}else{
					document.getElementById("snameerror").innerHTML="用户名不能为空";
					
				}
			}
			}
				
		}
	}
function checkUphone(){
	var reg = /^\d+$/;
	if(isNaN(frm.sphone.value)){
		document.getElementById("sphoneerror").innerHTML="手机号只能为数字";
		return;
	}else{
		document.getElementById("sphoneerror").innerHTML="";
		return;
		
	}	
}
function checksidentification(obj){
	   var re = /^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/;
	   if(re.test(obj.value)){
		   document.getElementById("sidentificationerror").innerHTML="";
		   return;
	   }else{
		   document.getElementById("sidentificationerror").innerHTML="身份证格式错误";
		   return;
	   }
	}
function checkEmail(obj){
	//alert(obj.value);
   var re = /^[A-Za-z\d]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/ ;
   if(re.test(obj.value)){
	   document.getElementById("semailerror").innerHTML="";
	   return;
   }else{
	   document.getElementById("semailerror").innerHTML="邮箱格式错误";
	   return;
   }
}

