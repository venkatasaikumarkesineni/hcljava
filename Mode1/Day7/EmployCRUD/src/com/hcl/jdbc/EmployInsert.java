package com.hcl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployInsert {
	public static void main(String[] args) {
		int empno,basic;
		String name,dept,desig;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the employ number");
		empno=Integer.parseInt(sc.nextLine());
		System.out.println("name of the employ");
		name=sc.nextLine();
		System.out.println("department ");
		dept=sc.nextLine();
		System.out.println("designation");
		desig=sc.nextLine();
		System.out.println("enter the basic");
		basic=Integer.parseInt(sc.nextLine());
		String cmd="insert into employ values(?,?,?,?,?)";
		Connection con=DaoConnection.getConnection();
		try {
			PreparedStatement pst=con.prepareStatement(cmd);
			pst.setInt(1, empno);
			pst.setString(2, name);
			pst.setString(3, dept);
			pst.setString(4, desig);
			pst.setInt(5, basic);
			pst.executeUpdate();
			System.out.println("**recoed inserted**");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
