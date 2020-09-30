import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Success extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    res.setContentType("text/html");  
    PrintWriter out = res.getWriter();
	String name=req.getParameter("username");  
    String pass=req.getParameter("password");
	out.print("<html><head><title>Successful Authentication</title></head><body><center><h1>Authentication Status : Successful</h1><h3><br>Name: "+name+"<br><br>Password: "+pass+"</h3><center></body></html>"); 	
	out.close();  
  }
}