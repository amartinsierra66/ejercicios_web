<%@page import="service.BuscadorServiceFactory"%>
<%@page import="model.Pagina"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%String clave=request.getParameter("clave");
	List<Pagina> items=BuscadorServiceFactory.getBuscadorService().buscar(clave);
	for(Pagina p:items){%>
		<h1><a href="<%=p.getUrl() %>"><%=p.getTitulo() %></a></h1>
	<%} %>
</body>
</html>