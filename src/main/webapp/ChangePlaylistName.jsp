<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--
  Created by IntelliJ IDEA.
  User: Lars
  Date: 27-3-2017
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
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
