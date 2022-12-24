package admin.com;

import java.io.IOException
;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;
@WebServlet("/login")
public class Login extends HttpServlet
{
	private Map<String,Double> items;
	ServletContext context;
	public void init()
	{
		this.items=AddItems.getItems();
		this.context=getServletContext();
		this.context.setAttribute("product_item",items);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		String name = req.getParameter("user_name");
		String password = req.getParameter("user_password");
		User user = new User(name,password);
		HttpSession session = req.getSession();
		if(name.equals("Admin") && password.equals("admin123") )
		{
			
			user.isAdmin=true;
			session.setAttribute("User", user);
			writer.println("Admin has successfully loged in");
			resp.sendRedirect("Admin_Welcome.html");
		}
		else
		{
			session.setAttribute("User",user);
			writer.println("Welcome "+name);
			resp.sendRedirect("Welcome.html");
		}
		
	}
}
