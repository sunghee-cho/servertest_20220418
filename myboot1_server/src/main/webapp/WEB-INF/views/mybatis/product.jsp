<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="resources/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		//jquery code
	});
</script>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h3>
코드:${productdto.productCode }<br>
제품이름:${productdto.productName }<br>
가격:${productdto.price }<br>
회사명:${productdto.company }<br>
수량:${productdto.balance }<br>
입고일:${productdto.regdate }<br>
</h3>
</body>
</html>