

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class AdminServlet1 extends HttpServlet 
{
	

	
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException
	{
		String str1=req.getParameter("id");
		String str2=req.getParameter("pass");
		Connection conn; 
		Statement stmt;
		ResultSet rs;
		 res.setContentType("text/html");
		 
		PrintWriter out=res.getWriter();
	      
	       try
	       {
	    	   
	    	   Class.forName("com.mysql.jdbc.Driver");
	    	   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
	    	   System.out.println("connection success");
	    	    stmt=conn.createStatement();
	    	   rs=stmt.executeQuery("select *from login3 where id='"+str1+"' and password='"+str2+"' ");
	    	   if(rs.next()==true)
	           {
	    	   out.println("<html>");
	    	   out.println("<head>");
	    	   out.println("<h3>");
	    	   out.println("LOGGED IN SUCCESSFULLY");
	    	   out.println("</h3>");
	    	   out.println("</head>");
	    	   out.println("<body  background=\"C:\\Users\\pankaj\\Downloads\\images\\students.jpg\">");
	    	   out.println("<form method=\"post\" action=\"http://localhost:8080/ExaminationSoftware/Questions.html\">");
	    	   out.println("<input type=\"submit\" value=\"ADD Questions\">");
               out.println("</form>");
               out.println("<form method=\"post\" action=\"http://localhost:8080/ExaminationSoftware/QuestionsDrop\">");
	    	   out.println("<input type=\"submit\" value=\"Delete Questionbank\">");
               out.println("</form>");
               out.println("<form method=\"post\" action=\"http://localhost:8080/ExaminationSoftware/AddAnswers.html\">");
	    	   out.println("<input type=\"submit\" value=\"Put Answers\">");
               out.println("</form>");
               out.println("<a href=\"http://localhost:8080/ExaminationSoftware/Home.html\" >");
        	   out.println("Home</a>");
               out.println("</body>");
	    	   out.println("</html>");
	    	   }
	    	   else
	    	   {
	    		   out.println("<html>");
		    	   out.println("<head>");
		    	   out.println("<h3>");
		    	   out.println("INVALID ID OR PASSWORD");
		    	   out.println("</h3>");
		    	   out.println("</head>");
		    	   out.println("</html>");
	    		   
	    	   }
	    	}
	       catch(SQLException e1)
	       {
	    	   System.out.println(e1);
	    	   
	       }
	       catch(ClassNotFoundException e2)
	       {
	    	   System.out.println(e2);
	       }
	      
	}

}
