<% if(session.getAttribute("User")==null)
	{
	response.sendRedirect("Login.html");
	}%>
<%@ page import="login.com.* , java.util.*,models.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=1>
	<h1>Items added to the cart</h1>
	<% double totalamount =0.0; %>
	<% Map<String,Items> cart = (Map<String, Items>) session.getAttribute("cart");
	out.println("<tr><th>Product_Name</th><th>Price</th><th>Quantity</th><th>Remove_Item</th></tr>");
		if(cart == null)
		{
			out.println("<tr>");
			out.println("<td colspan='3'><h1>Your cart is empty</h1>");
			out.println("<br>");
			
			out.println("<tr><td colspan='3'>TotalAmount:-"+totalamount+"</td>");
		}
		else
		{
		
		for(Items items :cart.values())
		{%>
			
			<tr>
			<td><%=items.product_name%>
			</td><td><%= items.price%></td> 
			<td><%= items.quantity%></td>
			<td>
			<form action="remove?key=<%=items.product_name%> "method='post'><button type='submit' name='remove'>-</button></form>
			</td>
			</tr>
		
			<% 
			totalamount=items.price*items.quantity+totalamount;
			out.println("<br>");
			}
			out.println("<tr><td colspan='3'>TotalAmount:-"+totalamount+"</td>");
			}
		
		
		%>
</table>
	<br><br><br><br><br>
	<a href="Display.jsp"><b>Add_Items</b></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="logout"><b>Logout</b></a>
</body>
</html>