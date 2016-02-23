<%--
  Created by IntelliJ IDEA.
  User: X1z
  Date: 22.02.2016
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<html>
<head>
    <title>АРРРР</title>
</head>
<body>

<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/mydbtest"
                   user="root"  password="root"/>

<sql:query dataSource="${snapshot}" var="result">
    SELECT * from books
</sql:query>

<table border="1" width="100%">
    <tr>
        <th>Emp ID</th>
        <th>name</th>
        <th>Autor</th>
        <th>count</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.name}"/></td>
            <td><c:out value="${row.autor}"/></td>
            <td><c:out value="${row.count}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
