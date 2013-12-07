

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SavServlet extends HttpServlet 
{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String str1;
		//
		str1=request.getParameter("option");
		System.out.println("option is"+str1);
		Connection conn;
		Statement stmt;
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		HttpSession hs=request.getSession(true);
			
		String  str=(hs.getAttribute("Que1").toString());
		int i=Integer.parseInt(str);
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/chaitanya","root","");
		System.out.println("connected");
		stmt=conn.createStatement();
		stmt.executeUpdate("insert into answer1 values('"+str1+"',"+i+")");
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

