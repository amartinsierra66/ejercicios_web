<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="model.Cliente"%>
<%@page import="model.Tema"%>
<%@page import="java.util.List"%>
<%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	
	pageEncoding="ISO-8859-1" %>
	
<html>
<head>
<title>seleccion</title>
<meta http-equiv="Content-Type" content="text/html;  charset=ISO-8859-1" >
</head>
<body>
	

	
	<%List<Tema> temas=(List<Tema>)request.getAttribute("temas"); %>
	<p align="right">
		Bienvenido:<%=((Cliente)session.getAttribute("cliente")).getUsuario() %>
	</p>
	<center>
            <h1>Seleccione Tema</h1>
            <br/>
		<form action="Controller?option=doLibros" method="post">
			<select name="idTema">
				<option value="0">-Todos-</option>
				<%for(Tema t:temas){ %>
					<option value="<%=t.getIdTema()%>"><%=t.getTema()%></option>				
				<%} %>
				
			</select>
			<br/><br/>
			<input type="submit" value="Libros"/>
		</form>	
			
		

	
	</center>

</body>
</html>