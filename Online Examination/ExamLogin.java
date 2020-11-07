import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ExamLogin extends HttpServlet
{ 
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		String DB_URL="jdbc:mysql://localhost/Details";
		//  Database credentials
		String USER = "root";
		String PASS = "rajagiri";
		// Set response content type
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><head><title>Exam Login</title></head>");
		int flag=0;
		Statement stmt= null;
		String sql=null;
		Connection conn=null;
		try
		{
			// Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			// Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			// Execute SQL query
			stmt = conn.createStatement();
			
			sql = "SELECT * FROM Stud";
			ResultSet rs = stmt.executeQuery(sql);
			String name = req.getParameter("username");
			String pass = req.getParameter("password");
			// Extract data from result set; Retrieve by column name
			while(rs.next())
			{
				String dname = rs.getString("Username");
				String dpass = rs.getString("Password");
				if ( name.equals(dname) && pass.equals(dpass) )
				{
					flag=1;
					//<a href="Subjects.html"></a>;
					//location.href = "Subjects.html";
					//document.location.href = "Subjects.html";
					RequestDispatcher rd = req.getRequestDispatcher("Subjects.html");
					rd.forward(req,res);
				}
			}
			if(flag==0)
			{
				out.print("<body><center><br><br><h2>The entered details do not correspond to any exisiting user.<br>"+"<br>Register below to create a new account.</h2></center><br>");  
				RequestDispatcher rd = req.getRequestDispatcher("Registration.html");
				rd.include(req,res);
			}
			out.println("</body></html>");
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException se)
		{
			//Handle errors for JDBC
			se.printStackTrace();
		}
		catch(Exception e)
		{
			//Handle errors for Class.forName
			e.printStackTrace();
		}
		finally
		{
			//finally block used to close resources
			try
			{
				if(stmt!=null)
				stmt.close();
			}
			catch(SQLException se2)
			{
			} // nothing we can do
			try
			{
				if(conn!=null)
				conn.close();
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			} //end finally try
		} //end try
	}
}