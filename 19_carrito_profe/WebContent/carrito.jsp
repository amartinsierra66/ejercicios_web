<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Producto"%>
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
</head>
<body>
<div class="container">
	<h1>Carrito de productos</h1>
	<br/>
	<%--
		recuperamos el carrito y si existe lo mostramos
	 --%>
	<%List<Producto> productos=(List<Producto>)session.getAttribute("carrito");
	if(productos==null||productos.size()==0){%>
		<%-- request.getRequestDispatcher("sincarrito.jsp").forward(request,response);--%>
		<jsp:forward page="sincarrito.jsp"/>
		
	<%}else{%>
		<table class="table table-striped table-bordered">
			<thead><tr><th></th><th>Nombre</th><th>Precio</th><th>Categoría</th></tr></thead>
			<tbody>
			<%for(int i=0;i<productos.size();i++){ %>
				<tr>
					<td><a href="Eliminar?posicion=<%=i%>">Eliminar</a></td>
					<td><%=productos.get(i).getNombre() %></td>
					<td><%=productos.get(i).getPrecio() %></td>
					<td><%=productos.get(i).getDescripcion() %></td>
				</tr>
			
			<%} %>
			</tbody>
		</table>
			
	<%}%>
	<br/>
	<a href="inicio.html">Inicio</a>
	
</div>	
	
</body>
</html>