<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map,model.Vegetable" %>
<%
Map<String, Vegetable[]> basket = (Map<String,Vegetable[]>) session.getAttribute("basket");
int sum = 0;
for(Vegetable[] vegBox : basket.values()) {
	sum += vegBox[0].getPrice() * vegBox.length;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/basket.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Sawarabi+Mincho" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	</header>
	<main>
		<div class="contents">
			<div class="contents-container">
				<p class="price"><%= "合計金額  ¥" + sum  %></p>
				<%
				for(Vegetable[] vegBox : basket.values()) {
				%>
				<div class="item-container">
					<div class="image"><img src="images/<%= vegBox[0].getName() + ".png" %>"></div>
					<div class="desc">
						<ul>
							<li><%= vegBox[0].getName() %></li>
							<li><%= vegBox.length + "個" %></li>
							<li><%= vegBox[0].getPrice() * vegBox.length + "円" %></li>
						</ul>
					</div>
					<div class="cancel">
						<form action="/ecSiteSample/Cancel" method="get">
							<input type="hidden" name="vegName" value=<%= vegBox[0].getName() %>>
							<input type="submit" value="取消">
						</form>
					</div>
				</div>
				<% } %>
				<div class="form">
					<form action="/ecSiteSample/Confirm" method="get">
						<p><input type="submit" value="注文する"></p>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>