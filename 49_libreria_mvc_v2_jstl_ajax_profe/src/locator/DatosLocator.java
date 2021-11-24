package locator;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatosLocator  {
	public static Connection getConnection() throws SQLException {
		try {
			Context context=new InitialContext(); //entrada al sistema de directorio
			DataSource ds=(DataSource)context.lookup("java:comp/env/reflibros");
			return ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
		}
	}

	
}
