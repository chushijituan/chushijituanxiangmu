function check1(){	
		var xmlHttp=window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.xmlHttp");
		//var xmlHttp=window.XMLHttpRequset?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHttp");
		xmlHttp.open("post","../servlet/AjaxCheckloginpassServlet?loginpass="+frm.loginpass.value,true);
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded charset='UTF-8'");
		xmlHttp.send(null);
		xmlHttp.onreadystatechange=function(){
			if(xmlHttp.readyState == 4 &&  xmlHttp.status == 200){
				if(xmlHttp.responseText=="true"){
				document.getElementById("loginpasserror1").innerHTML="两次密码不一致";
			}else{
				document.getElementById("loginpasserror1").innerHTML="";
			}
			}
				
		}
	}