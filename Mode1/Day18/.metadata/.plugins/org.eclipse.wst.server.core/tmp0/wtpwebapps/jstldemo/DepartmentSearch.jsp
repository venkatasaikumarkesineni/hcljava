<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <sql:setDataSource var="conn"
   driver="com.mysql.jdbc.Driver"
   url="jdbc:mysql://localhost:3306/sqlpractice"
   user="root"
   password="root"
   />
   <sql:query var="deptQuery" dataSource="${conn }">
   select * from dept where deptno=?
   <sql:param value="${param.deptno }"/>
   
   </sql:query>
   
   
   <c:forEach var="e" items="${deptQuery.rows }">
   Dept no:
   <c:out value="${e.deptno }"/>
   Dept name:
   <c:out value="${e.dname }"/>
   location:
   <c:out value="${e.loc }"/>
   
   <c:set var="flag" value="1"/>
   </c:forEach>


     <c:if test="${flag==0 }">
     <c:out value="department  not found"></c:out>
     
     </c:if>
     
</body>
</html>