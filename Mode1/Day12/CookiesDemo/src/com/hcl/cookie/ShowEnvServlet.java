package com.hcl.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowEnvServlet
 */
public class ShowEnvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowEnvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       ServletConfig cfg=getServletConfig();
       ServletContext ctx=getServletContext();
       PrintWriter out=response.getWriter();
       response.setContentType("text/html");
       out.println("Name of the servlet  " +cfg.getServletName()+"<br/><br/>");
       //name of the servlet
       out.println("major version " + ctx.getMajorVersion() +"<br/><br/>");
       out.println("major version " + ctx.getMinorVersion() );
     //versions what we are using
       out.println("Servlet path "+ request.getServletPath()+"<br/><br/>");
       out.println("Server info " + ctx.getServerInfo()+"<br/><br/>");
       // to know which servlet we are using
       out.println("Port number "+ request.getServerPort()+"<br/><br/>");
       // to know which port we are using
       out.println("client IPE address" + request.getRemoteAddr()+"<br/><br/>");
       
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
