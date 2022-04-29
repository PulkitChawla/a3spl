
package emp;

import java.sql.*;

public class DbConn
{
	public static Connection getConn() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","a3spl");
			System.out.println("Connection successfull");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		DbConn.getConn();
//	}

}
