<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload product page</title>
</head>
<body>
	<p>
		Вы на странице администрирования товара
	</p>
	<p>
		<form id="uploadForm" method="post" enctype="multipart/form-data" onsubmit="uploadProduct()">
			<label>Выберите тип транспорта</label>
			<select id="name">
				<option>Автомобили</option>
				<option>Мотоциклы</option>
				<option>Катера</option>
			</select>
			<br><br><br>
			<label>Выберите брэнд</label>
			<select id="brand">
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
			<label>Выберите цвет</label>
			<select id="color">
				<option>белый</option>
				<option>черный</option>
				<option>красный</option>
				<option>желтый</option>
				<option>синий</option>
				<option>зеленый</option>
				<option>фиолетовый</option>
			</select>
			<br><br><br>
			<label>Введите описание товара</label>
			<br>
			<textarea rows="5" cols="51" id="description" required="required"></textarea>
			<br><br><br>
			<label>Введите стоимость</label>
			<input type="text" id="price" required="required">
			<br><br><br>
			<label>Выберите изображение для загрузки</label>
			<input id="imageFile" type="file" required="required">
			<br><br><br>
			<input type="submit" value="Внести товар">
		</form>
	</p>
	<p>
		<form action="RemoveSessionServlet" method="get">
			<input type="submit" value="Выйти">
		</form>
	</p>
	<script type="text/javascript" src="scripts/scripts.js"></script>
</body>
</html>