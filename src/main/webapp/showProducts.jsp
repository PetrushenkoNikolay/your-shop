<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="product.Product"%>
<%@ page import ="dataBaseManager.DataBaseManager"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	HttpSession sess = request.getSession();
	ArrayList<Product> list = (ArrayList<Product>)sess.getAttribute("list");
	if (list==null) {
		list = new DataBaseManager().getProducts(new Product());
	}
	if (list.isEmpty()) {
		out.println("<p style='height:50px;'>Не найдено товаров по указанным критериям<p>");
	} else {
		for (int i=0; i<list.size();i++) {
			Product prod = list.get(i);
			out.println("<p style='height:150px;'>");
    		out.println("<img src='images/"+prod.getId()+".jpg' alt='here is must be picture' style='height:150px; width:150px; float:left; padding-right:10px;'/>");
    		out.println("Категория транспортного средства: "+"<b>"+prod.getName()+"</b>"+"<br>");
    		out.println("Марка транспортного средства: "+"<b>"+prod.getBrand()+"</b>"+"<br>");
    		out.println("Цена: "+"<b>"+prod.getPrice()+"</b>"+"<br>");
    		out.println("Цвет транспортного средства: "+"<b>"+prod.getColor()+"</b>"+"<br>");
    		out.println("Описание: "+prod.getDescription());
    		out.println("<hr>");
    		out.println("</p>");
		}
	}
%>
<script type="text/javascript" src="scripts/scripts.js"></script>
</body>
</html>