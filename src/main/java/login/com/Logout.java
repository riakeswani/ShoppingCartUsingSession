package login.com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet
{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();
		
		
		
		String name= req.getParameter("user_name");
		HttpSession session = req.getSession(false);
		
		session.invalidate();
		writer.println("You have sucessfully logged out");
		writer.println("<br>");
		writer.println("<a href='Login.html'>LOGIN</a>");
	}
}
