<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>TracksFromPlaylist</title>
</head>
<body>
<c:forEach items="${tracksfromplaylist}" var="current">
<form action="/Spotitube/ViewTracksFromPlaylist" method="post">

        <input type="hidden" name="performer" value="<c:out value="${current.performer}"></c:out>">
        <c:out value="${current.performer}"></c:out>
        <input type="hidden" name="title" value="<c:out value="${current.title}"></c:out>"><c:out value="${current.title}"></c:out>">
        <input type="text" name="isoffline" value="<c:out value="${current.offlineAvailable}"></c:out>"><c:out value="${current.offlineAvailable}"></c:out>
        <input type="submit" name="DeleteTrack" value="DeleteTrack"/>
        <input type="submit" name="changeAvailability" value="changeAvailability"/>
</form>
</c:forEach>
</body>
</html>
