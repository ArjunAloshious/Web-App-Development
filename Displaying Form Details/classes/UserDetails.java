import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserDetails extends HttpServlet
{ 
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String name = req.getParameter("username");
		String pass = req.getParameter("passwrd");
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>User Details</title></head><body><br><br><br><br><center>Name : "+name+"</center><br><center>Password : "+pass+"</center></br></br></br></body></html>");
		out.close();
	}
}