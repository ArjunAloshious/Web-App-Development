import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SrvltJust1 extends HttpServlet { 
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
// Set the MIME content type:
res.setContentType("text/html");
// Get a print writer which used to send data back
// to the client:
PrintWriter out = res.getWriter();
// Now print (display) the data to the client:
out.println("<HTML><HEAD><TITLE>Servlet</TITLE></HEAD><BODY><H1>This is a just a Servlet!</H1></BODY></HTML>");
// Close the PrintWriter:
out.close();
}
}