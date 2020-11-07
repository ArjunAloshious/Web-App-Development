<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<%
	String n = request.getParameter("fname");
	String p = request.getParameter("password");
	if (n.equals("Arjun") && p.equals("abcde"))
	{
		Date date = new Date();
        out.println("Welcome  "+n);
		out.println(date.toString());
	} 
	else
	{
		out.println("Invalid Username and Password!");
	}
%>
