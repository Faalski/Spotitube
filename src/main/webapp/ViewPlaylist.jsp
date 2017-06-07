<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: Lars
  Date: 23-3-2017
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Playlists</title> <br>
    <c:forEach items="${playlists}" var="current">
    <form action="/ViewPlaylist" method="post">

            <c:out value="${current.name}"/>
            <input type="submit" name="viewtracksfromplaylist" value="bekijk tracks"/>
            <input type="submit" name="addTrack" value="Voeg track toe"/>
            <input type="submit" name="changename" value="verander playlistname" />
            <input type="submit" name="deleteplaylist" value="Verwijder Playlist"/>
            <input type="hidden" name="playlistname" value="<c:out value="${current.name}"/>">
    </form>
    </c:forEach>

    <a href="/CreatePlaylist.jsp">Maak playlist</a>
</head>
<body>

</body>
</html>
