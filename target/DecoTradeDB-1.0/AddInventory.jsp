<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Product toevoegen</title>
    <script>
        function isNumberKey(evt){
            var charCode = (evt.which) ? evt.which : event.keyCode
            if (charCode > 31 && (charCode < 48 || charCode > 57))
                return false;
            return true;
        }
    </script>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/main.css">
</head>
<body>
<div class="container">
    <div class="row main">
        <div class="main-login main-center">
            <form class="form-horizontal" action="/AddInventory" method="post" id="add">
                <div class="form-group">
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true">Product Naam</i></span>
                            <input type="text" class="form-control" name="name" id="name" placeholder="Product Naam..."/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true">Product Code</i></span>
                            <input type="text" class="form-control" name="code" id="code" placeholder="Product Code..."/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="cols-sm-10">
                        <div class="input-group">
                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true">Aantal</i></span>
                            <input type="number" class="form-control" name="amount" id="amount" onkeypress="return isNumberKey(event)" placeholder="Aantal..."/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <button type="submit" value="Submit" form="add" class="btn btn-primary btn-lg btn-block login-button">Voeg toe</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript" src="assets/js/bootstrap.js"></script>
</body>
</html>