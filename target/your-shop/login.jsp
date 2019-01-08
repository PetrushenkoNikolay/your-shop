<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="administration.jsp" method="post">
		Введите логин <input type="text" name="userName" required="required">
		<br>
		<br>
		Введите пароль <input type="password" name="userPassword" required="required">
		<br>
		<br>
		<input type="submit" value="Войти">
	</form>
</body>
</html>