package web_app_crud_with_db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Show() {
        super();  
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb2", "root", "test");
			 Statement stmnt = con.createStatement();
			 ResultSet result = stmnt.executeQuery("Select * from registers");
			 response.setContentType("text/html");
			 PrintWriter out = response.getWriter();
			 out.println("<table border='1' >");
			 out.println("<tr>");
			 out.println("<th>");
			 out.println("name");
			 out.println("</th>");
			 out.println("<th>");
			 out.println("email");
			 out.println("</th>");
			 out.println("<th>");
			 out.println("phone_no");
			 out.println("</th>");
			 out.println("<th>");
			 out.println("address");
			 out.println("</th>");
			 out.println("</tr>");
			 while(result.next())
			 {
				 out.println("<tr>");
				 out.println("<td>");
				 out.println(result.getString(1));
				 out.println("</td>");
				 out.println("<td>");
				 out.println(result.getString(2));
				 out.println("</td>");
				 out.println("<td>");
				 out.println(result.getString(3));
				 out.println("</td>");
				 out.println("<td>");
				 out.println(result.getString(4));
				 out.println("</td>");
				 out.println("</tr");
			 }
		 }catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
