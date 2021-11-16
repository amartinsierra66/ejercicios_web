<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Producto"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<meta http-equiv="cache-control" content="max-age=0" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="pragma" content="no-cache" />

</head>
<body>
<div class="container">
	<h1>Carrito de productos</h1>
	
	<p align="right">
		<a href="Desconexion">Desconectar</a>
	</p>
	<br/>
	<%--
		recuperamos el carrito y si existe lo mostramos
	 --%>
	 <c:choose>
		<c:when test="${empty sessionScope.carrito}">
			<%-- request.getRequestDispatcher("sincarrito.jsp").forward(request,response);--%>
			<jsp:forward page="sincarrito.jsp"/>
		</c:when>	
		<c:otherwise>
			<table class="table table-striped table-bordered">
				<thead><tr><th></th><th>Nombre</th><th>Precio</th><th>Categoría</th></tr></thead>
				<tbody>
				<c:forEach var="p" items="${sessionScope.carrito}" varStatus="est">
					<tr>
						<td><a href="Eliminar?posicion=${est.index}">Eliminar</a></td>
						<td>${p.nombre}</td>
						<td>${p.precio}</td>
						<td>${p.descripcion}</td>
					</tr>
				
				</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	<br/>
	<a href="inicio.html">Inicio</a>
	
</div>	
	
</body>
</html>