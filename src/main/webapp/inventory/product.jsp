<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%request.setCharacterEncoding("utf-8");%>

<%-- stock 파일: 사용자로부터 저장되는 입력란 --%>
<%-- 현재 페이지 저장 + forward  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<style type="text/css">
	.navbar{
		margin-left: 30px; 
	}
	.row{
		margin: auto;
	}	
	.containerLeft{	
		width: 30%;
		background: Azure;
		padding: 10px;	
	}
	.containerRight{
		width: 70%;
		background: Azure;
		padding: 10px;
		
	}			
</style>
</head>
<body>
	<%-- 메인페이지 1/3분할 : 상단 , 각각의 페이지 전환 --%>
	<div class="navbar">
		<%-- navbar 로 페이지 전환하기 --%>
		<my:navbar/>
	</div>
	<%--  
	메인페이지 2/3분할 : 좌측세로 ,여러 상품 이름 세로로 저장(스마트폰 드레그 기능까지)
						1.저장하기 만들기, 
						2.저장된 파일을 빠르게 검색하려면? 초성 검색+ 자동완성까지
	--%>
	<div class="row">
		<div class="containerLeft">
			<div style="padding: 10px;">
			
				<h4 style="padding: 10px;">상품 저장 하기</h4>
				
				<form action="<%--경로:현재 페이지--%>" method="post" style="padding-bottom: 20px;">
					<input type="text" name="product" value="" placeholder="상품 이름 입력"
						style="padding-left: 10px; width: 300px; height: 40px;">
						
					<input type="number" name="quantity" value=""
						placeholder="상품 수량 입력"
						style="padding-left: 10px; width: 100px; height: 40px;"> <input
						type="submit" value="저장하기" style="height: 40px;">
				</form>
				
				<% 
				String productName = (String)request.getParameter("product");
				String quantityName = (String)request.getParameter("quantity");
				Integer quantity = 0;
				
				if(quantityName != null && !quantityName.isBlank()){
					quantity = Integer.parseInt(quantityName); 
				}
				
				/*k,v 쌍을 입력 할때마다, 저장시켜야함. */
				Map <String,Integer> map = new HashMap<>();
				map.put(productName, quantity );
				
				request.setAttribute("productAttr", map);
				
				%>
				
				<select class="form-select" size="15"
					aria-label="size 3 select example">
					<option selected>this select menu</option>
					<c:forEach items="${productAttr }" var="item" varStatus="st">
					
						<option value="${st.count }">${item.key }</option>
					</c:forEach>
				</select>
				
			</div>
		</div>
		<%-- 
		메인페이지 3/3분할 : 우측세로 ,여러 상품 이름 이미 출력되어있고,
							0.상품명
			새로운 정보 저장.
							1.최근 저장한날짜/시간 
							2.수량 저장->출력(최신화된 저장값)
							3. 최대한 빠르고 간단하게 수량을 입력하려면 ?
							 -> 숫자쓰거나, 위아래스크롤까지 있거나, 음성인식으로 입력되거나
	 --%>
		<div class="containerRight">
		
			<h4 style="text-align: center;">재고 정보 테이블</h4>
			
			<table class="table">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">상품명</th>
						<th scope="col">진열대</th>
						<th scope="col">서랍1(제과)</th>
						<th scope="col">서랍2(음료)</th>
						<th scope="col">포스 앞</th>
						<th scope="col">음료수 냉장</th>
						<th scope="col">상품 개수 총합</th>
					</tr>
				</thead>
				<tbody class="table-group-divider">
					<c:forEach items="${productAttr }" var="item" begin="0" end="${map.size() }" varStatus="status">
						<tr>
							<td>${status.count }</td>
							<td>${item.key }</td>
							<td>${item.value } 개</td>
							<td>서랍1(제과) 속 상품1의 개수</td>
							<td>서랍2(음료) 속 상품1의 개수</td>
							<td>포스앞 속 상품1의 개수</td>
							<td>음료수냉장 속 상품1의 개수</td>
							<td>상품1의 개수 합</td>						
						</tr>				
					</c:forEach>			
				</tbody>
			</table>
			
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
		crossorigin="anonymous"></script>
</body>
</html>


