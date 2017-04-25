<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>TracksFromPlaylist</title>
</head>
<body>
<table border="1">
        <tr>
                <th>Performer</th>
                <th>Title</th>
                <th>Duration</th>
                <th>url</th>
                <th>album</th>
                <th>playcount</th>
                <th>publication_date</th>
                <th>description</th>
                <th>OfflineAvailable</th>
                <th>Delete</th>
                <th>ChangeAvailability</th>
        </tr>
<c:forEach items="${tracksfromplaylist}" var="current">
        <tr>
                <td><c:out value="${current.performer}"/></td>
                <td><c:out value="${current.title}"/></td>
                <td><c:out value="${current.duration}"/></td>
                <td><c:out value="${current.url}"/></td>
                <td><c:out value="${current.album}"/></td>
                <td><c:out value="${current.playcount}"/></td>
                <td><c:out value="${current.publication_date}"/></td>
                <td><c:out value="${current.description}"/></td>
                <td><c:out value="${current.offlineAvailable}"/></td>
                <td>
                <form action="/ViewTracksFromPlaylist" method="post">
                        <input type="hidden" name="performer" value="${current.performer}">
                        <input type="hidden" name="title" value="${current.title}">
                        <input type="submit" name="DeleteTrack" value="DeleteTrack"/>

                </form>
                </td>
                <td>
                        <form action="/ViewTracksFromPlaylist" method="post">
                                <input type="hidden" name="performer" value="${current.performer}">
                                <input type="hidden" name="title" value="${current.title}">
                                <input type="submit" name="changeAvailability" value="changeAvailability"/>
                                </form>
                </td>
        </tr>
</c:forEach>
        <a href="/ViewPlaylist">Bekijk playlists</a>
</body>
</html>
