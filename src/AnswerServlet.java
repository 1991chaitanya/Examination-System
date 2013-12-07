



import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class AnswerServlet extends HttpServlet 
{
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
	String str1=request.getParameter("q1");
	int i1=Integer.parseInt(str1);
	String st1=request.getParameter("a1");

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
		stmt.executeUpdate("insert into answer values("+i1+",'"+st1+"')");
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
	out.println("ANSWER ENTERED! ");
	out.println("</h2>");
	out.println("</head>");
	out.println("<b>GO BACK</b>");
	out.println("</html>");
	
}
	 
}

