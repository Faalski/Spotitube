<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login pagina</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/main.css">
    </head>
    <body>
    <div class="container">
        <div class="row main">
            <div class="main-login main-center">
                <form class="form-horizontal" method="post" action="Login">
                    <c:if test="${status != null}">
                        <div class="form-group">
                            <div class="cols-sm-10">
                                <div class="input-group">
                                    <span class="input-group-addon errorMessage"><i class="fa fa-user fa" aria-hidden="true">
                                            ${status}
                                    </i></span>
                                </div>
                            </div>
                        </div>
                    </c:if>
                    <div class="form-group">
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true">Gebruikersnaam</i></span>
                                <input type="text" class="form-control" name="user" id="user" placeholder="Gebruikersnaam"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="cols-sm-10">
                            <div class="input-group">
                                <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true">Wachtwoord</i></span>
                                <input type="password" class="form-control" name="pass" id="password"  placeholder="Wachtwoord"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group ">
                        <button type="submit" value="Login" class="btn btn-primary btn-lg btn-block login-button">Inloggen</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="assets/js/bootstrap.js"></script>
    </body>
</html>
