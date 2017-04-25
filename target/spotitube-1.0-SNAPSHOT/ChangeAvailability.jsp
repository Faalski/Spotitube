<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lars
  Date: 4-4-2017
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Availability</title>
    <form action="/ChangeAvailability" method="post">
        <c:forEach items="tracksfromplaylist" var="current">
            <input type="checkbox" name="performer" value="<c:out value="${current.performer}"></c:out>"><<c:out value="${current.performer}"></c:out>>
            <input type="hidden" name="title" value="<c:out value="${current.title}"></c:out>"><c:out value="${current.title}"></c:out>">
        </c:forEach>
        <input type="submit" name="changeAvailability" value="change">
    </form>

  </head>
<body>

</body>
</html>
