<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Libro,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<%List<Libro> libros=(List<Libro>)request.getAttribute("libros"); %>
		<table class="table table-striped table-bordered">
			<thead><tr><th>Titulo</th><th>ISBN</th><th>Temática</th></tr></thead>
			 
			<%for(Libro l:libros){%>
				<tbody>
					<tr>
						<td><%=l.getTitulo() %></td>
						<td><%=l.getIsbn() %></td>
						<td><%=l.getTematica() %></td>
					</tr>
				</tbody>
			<%}%>
			
			<%--
			libros.forEach(l->{out.println("<tbody>");
				out.println("<tr>");
				out.println("<td>"+l.getTitulo()+"</td>");
				out.println("<td>"+l.getIsbn() +"</td>");
				out.println("<td>"+l.getTematica()+"</td>");
				out.println("</tr></tbody>");
			}); 
			--%>
		</table>
		<br/>
		<a href="inicio.html">Volver</a>
	</div>
</body>
</html>