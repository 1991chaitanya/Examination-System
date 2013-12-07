import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;

public class QueServlet5 extends HttpServlet
{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	   Connection conn;
	   Statement stmt;
	   ResultSet rs;
		HttpSession hs=request.getSession(true);
		hs.setAttribute("Que1", 5);
	   try
	   {
		   Class.forName("com.mysql.jdbc.Driver");
		   conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
		   System.out.println("conn succccsss!");
		   stmt=conn.createStatement();
		   rs=stmt.executeQuery("select comment,op1,op2,op3,op4 from comment where no=5");
		   if(rs.next()==true)
		   {
			   out.println("<html>");
			   out.println("<head>");
			   out.println("<h2>");
			   out.println("QUESTION NO 5");
			   out.println("</h2>");
			   out.println("</head>");
			   out.println("<body>");
			   out.println("<b>"+rs.getString("comment")+"</b>");
			   out.println("<form method=\"post\" action=\"http://localhost:8080/ExaminationSoftware/SavServlet\">");
			   out.println("<input type=\"radio\" name=\"option\" value="+rs.getString("op1")+">"+rs.getString("op1")+"");
			   out.println("<br>");
			   out.println("<input type=\"radio\" name=\"option\" value="+rs.getString("op2")+">"+rs.getString("op2")+"");
			   out.println("<br>");
			   out.println("<input type=\"radio\" name=\"option\" value="+rs.getString("op3")+">"+rs.getString("op3")+"");
			   out.println("<br>");
			   out.println("<input type=\"radio\" name=\"option\" value="+rs.getString("op4")+">"+rs.getString("op4")+"");
			   out.println("<br>");
			   out.println("<input type=\"submit\" value=\"CONFIRM\">");
			   out.println("</form>");
			   out.println("</form>");
			   out.println("<br>");
			   out.println("<br>");
			   out.println("<br>");
			   out.println("<br>");
			   out.println("<form method=\"post\" action=\"http://localhost:8080/ExaminationSoftware/End.html\">");
			   out.println("<input type=\"submit\" value=\"NEXT\">");
			   out.println("</form>");
	            out.println("</body>");
			   out.println("</html>");
			   
			}
		   else
		   {
			   out.println("<html>");
			   out.println("<head>");
			   out.println("<h2>");
			   out.println("QUESTION NOT AVAILABLE!");
			   out.println("</h2>");
			   out.println("</head>");
			   
			      
		   }
	   }
	   catch(SQLException e1)
	   {
		   
	   }
	   catch(ClassNotFoundException e2)
	   {
		   
	   }

	}

}
