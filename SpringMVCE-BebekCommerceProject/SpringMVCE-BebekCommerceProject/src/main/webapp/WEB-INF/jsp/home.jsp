<!DOCTYPE html>
<html>
<head>
<title>ebebek</title>
</head>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="../../assets/css/style.css" type="text/css" rel="stylesheet">

<body>

	<section class="main">
		<div class="product">
			<!--pruduct heading-->
			<div class="p-head">
				<p>Oyuncak Kategorisi</p>
			</div>
		</div>

		<!--box-conteiner-->

		<div class="p-box-container">

			<c:forEach items="${products}" var="product">
				<!--box1-->
				<div class="p-box">
					<div class="p-icon ${product.imageName} "></div>
					<a href="#">${product.name} </a>
					<div><p  class="p-head">${product.details}</p></div>
					<button onclick="window.location.href='/cart/${product.id}'" class="p-button">Sepete Ekle</button>
					<p>${product.price} ₺ </p>	
				</div>
			</c:forEach>


		</div>

	</section>


</body>
</html>

