import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloPost extends HttpServlet
{
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {  
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		String title = "Using Get Method to read Form data";
		  
		out.println
		(
			"<html>\n"+
			"<head>\n"+
			"<title>Servlet Chapter</title>\n"+
			"</head>\n"+
			"<body>\n"+
			"<form action = \"http://localhost:8080" method=\"get\">\n"+
			"<table bgcolor=\"#fcf8ad\">\n"+
			"<tr>\n"+
			"<td>First Name:</td>\n"+
			"<td><input type = \"text\" name = \"firstname\"></td>\n"+
			"</tr>\n"+
			"<tr>\n"+
			"<td>Last Name:</td>\n"+
			"<td><input type = \"text\" name = \"lastname\"></td>\n"+
			"</tr>\n"+
			"<tr>\n"+
			"<td></td>\n"+
			"<td><input type=\"submit\" value=\"Submit\"></td>\n"+
			"</tr>\n"+
			"</table>\n"+
			"</form>\n"+
			"</body>\n"+
			"</html>\n"
		);
	}
}
