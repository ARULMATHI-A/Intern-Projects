package pack;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		String url="jdbc:mysql://localhost:3306/stu_detail";
		String user="root";
		String pwd="Mysql123";
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pwd);
			System.out.println("successfully connected....");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
