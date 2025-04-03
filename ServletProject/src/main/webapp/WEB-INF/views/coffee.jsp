<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= request.getParameter("orderer") %>님의 주문 결과</title>
</head>
<body>
	<h1>주문자명 : <%= request.getParameter("orderer") %></h1>
	<h3>주문한 커피 : 
		<%-- 선택한 커피의 타입에 따라 상태를 나타내는 형용사 추가 --%>
		<% if(request.getParameter("type").equals("ice")) { %>
			차가운
		<% } else if(request.getParameter("type").equals("hot")) { %>
			뜨거운
		<% } %>
		<%= request.getParameter("coffee") %>
	</h3>
	
	<% if(request.getParameterValues("opt")!=null) { %>	
	<ul>
		<% for(String opt : request.getParameterValues("opt")) { %>
			<li><%= opt %></li>
		<% } %>
	</ul>
	<% } %>

</body>
</html>