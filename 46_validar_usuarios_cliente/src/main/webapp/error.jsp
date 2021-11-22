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
	<%String user=request.getParameter("user");
	String pwd=request.getParameter("pwd");%>
	<h1>El usuario <%=user %>  con contraseña <%=pwd %> no es válido</h1>
--%>
<h1>El usuario ${param.user }  con contraseña ${param.pwd} no es válido</h1>
	<br>
	<a href="login.html">Volver</a>
</body>
</html>