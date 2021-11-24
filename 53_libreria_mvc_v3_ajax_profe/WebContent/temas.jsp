<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="model.Cliente"%>
<%@page import="model.Tema"%>
<%@page import="java.util.List"%>
<%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	
	pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>
<title>seleccion</title>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

	function lanzarPeticion(){		
		
		$.get("Controller",{"option":"doLibros","idTema":$("#idTema").val()},function(data,status){
			procesarRespuesta(data);
		});
		
	}
	function guardarCarrito(isbn){
		$.get("Controller",{"option":"doAgregarCarrito","isbn":isbn},function(data,status){
			procesarCarrito(data);
		});
	}
	function eliminarCarrito(pos){
		$.get("Controller",{"option":"doEliminarCarrito","pos":pos},function(data,status){
			procesarCarrito(data);
		});
	}
	function procesarCarrito(data){
		var tabla="<h1>Carrito</h1><br>";
		tabla+="<table border='1'><tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>";
		//transforma texto JSON en objeto/array JSON
		
		for(var i=0;i<data.length;i++){
			tabla+="<tr><td>"+data[i].titulo+"</td><td>"+data[i].autor+"</td><td>"+data[i].precio+"</td><td>";
			tabla+="<a href='#' onclick='eliminarCarrito("+i+")'>Quitar</a></td></tr>";
		}
		tabla+="</table>";
		$("#carrito").html(tabla);
	}
	function procesarRespuesta(data){
		
			var tabla="<h1>Libros del tema: "+$("option:selected", $("#idTema")).text()+"</h1><br>";
			tabla+="<table border='1'><tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>";
			//transforma texto JSON en objeto/array JSON
			
			for(var lb of data){
				tabla+="<tr><td>"+lb.titulo+"</td><td>"+lb.autor+"</td><td>"+lb.precio+"</td><td>";
				tabla+="<a href='#' onclick='guardarCarrito("+lb.isbn+")'>Añadir carrito</a></td></tr>";
			}
			tabla+="</table>";
			$("#libros").html(tabla);
		
	}


</script>
</head>
<body>
	

	
	
	<p align="right">
		Bienvenido:${sessionScope.cliente.usuario}
	</p>
	<center>
            <h1>Seleccione Tema</h1>
            <br/>
		
			<select name="idTema" id="idTema" onchange="lanzarPeticion();">
				<option value="0">-Todos-</option>
				<c:forEach var="t" items="${requestScope.temas}">
					<option value="${t.idTema }">${t.tema}</option>				
				</c:forEach>
				
			</select>
			<br/><br/>
			<div id="libros">
		
			
			</div>
			<br/><br/>
			<div id="carrito">
			
			</div>
			
		

	
	</center>

</body>
</html>