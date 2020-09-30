import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
public class LoginServlet extends HttpServlet {
 
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    String name=req.getParameter("username");  
    String pass=req.getParameter("password");          
    res.setContentType("text/html");  
    
	if(!((name == null) || name.isEmpty()) && !((pass == null) || pass.isEmpty()))
	{
		RequestDispatcher rd = req.getRequestDispatcher("AppServlet");
		rd.forward(req,res);
	}
	
	PrintWriter out = res.getWriter();  
    out.println("<html><head><title>Welcome</title></head><body><h1>Login</h1><br><form>Name:<input type = \"text\" name = \"username\"><br><br>Password:<input type = \"text\" name = \"password\"><br><br><input type = \"submit\" value = \"Submit\"></body></html>");
	out.close();
  }
}
