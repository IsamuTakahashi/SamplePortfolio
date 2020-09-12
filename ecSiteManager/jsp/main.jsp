 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.List, model.Order, java.util.Date, java.text.SimpleDateFormat,
 java.time.LocalDateTime, java.time.format.DateTimeFormatter" %>
 <%
 List<Order> list = (List<Order>) request.getAttribute("list");
 String label = (String) request.getAttribute("label");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<div class="contents">
		<jsp:include page="/WEB-INF/jsp/header.jsp"/>
		<div class="container">
			<h2><%= label %></h2>
			<div>
				<ul class="orderlist">
				<%
					for(Order order : list) {
				%>
				<li>
					<a href="/ecSiteManager/OrderInfo?id=<%= order.getId() %>">
					<%= order.getDate() + "　　　" + order.getAddress() + "　　" + order.getName() + "　様　　" %>
					</a>
				</li>
				<%
					}
				%>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>