<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Libro,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
		<%Libro libro=(Libro)request.getAttribute("libro"); %>
		<h2>Título: <%=libro.getTitulo() %></h2><br/>
		<h2>ISBN: <%=libro.getIsbn() %></h2><br/>
		<h2>Temática: <%=libro.getTematica() %></h2><br/>
		
		<br/>
		<a href="inicio.html">Volver</a>
	</center>
</body>
</html>