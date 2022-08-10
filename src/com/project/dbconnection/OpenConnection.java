package com.project.dbconnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.project.interfaces.DbConnection;
/*This class is used to establish database connection
*/
public class OpenConnection implements DbConnection{

	@Override
	public Connection getConnection() throws SQLException, IOException {
		Connection connection = null;
		FileInputStream fileInputStream = null;
		try {
			
			Properties properties = new Properties();
			
			//Step-1 : Read data from property file.
			
			fileInputStream=new FileInputStream("C:\\Users\\personal\\Desktop\\Java\\LoginCredentials.properties");
			
			//Step-2 : to load all properties from properties file into java properties object.
			properties.load(fileInputStream);
			String url=properties.getProperty("url");
			String username=properties.getProperty("username");
			String password=properties.getProperty("password");
			
			//Step-3 : Loading the Driver Class.
			Class.forName("com.mysql.jdbc.Driver");
			
			//Step 4 : Establishing the connection
			connection = DriverManager.getConnection(url,username,password);
		
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

		
	}

}
