<%@ page import="admin.com.*,java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% if(session.getAttribute("User")==null)
	{
	response.sendRedirect("Login.html");
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Displaying the items</title>
</head>
<body>
	<%
		ServletContext context= getServletContext();
		
		Map<String,Double> items=(Map<String, Double>) context.getAttribute("product_item");
		/*for(Map.Entry<String,Double> entry : items.entrySet())
		{
			System.out.println("Product_name ="+entry.getKey() + "Price:- "+entry.getValue());
			out.println("Product_name ="+entry.getKey() + ".               Price:- "+entry.getValue());
			out.println("<br>");
		} */
		
	%>
	<table border=1>
		<h1>Items Available</h1>
		<% for(Map.Entry<String,Double> entry : items.entrySet())
		{ %>
			
			<tr>
				<td><%= entry.getKey() %></td>
				<td><%= entry.getValue() %></td>
				
				<td><form method="post" action="cart?key=<%=entry.getKey()%>"><button type="submit">Add</button></form></td>
				
			</tr>
		<%} %>	
		
		
	</table>
	<br><br><br><br><br>
	<a href="Cart.jsp"><b>View Cart</b></a>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="logout"><b>Logout</b></a>
</body>
</html>