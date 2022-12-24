<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form >
	
	<%@ page import="models.*" %>
	<% User user=(User)session.getAttribute("User");
			if(user==null)
			{
				
				response.sendRedirect("Login.html");
			}
	%>
	<a href="AddItems.html">ADD_ITEMS</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="cart">CART</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="logout">LOGOUT</a>
		
	</form>
</body>
</html>