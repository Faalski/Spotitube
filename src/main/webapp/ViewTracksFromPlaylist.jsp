<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TracksFromPlaylist</title>
</head>
<body>
<form action="/Spotitube/ViewTracksFromPlaylist" method="post">
    <c:forEach items="${tracksfromplaylist}" var="current">
        <input type="checkbox" name="performer" value="<c:out value="${current.performer}"></c:out>"><<c:out value="${current.performer}"></c:out>>
        <input type="hidden" name="title" value="<c:out value="${current.title}"></c:out>"><c:out value="${current.title}"></c:out>">
    </c:forEach>
    <input type="submit" value="DeleteTrack"/>
    <input type="submit" value="changeAvailability"/>
</form>

</body>
</html>
