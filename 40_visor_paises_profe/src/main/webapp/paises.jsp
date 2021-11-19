
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	
	%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<html>
<head>
<title>libros</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	<center>
		
		<br/><br/>
		<h1>Seleccione Continente</h1>
            <br/>
		<form action="FrontController?option=doPaises" method="post">
			<select name="continente">
				<c:forEach var="c" items="${requestScope.continentes}">
					<option value="${c}">${c}</option>				
				</c:forEach>
				
			</select>
			<br/><br/>
			<input type="submit" value="Ver paises"/>
		</form>	
		<c:if test="${!empty requestScope.paises}">
		 	<h1>Habitantes de ${param.continente}: ${requestScope.habitantes}</h1>   
		 
				<table border="1">
				    <tr><th>Pais</th><th>Capital</th><th>Habitantes</th></tr>		    	
				    	<c:forEach var="p" items="${requestScope.paises}">
				    		<tr>
				    			<td>${p.nombre}</td>
								<td>${p.capital}</td>
								<td>${p.habitantes}</td>
								
							</tr>		    	
				    	</c:forEach>
				</table>
				
				<br/><br/>
		</c:if>		
</body>
</html>