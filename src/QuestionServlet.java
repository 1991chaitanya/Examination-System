

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class QuestionServlet extends HttpServlet 
{
	
	public void service(ServletRequest request,ServletResponse response) throws ServletException, IOException
	{
		String st=request.getParameter("ques");
		int i=Integer.parseInt(st);
		String str=request.getParameter("comments");
		String str1=request.getParameter("option1");
		String str2=request.getParameter("option2");
		String str3=request.getParameter("option3");
		String str4=request.getParameter("option4");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection conn;
		Statement stmt;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
			System.out.println("connection successful");
			stmt=conn.createStatement();
			stmt.executeUpdate("insert into comment values('"+str+"',"+i+",'"+str1+"','"+str2+"','"+str3+"','"+str4+"')");
		}
		catch(SQLException e1)
		{
			
		}
		catch(ClassNotFoundException e1)
		{
			
		}
		 out.println("<html>");
         out.println("<head>");
         out.println("<img src=\"C:\\Users\\pankaj\\Downloads\\images\\icon1.jpg\">");
     	out.println("</img>");
     	out.println("<h2>data added succesfully</h2>"); 
     	out.println("</head>");
         out.println("<body bgcolor\"skyblue\">");
         //out.println("<br>");
  	       out.println("<a href=\"http://localhost:8080/ExaminationSoftware/Questions.html\" >");
  	       out.println("back</a>");
  		   out.println("</body>");
            out.println("</html>");
	}

}
