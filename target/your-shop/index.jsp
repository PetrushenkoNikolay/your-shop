<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Yourshopping</title>
	<link rel="stylesheet" type="text/css" href="styles/ForMainMenu.css">
</head>
<body>
	<ul class="mainMenu">
		<li>Главная</li>
		<li>Доставка</li>
		<li>Оплата</li>
		<li>Акции</li>
		<li>йцк</li>
		<li><span style="font-size: smaller;font-weight: 100;">
			работаем с 8.00 до 20.00</span> +375 44 550 89 83</li>
		<li class="userEnter" style="position: relative; left: 340px;">
			<a href="login.jsp" target="_blank" style="display:block;height:100%;color:white;text-decoration: none;">
				Вход
			</a>
		</li>	
	</ul>
	<div class="searchbar">
		<img src="styles/logo.jpg"alt="logo.jpg" class="logoimage">
		<input type="searchbar" name="searchbar"placeholder="Поиск товаров"id="search">
		<div id="basket">
			<img src="styles/shoping.png" style="height: 30px;vertical-align: middle;">
			Корзина
		</div>
	</div>
	<div  id="productMenu">
		<ul id="productMenuBar">
			<li onclick="showByName('Автомобили')">Автомобили</li>
			<li onclick="showByName('Мотоциклы')">Мотоциклы</li>
			<li onclick="showByName('Катера')">Катера</li>
			<li>Product 4</li>
			<li>Product 5</li>
			<li>Product 6</li>
			<li>Product 7</li>
			<li>Product 8</li>
			<li>Product 9</li>
		</ul> 
	</div>
	<br/>
<div id="productChoice">
Выберите необходимые критерии поиска
	Выберите вид транспорта
		<select id="nameChoice">
			<option></option>
			<option>Автомобили</option>
			<option>Мотоциклы</option>
			<option>Катера</option>
		</select>
	<br><br><br>
		Выберите брэнд
		<select id="brandChoice">
			<option></option>
			<option>Audi</option>
			<option>Mercedes</option>
			<option>BMW</option>
			<option>Volkswagen</option>
			<option>Skoda</option>
			<option>Renault</option>
			<option>Peugeot</option>
			<option>Toyota</option>
			<option>Nissan</option>
			<option>Hundai</option>
			<option>Ducati</option>
			<option>Harley-Davidson</option>
			<option>Honda</option>
			<option>Hors</option>
			<option>Kawasaki</option>
			<option>KTM</option>
			<option>Racer</option>
			<option>Bombardier</option>
			<option>Polaris</option>
		</select>
		<br><br><br>
		Выберите цвет
		<select id="colorChoice">
			<option></option>
			<option>белый</option>
			<option>черный</option>
			<option>красный</option>
			<option>желтый</option>
			<option>синий</option>
			<option>зеленый</option>
			<option>фиолетовый</option>
		</select>
		<br><br><br>
	цена
	<br><br>
	от <input id = "minPrice" type="text"/> до <input id = "maxPrice" type="text">
	<br><br>
	<button onclick="showProducts()">Показать</button>
	<br>
</div>
<div id='showProductsDiv'>
	<iframe id='ifr' src='showProducts.jsp' onload='resizeFrame(this)' scrolling='no' frameborder='no'></iframe>
</div>
<script type="text/javascript" src="scripts/scripts.js"></script>
</body>
</html>