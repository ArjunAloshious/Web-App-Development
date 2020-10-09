import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Fail extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
  {
    res.setContentType("text/html");  
    PrintWriter out = res.getWriter();
    out.print("<html><head><title>Authentication Failed</title></head><body><center><h1>Authentication Status : Failed</h1><center></body></html>"); 	
    out.close();  
  }
}
