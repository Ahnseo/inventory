<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MY_INVENTORY</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<h1>상품목록</h1>

	<div>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">상품명</th>
					<th scope="col">가격(원)</th>
					<th scope="col">진열대</th>
					<th scope="col">진열대 서랍1</th>
					<th scope="col">진열대 서랍2</th>
					<th scope="col">진열대 포스</th>
					<th scope="col">진열대 음료</th>
					<th scope="col">총 수량</th>
				</tr>
			</thead>
			<tbody>	
				<%-- Product 클래스, 자바빈 필요 --%>
				<c:forEach items="${productList }" var="product" varStatus="st">
					<tr>
						<td>${st.count }</td>
						<th>${product.productName }</th>
						<td>${product.price }</td>
						<td>${product.mainStorage }</td>
						<td>${product.subStorage1 }</td>
						<td>${product.subStorage2 }</td>
						<td>${product.posStorage }</td>
						<td>${product.drinkStorage }</td>
						<th>${product.sum }</th>
						

					</tr>
				</c:forEach>	
			</tbody>
		</table>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>