<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Lars
  Date: 30-3-2017
  Time: 12:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Tracks</title>

</head>
<body>
<c:forEach items="${tracks}" var="current">
    <tr>
        <td>
            <c:out value="${current.performer}"></c:out>
        </td>
    </tr>
</c:forEach>

</body>
</html>
