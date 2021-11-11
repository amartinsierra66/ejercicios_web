package locator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatosBd {
	static String cadenaCon="jdbc:mysql://localhost:3307/libreria";
	static String user="root";
	static String pwd="root";
	static String driver= "com.mysql.jdbc.Driver";
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName(driver);
			return DriverManager.getConnection(cadenaCon, user, pwd);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
		}

		
	}
}
