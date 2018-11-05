package isw.proyecto.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class conexBd {
	private static final String URL = DbPropertiesReader.getString("db.url");
	static final String USERNAME = DbPropertiesReader.getString("db.user");
	static final String PASSWORD = DbPropertiesReader.getString("db.password");
	public Connection conectarse()
	{
		Connection con = null;
		try 
		{
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con; 
	 	}
}
