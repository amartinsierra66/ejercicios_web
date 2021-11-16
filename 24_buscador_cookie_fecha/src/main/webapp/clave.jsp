<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<%-- 
<%String fecha="";
Cookie[] cookies=request.getCookies();
if(cookies!=null){
	for(Cookie ck:cookies){
		if(ck.getName().equals("fecha")){
			fecha=ck.getValue();
		}
	}
}
if(!fecha.equals("")){
%>
	<p align="right">
		Fecha de la última búsqueda:<b><%=fecha %></b>
	</p>
<%}%>
--%>
	<p align="right">
		Fecha de la última búsqueda:<b>${!empty cookie.fecha?cookie.fecha.value:"Primera vez"}</b>
	</p>


	<center>
		<h1>Buscador</h1>
		<form action="Buscador" method="post">
			Introduce tema de búsqueda:<input type="text" name="clave"/><br/><br/>
			<input type="submit" value="Buscar"/>
		</form>
	
	</center>
</body>
</html>