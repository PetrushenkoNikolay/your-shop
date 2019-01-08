function uploadProduct() {
	var formData = new FormData();
	
	var image = document.getElementById("imageFile").files[0];
	formData.append("file",image);
	
	var prodName = document.getElementById("name").value;
	formData.append("name", prodName);
	
	var prodBrand = document.getElementById("brand").value;
	formData.append("brand", prodBrand);
	
	var prodColor = document.getElementById("color").value;
	formData.append("color", prodColor);
	
	var prodDescription = document.getElementById("description").value;
	formData.append("description", prodDescription);
	
	var prodPrice = document.getElementById("price").value;
	formData.append("price", prodPrice);
	
	var xhr = new XMLHttpRequest();
	xhr.open("post","UploadImageServlet",true);
	xhr.send(formData);
	alert('Дождитесь сообщения о загрузке');
	xhr.onreadystatechange = function () {
		if (xhr.readyState!=4) return;
		alert(xhr.responseText);
	}
}
function showProducts() {
	
	var name = document.getElementById("nameChoice").value;
	var brand = document.getElementById("brandChoice").value;
	var color = document.getElementById("colorChoice").value;
	var minPrice = document.getElementById("minPrice").value;
	var maxPrice = document.getElementById("maxPrice").value;
	var params = 'name='+encodeURIComponent(name)+
	'&brand='+encodeURIComponent(brand)+
	'&color='+encodeURIComponent(color)+
	'&minPrice='+encodeURIComponent(minPrice)+
	'&maxPrice='+encodeURIComponent(maxPrice);
	var xhr = new XMLHttpRequest();
	xhr.open('get','ShowProductsServlet?'+params, true);
	xhr.send();
	xhr.onreadystatechange = function () {
		if (xhr.readyState !=4) return;
		if (xhr.status == 200) {
			var ifrDiv = document.getElementById('showProductsDiv');
			ifrDiv.innerHTML = xhr.responseText;
		}
	}	
}
function resizeFrame(iframe) {
	iframe.height = iframe.contentWindow.document.body.scrollHeight + "px";
}
function showByName(name) {
	xhr = new XMLHttpRequest();
	var param = 'name='+encodeURIComponent(name);
	xhr.open("get",'ShowProductsServlet?'+param,true);
	xhr.send();
	xhr.onreadystatechange = function () {
		if (xhr.readyState !=4) return;
		if (xhr.status == 200) {
			var ifrDiv = document.getElementById('showProductsDiv');
			ifrDiv.innerHTML = xhr.responseText;
		}
	}	
}