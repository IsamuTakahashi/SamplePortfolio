<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Order, java.util.Map" %>
<%
Order order = (Order) request.getAttribute("order");

int count = 0;
int quantity = 0;
Map<String, Integer> orderQuantity = order.getOrderQuantity();
for(Map.Entry<String, Integer> entry : orderQuantity.entrySet()) {
	if(entry.getValue() != 0) {
		count++;
		quantity += entry.getValue();
	}
}
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
			<h2>注文情報</h2>
			<div class="info">
				<div>
					<ul>
						<li>名前：　　<%= order.getName() %>　　様</li>
						<li>住所：　　<%= order.getAddress() %></li>
						<li>電話番号：　　<%= order.getPhone() %></li>
						<li>メール：　　<%= order.getMail() %></li>
						<li>注文日時：　　<%= order.getDate() %></li>
					</ul>
				</div>
				<div>
					<ul id="veggies">
					<li id="sum">合計　　<%= count %>種類　　<%= quantity %>個</li>
					<%
						for(Map.Entry<String, Integer> entry : orderQuantity.entrySet()) {
							if(entry.getValue() != 0) {
					%>

						<li><%= entry.getKey() %>　　<%= entry.getValue() %>個</li>
					<%
							}
						}
					%>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>