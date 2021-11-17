
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
				    <tr><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		    	
				    	<c:forEach var="lb" items="${requestScope.libros}">
				    		<tr>
				    			<td>${lb.titulo}</td>
								<td>${lb.autor}</td>
								<td>${lb.precio}</td>								
							</tr>		    	
				    	</c:forEach>
				</table>
				
				<br/><br/>
				
			
		<br/><br/>
	</center>
<a href="Controller?option=doTemas">Otro tema</a>
</body>
</html>