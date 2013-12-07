

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class NewMemberServlet
 */
@WebServlet("/NewMemberServlet")
public class NewMemberServlet extends HttpServlet
{
	
	public  void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
String str1=	request.getParameter("id");
String str2=	request.getParameter("pass");
response.setContentType("text/html");
PrintWriter out=response.getWriter();
Connection conn;
Statement stmt;
   try
   {
	   Class.forName("com.mysql.jdbc.Driver");
	   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
       stmt=conn.createStatement();
       stmt.executeUpdate("insert into login2 values('"+str1+"','"+str2+"')");
   }
  catch(ClassNotFoundException e1)
  {
	  
  }
   catch(SQLException e1)
   {
 	  
   }
   
   out.println("<html>");
   out.println("<head>");
   out.println("<h1>");
   out.println("DATA ENTERED SUCCCESFULLY");
   out.println("</h1>");
   out.println("</head>");
   out.println("</html>");
	}

}
