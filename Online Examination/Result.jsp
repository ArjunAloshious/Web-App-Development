<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>

<%
	String a = request.getParameter("q1");
	String b = request.getParameter("q2");
	String c = request.getParameter("q3");
	float s=0,p=0,m1=0,m2=0,m3=0;
	out.print("<html><head><title>Exam Results</title></head><body bgcolor = \"black\"><br><h1 style=\"color:white\" align = \"center\">Result Analysis</h1>");
	out.print("<center><table bgcolor = \"orange\" cellspacing=\"50\" width=\"75%\";>");
	if(a.equals("q1.1"))
	{
		out.print("<tr><td align=\"center\"><h2>Q1) Correct Answer</h2></td></tr>");
		m1=1;
	}
	else if(a.equals("q1.2"))
	{
		out.print("<tr><td align=\"center\"><h2>Q1) Wrong Answer</h2></td></tr>");
	}
	if(b.equals("q2.1"))
	{
		out.print("<tr><td align=\"center\"><h2>Q2) Correct Answer</h2></td></tr>");
		m2=1;
	}
	else if(b.equals("q2.2"))
	{
		out.print("<tr><td align=\"center\"><h2>Q2) Wrong Answer</h2></td></tr>");
	}
	if(c.equals("q3.1"))
	{
		out.print("<tr><td align=\"center\"><h2>Q3) Correct Answer</h2></td></tr></table></center><br>");
		m3=1;
	}
	else if(c.equals("q3.2"))
	{
		out.print("<tr><td align=\"center\"><h2>Q3) Wrong Answer</h2></td></tr></table></center><br>");
	}
	s=m1+m2+m3;
	p=(s/3)*100;
	out.print("<h2 style=\"color:white\" align = \"center\">Total Percentage obtained = "+p+"%</h2>");
	out.print("<h2 style=\"color:white\" align = \"center\">Thank you for taking the test.</h2></body></html>");
%>