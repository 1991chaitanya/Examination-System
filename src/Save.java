

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;

import java.sql.*;

public class Save extends HttpServlet 
{
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		//String st=request.getParameter("name");
		//int i=Integer.parseInt(st);
		String str=request.getParameter("name");
		/*String str1=request.getParameter("option1");
		String str2=request.getParameter("option2");
		String str3=request.getParameter("option3");
		String str4=request.getParameter("option4");*/
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Connection conn;
		Statement stmt;
		HttpSession hs=request.getSession(true);
		String  str5=(hs.getAttribute("Qu1").toString());
		int i1=Integer.parseInt(str5);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
			System.out.println("connection successful");
			stmt=conn.createStatement();
			stmt.executeUpdate("insert into result values('"+str+"',"+i1+")");
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
  	       out.println("<a href=\"http://localhost:8080/ExaminationSoftware/HOME.html\" >");
  	       out.println("back</a>");
  		   out.println("</body>");
            out.println("</html>");
	}

}
