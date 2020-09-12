<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, model.Vegetable" %>
<%
Map<String, Vegetable[]> basket = (Map<String, Vegetable[]>) session.getAttribute("basket");
int sum = 0;
for(Vegetable[] vegBox : basket.values()) {
	sum += vegBox[0].getPrice() * vegBox.length;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/confirm.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Sawarabi+Mincho" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	</header>
	<main>
		<div class="contents">
		<h1>お客様情報入力</h1>
			<div class="contents-container">
				<div>
					<form action="/ecSiteSample/Thanks" method="post">
						<input type="hidden" name="sum" value="<%= sum %>">
						<p><label>お名前<br>
						<input type="text" name="name" required></label></p>
						<p><label>メールアドレス<br>
						<input type="email" name="mail" required></label></p>
						<p><label>電話番号<br>
						<input type="tel" name="phone" required></label></p>
						<p><label>住所<br>
						<input type="text" name="address" required></label></p>
						<p><input type="submit" value="注文を確定する"></p>
					</form>
				</div>
				<div>
					<h2>ご注文内容</h2>
					<ul>
					<%
						for(Vegetable[] vegBox : basket.values()) {
					%>
						<li><%= vegBox[0].getName() + "： " + vegBox.length + "個" %></li>
					<%
						}
					%>
					</ul>
					<p class="sum"><%= "合計金額  ¥" + sum %></p>
				</div>
			</div>
		</div>
	</main>
</body>
</html>