<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: dimitri
  Date: 27-3-17
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Tracks</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Performer</th>
        <th>Title</th>
        <th>Duration</th>
        <th>url</th>
    </tr>
    <c:forEach items="${tracks}" var="current">
        <tr>
            <td><c:out value="${current.performer}"/></td>
            <td><c:out value="${current.title}"/></td>
            <td><c:out value="${current.duration}"/></td>
            <td><c:out value="${current.url}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
