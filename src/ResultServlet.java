

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
public class ResultServlet extends HttpServlet
{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int n=1,flag=0;	
	Connection conn;
	//ResultSet rs1;
	//ResultSet rs2;
	Statement stmt;
	//Statement stmt1;
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	try
	{
        Class.forName("com.mysql.jdbc.Driver");	
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
	      System.out.println("conected buddy!");
	      stmt=conn.createStatement();
	      //stmt1=conn.createStatement();
	     //ResultSet rs1 = stmt.executeQuery("SELECT * from answer INNER JOIN answer1 ON  answer.answer = answer1.ans "); 
	    ResultSet rs1 = stmt.executeQuery ("SELECT answer.ans1, answer1.ans from answer,answer1 where (answer.ans1 = answer1.ans) ");
	      String str1="";
	  
	      while (rs1.next() == true)
	      {
	      //str1=rs1.getString("answer");
         flag++;
	      }
	      flag = flag-1;
		
	       //System.out.println("ans is"+(4-flag));
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
	out.println("You got "+flag+" questions right::");
	out.println("</h2>");
	out.println("</head>");
	out.println("<body>");
	out.println("<b>"+flag+"<b>");
	out.println("<form method = \"post\" action =\"http://localhost:8080/ExaminationSoftware/Save\">");
	out.println("<b>ENTER NAME<b>");
	out.println("<input type=\"text\" name=\"name\">");
	HttpSession hs=request.getSession(true);
	hs.setAttribute("Qu1", flag);
	out.println("<input type=\"submit\" value=\"Save Result\" >");
	
	out.println("<a href=\"http://localhost:8080/ExaminationSoftware/Home.html\">");
	out.println("Home</a>");
	out.println("</body>");
	out.println("</html>");
	
}

}
