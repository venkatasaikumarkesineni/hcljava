<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bean1" class="com.hcl.beans.DeptSearch"/>
  <jsp:setProperty property="*" name="bean1"/>
<%
  ResultSet rs=bean1.searchDept();
if(rs.next()){
	  out.println("dept name is "+ rs.getString("dname")+"<br/><br/>");
	  out.println("location  is "+ rs.getString("loc")+"<br/><br/>");
	  
}else{
	out.print("not found");
}

%>

</body>
</html>