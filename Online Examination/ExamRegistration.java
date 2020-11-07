import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class ExamRegistration extends HttpServlet
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
		out.println("<html><head><title>Exam Registration</title></head><html>");
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

			String name = req.getParameter("username");
			String pass = req.getParameter("password");
			PreparedStatement preparedStatement = null;
			String query = "INSERT INTO Stud VALUES(?, ?)"; 
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pass);
			preparedStatement.executeUpdate();
			RequestDispatcher rd = req.getRequestDispatcher("Subjects.html");
			rd.forward(req,res);
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