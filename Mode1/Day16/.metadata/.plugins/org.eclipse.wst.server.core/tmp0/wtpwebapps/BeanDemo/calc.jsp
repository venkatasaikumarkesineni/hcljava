<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <jsp:useBean id="bean1" class="com.hcl.beans.calc"/>
  <jsp:setProperty property="firstNo" name="bean1"/>
  <jsp:setProperty property="secondNo" name="bean1"/>
  sum is:
  <%=bean1.sum() %>
  

</body>
</html>