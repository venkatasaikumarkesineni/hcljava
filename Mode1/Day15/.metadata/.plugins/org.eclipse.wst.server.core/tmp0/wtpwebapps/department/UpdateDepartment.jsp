<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.hcl.department.DaoConnection"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
   int deptno=Integer.parseInt(request.getParameter("deptno"));
   Connection con=DaoConnection.getConnection();
   String cmd="select * from dept where deptno=? ";
   PreparedStatement pst=con.prepareStatement(cmd);
   pst.setInt(1,deptno);
   ResultSet rs=pst.executeQuery();
   
   rs.next();
   %>
<form method="get" action="UpdateDepartment.jsp"  >
  <center>
     Employ No:
   <input type="text"  name="deptno" readonly="readonly" 
   value=<%=rs.getInt("deptno") %> /><br/>
   Department Name:
   <input type="text" name="dname" value=<%=rs.getString("dname")%> /><br/>
    location :
    <input type="text" name="loc" value=<%=rs.getString("loc")%> /><br/>
    <input type="submit" value="update"/>
   
  </center>
</form>
 
     <%
     if(request.getParameter("deptno")!=null &&
     request.getParameter("dname")!=null){
    	 cmd="update dept set dname=?, loc=? where deptno=? ";
    	 pst=con.prepareStatement(cmd);
    	 pst.setString(1,request.getParameter("dname"));
    	 pst.setString(2,request.getParameter("loc"));
    	 pst.setInt(3,deptno);
         pst.executeUpdate();
    	 
    	 %>
    	 <jsp:forward page="EmployShow.jsp"/>
     
 <% 
     }
     %>


</body>
</html>