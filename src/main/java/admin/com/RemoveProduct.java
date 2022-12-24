package admin.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/removeproduct")
public class RemoveProduct extends HttpServlet
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
		System.out.println("enter");
		 context=getServletContext();
		
		PrintWriter writer = resp.getWriter();
		
		String product_name = req.getParameter("product_name");
	
		HttpSession session= req.getSession(false);
		items=(Map<String, Double>) context.getAttribute("product_item");
		resp.setContentType("text/html");
		//writer.println(items);
		if(items.containsKey(product_name))
		{
			items.remove(product_name);
			session.setAttribute(product_name, items);
			context.setAttribute("product_item", items);
			writer.println("Item Deleted from the Cart");
			req.getRequestDispatcher("Admin_Welcome.html").include(req, resp);
		}
		else
		{
			writer.println("Item doesnot exist");
			writer.println("<a href='Admin_Welcome.html'>Go Back</a>");
		}
		
		
	}
	
}
