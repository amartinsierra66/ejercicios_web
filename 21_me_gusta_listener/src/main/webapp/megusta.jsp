<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center><br><br>
	<%Integer contador=(Integer)application.getAttribute("contador");%>
	<h1><%=contador %></h1>
	
	
	<br><br>
	<a href="MeGusta">Me gusta</a>
	</center>
</body>
</html>