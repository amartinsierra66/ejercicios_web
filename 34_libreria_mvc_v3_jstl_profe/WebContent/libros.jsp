
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	
	%>
<%@page import="model.Libro,model.Cliente"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<p align="right">
		Bienvenido:${sessionScope.cliente.usuario}
	</p>
	<center>
		
		<br/><br/>
		
		 <h1>Lista de libros del tema: ${requestScope.tema}</h1>   
		 
				<table border="1">
				    <tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>		    	
				    	<c:forEach var="lb" items="${requestScope.libros}">
				    		<tr>
				    			<td>${lb.titulo}</td>
								<td>${lb.autor}</td>
								<td>${lb.precio}</td>
								<td><a href="Controller?idTema=${param.idTema}&option=doAgregarCarrito&isbn=${lb.isbn}">Comprar</a></td>								
							</tr>		    	
				    	</c:forEach>
				</table>
				
				<br/><br/>
				<h1>Carrito </h1>
		<c:if test="${!empty sessionScope.carrito}">
			<table border="1">
			    <tr><th>Titulo</th><th>Autor</th><th>Precio</th><th></th></tr>		    	
			    	<c:forEach var="carro" items="${sessionScope.carrito}" varStatus="s">
			    		<tr>
			    			<td>${carro.titulo}</td>
							<td>${carro.autor}</td>
							<td>${carro.precio}</td>
							<td><a href="Controller?idTema=${param.idTema}&option=doEliminarCarrito&pos=${s.index}">Eliminar</a></td>
						</tr>		    	
			    	</c:forEach>
			</table>
		</c:if>
		<br><br>
			<a href="Controller?option=doProcesarCompra">Procesar compra</a>
		<br/><br/>
	</center>
<a href="Controller?option=doTemas">Otro tema</a>
</body>
</html>