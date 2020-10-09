import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AppServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
  {
    res.setContentType("text/html");  
    PrintWriter out = res.getWriter();
    String name=req.getParameter("username");  
    String pass=req.getParameter("password");
	if(name.equals("user") && pass.equals("password"))
	{
		out.print("<html><head><title>Successful Authentication</title></head><body><center><h1>Authentication Page</h1></center></body></html>");  
		RequestDispatcher rd = req.getRequestDispatcher("Success");
		rd.include(req,res);
	}
	else
	{
		out.println("<html><head><title>Authentication Failed</title></head><body><center><h1>Authentication Page</h1></center></body></html>");
		RequestDispatcher rd = req.getRequestDispatcher("Fail");
		rd.include(req,res);
	}
    out.close();  
  }
}
