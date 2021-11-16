<%@page import="service.BuscadorServiceFactory"%>
<%@page import="model.Pagina"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- 
	<%String usuario=(String)session.getAttribute("usuario"); 	
	if(usuario==null){%>
		<script type="text/javascript">
			alert("tu sesión ha caducado");
		</script>
	<%} %>
--%>
	<c:if test="${empty sessionScope.usuario}">
		<script type="text/javascript">
			alert("tu sesión ha caducado");
		</script>
	</c:if>
	<p align="right">
		<b>${sessionScope.usuario}</b><br>
		<%-- <b>Usuarios activos: <%=(Integer)application.getAttribute("activos") %></b>--%>
		<b>Usuarios activos: ${applicationScope.activos}</b>
		
	</p>
	<%-- 
	<%List<Pagina> items=(List<Pagina>)request.getAttribute("lista");
	for(Pagina p:items){%>
		<h1><a href="<%=p.getUrl() %>"><%=p.getTitulo() %></a></h1>
	<%} %>
	--%>
	
	<c:forEach var="p" items="${requestScope.lista}">
		<h1><a href="${p.url}">${p.titulo}</a></h1>	
	</c:forEach>
</body>
</html>