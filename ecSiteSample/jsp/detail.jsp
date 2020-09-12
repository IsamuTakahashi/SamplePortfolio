<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Vegetable" %>
<%
Vegetable veg = (Vegetable) request.getAttribute("veg");
String name = veg.getName();
String taste = veg.getTaste();
String season = veg.getSeason();
int price = veg.getPrice();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/detail.css" rel="stylesheet">
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
				<div>
					<ul>
						<li><p><%= name %></p></li>
						<li><p><%= taste %></p></li>
						<li><p><%= season %></p></li>
						<li><p><%= price + "円" %></p></li>
					</ul>
				</div>
				<div><img src="images/<%= name + ".png" %>"></div>
			</div>
			<div class="choice">
				<div>
					<h2>数量を選択してください。</h2>
					<form action="/ecSiteSample/Basket?vegName" method="get">
						<input type="hidden" name="vegName" value=<%= name %>>
						<label for="quantity">1個100g</label><br>
						<select name="quantity" id="quantity">
							<option value="1">1個</option>
							<option value="2">2個</option>
							<option value="3">3個</option>
							<option value="4">4個</option>
							<option value="5">5個</option>
						</select>
						<p class="submit"><input type="submit" value="カートに入れる"></p>
					</form>
				</div>
			</div>
		</div>
	</main>
</body>
</html>