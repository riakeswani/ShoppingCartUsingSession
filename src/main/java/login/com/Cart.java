package login.com;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Items;
import admin.com.AddItems;

public class Cart extends HttpServlet
{
	
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		PrintWriter writer = resp.getWriter();
		String product=(String) req.getParameter("key");
	
		
		Map<String, Double> items;
		
		//System.out.println(items.get(product));
		ServletContext context = getServletContext();
		items=(Map<String, Double>) context.getAttribute("product_item");
		System.out.println(items);
		Double price = items.get(product);
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("cart") == null)
		{
			session.setAttribute("cart", new HashMap());
		}
		
		Map<String,Items> cart = (Map<String, Items>) session.getAttribute("cart");
		
		if(!cart.containsKey(product))
		{
			cart.put(product, new Items( product,  price, 1));
		}
		else
		{
			Items item = cart.get(product);
			item.quantity++;
		}
		
		/*List<Items> cart= (List<Items>)session.getAttribute("cart");
		
		cart.add(new Items(product,price));
		System.out.println(cart);*/
		resp.sendRedirect("Display.jsp");
		
		writer.println("<br>");
		writer.println("<br>");
		writer.println("<br>");
		writer.print("<a href='Display.jsp'>Add_Items</a>");
		
		writer.print("<a href='logout'>Logout</a>");
		
	
		/*resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		writer.println("Added items in cart");
		writer.println("<br>");
		writer.println("<br>");
		HttpSession session= req.getSession();
		
		 
		List<Items> cart = (List<Items>) session.getAttribute("cart");
		
		for(Items list:cart)
		{
			writer.println("Product:-"+list.getProduct_name());
			
			writer.println("     Price:-"+list.getPrice());
			writer.println("</br>");
			writer.println("</br>");
		}
		
		writer.println("<br>");
		writer.println("<br>");
		writer.println("<br>");
		
		writer.println("<a href='Login.html'>LOGIN</a> &nbsp;&nbsp;&nbsp;&nbsp;");
		
		writer.print("<a href='AddItems.html'>ADD_ITEMS</a>&nbsp;&nbsp;&nbsp;&nbsp;");
		
		writer.print("<a href='logout'>LOGOUT</a>");*/
		
	}
}
