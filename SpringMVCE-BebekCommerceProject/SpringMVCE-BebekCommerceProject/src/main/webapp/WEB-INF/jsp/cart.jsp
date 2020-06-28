<!DOCTYPE html>
<html>
<head>
<title>ebebek</title>
</head>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../../assets/css/styleCart.css" type="text/css"
	rel="stylesheet">
<body>
	<div class="p-box-container">
		<div class="shopping-cart">
			<!-- Title -->
			<div class="title">
				<a href="/">Alışverişe Devam Et</a>
			</div>
			<div class="title">Ürün Listesi</div>

			<c:forEach items="${sessionScope.cart}" var="item">
				<c:set var="total"
					value="${total + item.product.price * item.quantity }"></c:set>

				<!-- Product -->
				<div class="item">

					<div class="p-icon ${item.product.imageName} "></div>

					<div class="description">
						${item.product.name} <span>${item.product.price}₺</span>
					</div>

					<div class="quantity">
						<button onclick="window.location.href='/cart/${item.product.id}'"
							class="plus-btn" type="button" name="button">
							<img src="../../assets/img/plus.svg" alt="" />
						</button>
						<input type="text" name="quantity" value="${item.quantity}">
						<button
							onclick="window.location.href='/cart/decrease/${item.product.id}'"
							class="minus-btn" type="button" name="button">
							<img src="../../assets/img//minus.svg" alt="" />
						</button>
						
					</div>
					<div class="total-price">${item.product.price * item.quantity}₺</div>
				</div>

			</c:forEach>
			
			<div>
					<input type="text" class="total" value="Toplam Fiyat : ${total}₺">
				</div>

		</div>

	</div>
	<!--javascript-->
	<script type="text/javascript" src="../../assets/js/cart.js"></script>
</body>
</html>