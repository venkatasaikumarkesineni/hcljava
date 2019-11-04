package com.hcl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployShow {
	public static void main(String[] args) {
		Connection con=DaoConnection.getConnection();
		String cmd="select * from employ";
		try {
			PreparedStatement pst=con.prepareStatement(cmd);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println("employ no " + rs.getInt("empno"));
				System.out.println("employ name" + rs.getString("name"));
				System.out.println("employ department " + rs.getString("dept"));
				System.out.println("employ desig " + rs.getString("desig"));
				System.out.println("emply basic" + rs.getInt("basic"));

			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
