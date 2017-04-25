<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ChangePlaylistName</title>
</head>
<body>
<form action="/ChangePlaylistName" method="post">
    <input type="text" name="newplaylistname">
    <input type="hidden" name="oldplaylistname" value="<c:out value="${playlistname}"/>">
    <c:out value="${playlistname}"/>
    <input type="submit" name="submitname">
</form>

</body>
</html>
