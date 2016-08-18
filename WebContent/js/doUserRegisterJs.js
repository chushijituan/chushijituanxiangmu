function check(){	
		var xmlHttp=window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.xmlHttp");
		//var xmlHttp=window.XMLHttpRequset?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHttp");
		xmlHttp.open("post","../servlet/AjaxCheckloginNameServlet?loginname="+frm.loginname.value,true);
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded charset='UTF-8'");
		xmlHttp.send(null);
		xmlHttp.onreadystatechange=function(){
			if(xmlHttp.readyState == 4 &&  xmlHttp.status == 200){
				if(xmlHttp.responseText=="true"){
				document.getElementById("loginnameerror").innerHTML="用户名已存在 ";
			}else{
				if(document.getElementById("loginname").value!=""){
					document.getElementById("loginnameerror").innerHTML="用户名可用";
				}else{
					document.getElementById("loginnameerror").innerHTML="用户名不能为空";
					
				}
			}
			}
				
		}
	}
function checkUphone(){
	var reg = /^\d+$/;
	if(isNaN(frm.uphone.value)){
		document.getElementById("uphoneerror").innerHTML="手机号只能为数字";
		return;
	}
}
function checkEmail(obj){
	//alert(obj.value);
   var re = /^[A-Za-z\d]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+[A-Za-zd]{2,5}$/ ;
   if(re.test(obj.value)){
	   document.getElementById("emailerror").innerHTML="";
	   return;
   }else{
	   document.getElementById("emailerror").innerHTML="邮箱格式错误";
	   return;
   }
}