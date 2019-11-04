package com.hcl.ems;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployLogin {

	public static boolean authenticate(int user, String pwd) {
		Connection con=DaoConnection.getConnection();
		String cmd="select * from employlogin where emp_id=? AND secretcode=?";
		boolean flag=true;
		try {
			PreparedStatement pst=con.prepareStatement(cmd);
			pst.setInt(1, user);
			pst.setString(2, pwd);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				flag=true;
			} else {
				flag=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
