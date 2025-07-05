package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
			try {
				Connection conn=DBConnection.getConnection();
				System.out.println("connected successfully");
				String username=request.getParameter("username");
				String passwd=request.getParameter("password");
				
				String sql="select * from details where username=? and passwd=?";
				PreparedStatement ps=conn.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, passwd);
	
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					response.sendRedirect("html/dashboard.html");
					pw.write("valid user");
				}
				else {
					pw.write("invalid user");
				}
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
