<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객체 범위 확인 페이지</title>
</head>
<body>
	<p>pageScope : ${pageValue}</p>
	<p>requestScope : ${requestValue}</p>
	<p>sessionScope : ${sessionValue}</p>
	<p>applicationScope : ${applicationValue}</p>
	
</body>
</html>