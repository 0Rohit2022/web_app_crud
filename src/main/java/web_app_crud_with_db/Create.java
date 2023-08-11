package web_app_crud_with_db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/create")
public class Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Create() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String textarea = request.getParameter("textarea");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqldb2", "root", "test");
			Statement stmnt = con.createStatement();
			stmnt.executeUpdate("insert into registers values('"+name+"', '"+email+"', '"+mobile+"', '"+textarea+"')");
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
