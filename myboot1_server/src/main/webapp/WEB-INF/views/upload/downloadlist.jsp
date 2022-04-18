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
<h1> 다운로드 파일 목록을 보여드립니다. </h1>
<c:forEach items="${filearray }" var="f">
<h3> <a href="filedownloadresult?filename=${f}"> ${f } 파일 다운로드 </a></h3>
</c:forEach>


</body>
</html>









