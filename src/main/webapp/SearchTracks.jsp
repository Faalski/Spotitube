<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Tracks</title>
</head>
<body>
<p>Search track by title: </p>
<form action="/SearchTracks" method="post">
    <input type="text" name="SearchInput">
    <input type="submit" name="submitInput" value="zoek">
    <input type="submit" name="goToPlaylist" value="ga naar playlist">
    <input type="submit" name="filter" value="filter">
</form>
<table border="1">
    <tr>
        <th>Performer</th>
        <th>Title</th>
        <th>Duration</th>
        <th>url</th>
        <th>Add</th>
    </tr>
    <c:forEach items="${tracks}" var="current">
        <tr>
            <td><c:out value="${current.performer}"/></td>
            <td><c:out value="${current.title}"/></td>
            <td><c:out value="${current.duration}"/></td>
            <td><c:out value="${current.url}"/></td>
            <td><form action="/AddTrackToPlayList" method="post"><input type="hidden" name="TrackName" value="${current.title}"><input type="hidden" name="PerformerName" value="${current.performer}"><input type="submit" name="submitInput"></form></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
