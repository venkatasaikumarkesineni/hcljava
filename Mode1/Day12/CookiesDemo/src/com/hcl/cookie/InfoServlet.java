package com.hcl.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InfoServlet
 */
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      PrintWriter out=response.getWriter();
      String Id=request.getParameter("id");
      String Name=request.getParameter("name");
      String[] Hobbies=request.getParameterValues("hobbies");
      String Gender=request.getParameter("gender");
      String City=request.getParameter("city");
      String State=request.getParameter("state");
      String Country=request.getParameter("country");
      
      out.println("employ id is" + Id+"<br/><br/>");
      out.println("employ name is" + Name+"<br/><br/>");
      for(String string:Hobbies){
    	  out.println("Hobbies are " + string+"<br/><br/>");  
      }
      out.println("Gender  is" + Gender+"<br/><br/>");
      out.println("City is" + City+"<br/><br/>");
      out.println("State is" + State+"<br/><br/>");
      out.println("Country  is" + Country+"<br/><br/>");
      
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
