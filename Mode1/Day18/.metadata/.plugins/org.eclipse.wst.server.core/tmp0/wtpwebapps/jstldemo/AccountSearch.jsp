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
   url="jdbc:mysql://localhost:3306/bank"
   user="root"
   password="root"
/>
<sql:query var="bankQuery" dataSource="${conn}">
   select * from accounts where accountno=?
   <sql:param value="${param.accountno}"/>
 </sql:query>
 
 <c:forEach var="e" items="${bankQuery.rows}">
    
    Account no:
    <c:out value="${e.accountno }"/><br/><br/>
    First name:
    <c:out value="${e.FirstName }" /><br/><br/>
    Last Name:
     <c:out value="${e.lastName }"/><br/><br/>
    city:
     <c:out value="${e.city }"/><br/><br/>
    state:
     <c:out value="${e.state }"/><br/><br/>
     Amount:
     <c:out value="${e.amount }"/><br/><br/>
     cheqFacil:
     <c:out value="${e.cheqFacil }"/><br/><br/>
     AccountType:
     <c:out value="${e.accountType }"/><br/><br/>
     <c:set var="flag" value="1"/>
    </c:forEach>
    <c:if test="${flag==0 }">
        <c:out value="Account not found"></c:out>
     </c:if>

</body>
</html>