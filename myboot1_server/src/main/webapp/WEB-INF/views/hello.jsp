<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("h1").css("color","blue");
		$("#ajaxbtn").on('click', function(){
			$.ajax({
				url:'/helloajax',
				type:'get',
				dataType:'json',
				success:function(result){ //MemberDTO -JSON변환
					$("#result").html(result.id +":" + result.password);
				}
			});
		});
	});
</script>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<img src="images/drinks.jpg">
<h1>${model }</h1>
<input type=button value="ajax요청" id="ajaxbtn">
<div id="result" ></div>
</body>
</html>