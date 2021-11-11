<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>El libro con ISBN <%=request.getParameter("texto") %> no existe</h1>
	<br>
	<a href="inicio.html">Volver</a>
</body>
</html>