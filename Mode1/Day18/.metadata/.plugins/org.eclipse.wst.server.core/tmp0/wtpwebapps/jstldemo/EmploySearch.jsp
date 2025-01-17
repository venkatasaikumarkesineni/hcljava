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
    
    <sql:query var="empQuery" dataSource="${conn }">
    select * from Employ where empno=?
    <sql:param value="${param.empno }"/>
    </sql:query>
    
    <c:forEach var="e" items="${ empQuery.rows}">
    
    Employ no:
    <c:out value="${e.empno }"/><br/><br/>
    Employ name:
    <c:out value="${e.name }" /><br/><br/>
    Department:
     <c:out value="${e.dept }"/><br/><br/>
    Designation:
     <c:out value="${e.desig }"/><br/><br/>
    Basic:
     <c:out value="${e.basic }"/><br/><br/>
     <c:set var="flag" value="1"/>
    </c:forEach>
    <c:if test="${flag==0 }">
        <c:out value="Employ not found"></c:out>
     </c:if>
     </body>
</html>