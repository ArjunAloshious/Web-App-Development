import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
 
public class Dog extends HttpServlet
{
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		String DB_URL="jdbc:mysql://localhost/Pet";		// Pet is the Database created
		
		// Database credentials
		String USER = "root";
		String PASS = "rajagiri";

		// Set response content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "Database Result";

		out.println("<html><head><title>" + title + "</title></head><body bgcolor = \"#f0f0f0\"><h1 align = \"center\">" + title + "</h1>\n");
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

			sql = "SELECT * FROM dog";					// dog is the Table Name
			ResultSet rs = stmt.executeQuery(sql);
			
			out.println("<center><br><br><br>");
			// Extract data from result set; Retrieve by column name
			while( rs.next() )
			{
				String name = rs.getString("dogname");
				String breed = rs.getString("breed");
				out.println("Name: " + name + " Breed: " + breed + "<br><br>");
			}
			out.println("</center></body></html>");

			// Clean-up environment
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