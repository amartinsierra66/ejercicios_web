<%@page import="model.Perfil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	<%Perfil perfil=(Perfil)request.getAttribute("perfil"); %>
	<h1>Bienvenido sr/a <%=perfil.getUsuario() %> a mi página</h1>
	<h2>Dirección de correo: <%=perfil.getEmail() %></h2>
	<h2>Edad: <%=perfil.getEdad() %></h2>
	--%>
	<h1>Bienvenido sr/a ${requestScope.perfil.usuario} a mi página</h1>
	<h2>Dirección de correo: ${requestScope.perfil.email}</h2>
	<h2>Edad: ${requestScope.perfil.edad}</h2>
	
	<a href="login.html">volver</a>
	
</body>
</html>