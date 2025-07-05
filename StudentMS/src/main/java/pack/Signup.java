package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 
			try {
				
				Connection conn=DBConnection.getConnection();
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				
				
				String sql="insert into details (username,passwd) values(?,?)";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, password);
				//ps.setInt(3, age);
				
				ps.executeUpdate();
				response.sendRedirect("html/login.html");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
