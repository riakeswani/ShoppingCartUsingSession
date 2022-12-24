package login.com;

import java.io.IOException;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Items;

public class Remove extends HttpServlet
{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	HttpSession session=req.getSession();
	Map<String,Items> products=(Map<String, Items>) session.getAttribute("cart");
	
	String remove_product = req.getParameter("key");
	System.out.println("remove");
	
	if(products.containsKey(remove_product))
	{
		Items item=products.get(remove_product);
		item.quantity--;
		if(item.quantity==0)
		{
			products.remove(remove_product);
		}
		resp.sendRedirect("Cart.jsp");
	}
	
	}
}
