<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Lars
  Date: 24-3-2017
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TracksFromPlaylist</title>
        <c:forEach items="${tracksfromplaylist}" var="current">
            <tr>
                <td>
                    <c:out value="${current.performer}"></c:out>
                </td>
            </tr>
        </c:forEach>
</head>
<body>

</body>
</html>
