package com.hcl.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DaoConnection {
	public static Connection getConnection(){
		ResourceBundle rb=ResourceBundle.getBundle("db");
		String driver=rb.getString("driver");
		String url=rb.getString("url");
		String user=rb.getString("user");
		String pwd=rb.getString("password");
		Connection con=null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
