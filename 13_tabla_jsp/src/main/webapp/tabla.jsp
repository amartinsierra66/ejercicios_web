<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<table border="1">
			<%for(int i=1;i<=10;i++){ %>
				<tr>
					<%for(int k=1;k<=10;k++){ %>
						<td><%=i*k%></td>
					<%} %>
				
				</tr>
			
			<%} %>
		
		</table>
	</center>
</body>
</html>