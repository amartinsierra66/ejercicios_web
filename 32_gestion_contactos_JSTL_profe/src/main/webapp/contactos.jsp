<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Contacto"%>
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
	<h1>Lista de contactos</h1>
	
	
	<br/>
	<%--
		recuperamos el carrito y si existe lo mostramos
	 --%>
	<%List<Contacto> contactos=(List<Contacto>)request.getAttribute("contactos");%>
		<table class="table table-striped table-bordered">
			<thead><tr><th></th><th>Nombre</th><th>Email</th><th>Edad</th></tr></thead>
			<tbody>
			<%for(Contacto con:contactos){ %>
				<tr>
					<td><a href="FrontController?op=doEliminar&idContacto=<%=con.getIdContacto()%>">Eliminar</a></td>
					<td><%=con.getNombre() %></td>
					<td><%=con.getEmail() %></td>
					<td><%=con.getEdad() %></td>
				</tr>
			
			<%} %>
			</tbody>
		</table>
			
	
	<br/>
	<a href="FrontController?op=toInicio">Inicio</a>
	
</div>	
	
</body>
</html>