<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行支付</title>
</head>
<body>
	<form action="/BookMallProject/servlet/BuyServlet" method="post">
	
	选择银行：<br/>
	<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C"/>工商银行
	<img src="/BookMallProject/img/bank_img/icbc.bmp" align="middle"/>
	
	<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
	<img src="/BookMallProject/img/bank_img/bc.bmp" align="middle"/><br/><br/>
	
	<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
	<img src="/BookMallProject/img/bank_img/abc.bmp" align="middle"/>
	
	<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
	<img src="/BookMallProject/img/bank_img/ccb.bmp" align="middle"/><br/><br/>
	
	<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
	<img src="/BookMallProject/img/bank_img/bcc.bmp" align="middle"/><br/>
	
	<input type="submit" value="确认支付"/>
</form>



		

</body>
</html>