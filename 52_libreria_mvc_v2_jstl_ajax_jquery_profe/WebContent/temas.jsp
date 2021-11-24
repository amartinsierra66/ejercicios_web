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

function procesarRespuesta(data){
	
		var tabla="<h1>Libros del tema: "+$("option:selected", $("#idTema")).text()+"</h1><br>"
		tabla+="<table border='1'><tr><th>Titulo</th><th>Autor</th><th>Precio</th></tr>";
		//transforma texto JSON en objeto/array JSON
		
		for(var lb of data){
			tabla+="<tr><td>"+lb.titulo+"</td><td>"+lb.autor+"</td><td>"+lb.precio+"</td></tr>";
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
			
		
			
		<br><br>
		
		<div id="libros">
		
			
		</div>

	
	</center>

</body>
</html>