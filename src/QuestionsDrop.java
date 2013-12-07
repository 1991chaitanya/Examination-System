


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class QuestionsDrop extends HttpServlet 
{
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
//	String str=request.getParameter("opiton");
	Connection conn;
	Statement stmt;
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
		System.out.println("connected again");
		stmt=conn.createStatement();
		stmt.executeUpdate("delete from comment");
	  }
	catch(SQLException e1)
	{
		
	}
	catch(ClassNotFoundException e2)
	{
		
	}
	out.println("<html>");
	out.println("<head>");
	out.println("<h1>");
	out.println("ALL QUESTIONS DELETED SUCCESSFULLY!");
	out.println("</h1>");
	out.println("</head>");
	out.println("<a href=\"http://localhost:8080/ExaminationSoftware/Home.html\">");
	out.println("home</a>");
	out.println("</html>");
}
}
