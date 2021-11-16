
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	
	%>
<%@page import="model.Libro,model.Cliente"%>
<%@page import="java.util.List"%>
<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<p align="right">
		Bienvenido:<%=((Cliente)session.getAttribute("cliente")).getUsuario() %>
	</p>
	<center>
		
		<br/><br/>
		
		 <h1>Lista de libros del tema: <%=request.getAttribute("tema") %></h1>   
		 <%List<Libro> libros=(List<Libro>)request.getAttribute("libros"); %>
				<table border="1">
				    <tr><th>Titulo</th><th>Autor</th><th>Precio</th></tr>		    	
				    	<%for(Libro lb:libros){ %>
				    		<tr>
				    			<td><%=lb.getTitulo() %></td>
								<td><%=lb.getAutor() %></td>
								<td><%=lb.getPrecio() %></td>
								
							</tr>		    	
				    	<%} %>
				</table>
				
				<br/><br/>
				
			
		<br/><br/>
	</center>
<a href="Controller?option=doTemas">Otro tema</a>
</body>
</html>