<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<b>Dirección ip: </b><%=request.getRemoteAddr()%><br><br>
	<b>Nombre del equipo: </b><%=request.getRemoteHost()%><br><br>
	<b>Localización: </b><%=request.getLocale().getCountry()%><br><br>
	<%Enumeration<String> nombres=request.getHeaderNames(); %>
	<table border="1">
		<tr><th>Nombre</th><th>Valor</th></tr>
		<%while(nombres.hasMoreElements()){ 
			String nombre=nombres.nextElement();%>
			<tr><td><%=nombre%></td><td><%=request.getHeader(nombre) %></td></tr>
		<%} %>		
	</table>
</center>
</body>
</html>