package com.hcl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmploySearchServlet
 */
public class EmploySearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmploySearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Connection con=DaoConnection.getConnection();
	  String cmd="select * from employ where empno=?";
	  PrintWriter out=response.getWriter();
	  try {
		PreparedStatement pst=con.prepareStatement(cmd);
		pst.setInt(1, Integer.parseInt(request.getParameter("empno")));
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			out.println("name "+ rs.getString("name")+"<br/><br/>");
			out.println("Department "+ rs.getString("dept")+"<br/><br/>");
			out.println("designation "+ rs.getString("desig")+"<br/><br/>");
			out.println("salary "+ rs.getInt("basic")+"<br/><br/>");
		}else{
			out.println("*** record not found ***");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
