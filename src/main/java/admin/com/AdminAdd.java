package admin.com;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Items;

public class AdminAdd extends HttpServlet
{
	private Map<String,Double> items;
	ServletContext context;
	
	public void init()
	{
		this.items=AddItems.getItems();
		this.context=getServletContext();
		this.context.setAttribute("product_item",items);
	}
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		this.context=getServletContext();
		System.out.println(items);
		PrintWriter writer = resp.getWriter();
		
		String product_name = req.getParameter("product_name");
		Double price = Double.parseDouble(req.getParameter("price"));
		HttpSession session= req.getSession(false);
		items=(Map<String, Double>) context.getAttribute("product_item");
		resp.setContentType("text/html");
		if(!items.containsKey(product_name))
		{
			items.put(product_name, price);
			session.setAttribute(product_name, session);
			writer.println("Item Added In the Cart");
			req.getRequestDispatcher("Admin_Welcome.html").include(req,resp);
			
		}
		else
		{
			writer.println("Item already exist");
			req.getRequestDispatcher("Admin_Welcome.html").include(req,resp);
		}
		
		System.out.println(items);
	}
}
