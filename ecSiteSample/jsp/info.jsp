<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Vegetable, java.util.Map" %>
<%
Map<String, Vegetable> veggies = (Map<String, Vegetable>) request.getAttribute("veggies");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/info.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Sawarabi+Mincho" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<header>
		<div>
			<h1 class="logo">ロゴ</h1>
			<h1 class="name">有機野菜　高橋農園</h1>
		</div>
		<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	</header>
	<main>
		<div class="infobox">
			<div class="main">
				<img src="images/オーガニック.png">
			</div>
			<p id="msg">心を込めて作った、安心安全の有機野菜をお届けします</p>
		</div>
		<!-- ①ここから三つのこだわり -->
		<h1 class="title">野菜作りの三つのこだわり</h1>
		<div class="contents">
			<div class="contents-container">
				<div class="float_block_left">
					<h1>土へのこだわり</h1>
					<img src="images/土640 2020-08-31 11.15.54.png" class="float_left">
					<p>something...something...</p>
					<p>something...something...</p>
					<p>something...something...</p>
					<p class="float_clear">サンプル画像</p>
				</div>
				<div class="float_block_right">
					<h1>水へのこだわり</h1>
					<img src="images/水768 2020-08-31 14.27.32.png" class="float_right">
					<p>something...something...</p>
					<p>something...something...</p>
					<p>something...something...</p>
					<p class="float_clear">サンプル画像</p>
				</div>
				<div class="float_block_left">
					<h1>オーガニックへのこだわり</h1>
					<img src="images/野菜640 2020-08-31 17.13.17.png" class="float_left">
					<p>something...something...</p>
					<p>something...something...</p>
					<p>something...something...</p>
					<p class="float_clear">サンプル画像</p>
				</div>
			</div>
		</div>
		<!-- ①三つのこだわりここまで -->
		<!-- ②ここからボックスを並べて表示 -->
		<h1 class="title">高橋農園の野菜たち</h1>
		<div class="contents">
			<ul class="vegetables">
			<% for(Vegetable veg : veggies.values()) { %>
				<li>
					<div>
						<a href="/ecSiteSample/Detail?vegName=<%= veg.getName() %>">
							<img src="images/<%= veg.getName() + ".png" %>">
						</a>
					</div>
					<p><%= veg.getName() %></p>
					<p><%= veg.getSeason() %></p>
					<p><%= veg.getPrice() + "円" %></p>
				</li>
			<% } %>
			</ul>
		</div>
		<!-- ②ボックスを並べて表示ここまで -->
	</main>
</body>
</html>







