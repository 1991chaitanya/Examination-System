

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
public class SaveServlet extends HttpServlet 
{
	public void doPost(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		String str1 = "";
		//
		str1=request.getParameter("opiton");
		System.out.println("option is"+str1);
		Connection conn;
		Statement stmt;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
		System.out.println("connected");
		stmt=conn.createStatement();
		stmt.executeUpdate("insert into answer1 values('"+str1+"')");
	  }
	catch(SQLException e1)
	{
		
	}
	catch(ClassNotFoundException e2)
	{
		
	}
	out.println("<html>");
	out.println("<head>");
	out.println("<h2>");
	out.println("ANSWER CONFIRMED ");
	out.println("</h2>");
	out.println("</head>");
	out.println("<b>GO BACK</b>");
	out.println("</html>");
	
}
	 
}
