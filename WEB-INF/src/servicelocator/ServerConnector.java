package servicelocator;

import java.sql.Connection;
import java.sql.DriverManager;

public class ServerConnector
{
	public static Connection ServerConnector()
	{
		Connection con=null;
		try
		 {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance_db","root","admin");
		 }
		catch (Exception e)
		 {
			System.out.println(e);
		 }
		
		return con;
	}
}
