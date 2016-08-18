function checknum(){
	var reg = /^[1-9]\d*$/;
	
	if(buyform.num.value==null||buyform.num.value==""){
		alert("数量不能为空");
		return;
	}
	
	if(!reg.test(buyform.num.value)){
		alert("数量只能是正整数");
		
		return;
	}
	
	
	
	var bookid=buyform.bid.value;
	var booknum=buyform.buynum.value;
	
	location.href="/BookMallProject/servlet/CartItemInsertBookServlet?bookid="+bookid+"&booknum="+booknum;
	
}