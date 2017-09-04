<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Producten overzicht</title>
    <script>
        function isNumberKey(evt){
            var charCode = (evt.which) ? evt.which : event.keyCode
            if (charCode > 31 && (charCode < 48 || charCode > 57))
                return false;
            return true;
        }
    </script>
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
<br />
<div class="container">
    <div class="row">
        <div class="col-md-5">
            <form action="/ViewInventory" method="get" id="search">
                    <div class="input-group">
                        <input type="text" name="SearchInput" class="form-control" placeholder="Zoekterm...">
                        <span class="input-group-btn">
                            <button class="btn btn-secondary" type="submit" form="search" value="Submit">Zoek</button>
                        </span>
                    </div>
            </form>
        </div>
        <div class="col-md-1">
            <form action="/ViewInventory" method="get" id="All">
                    <div class="input-group">
                        <span class="input-group-btn">
                            <button class="btn btn-secondary" type="submit" form="All" value="All">Alles</button>
                        </span>
                    </div>
            </form>
        </div>
        <div class="col-md-3">
            <!-- Placeholder -->
        </div>
        <div class="col-md-2">
            <form action="/ViewInventory" method="post" id="add">
                <div class="input-group">
                        <span class="input-group-btn">
                            <button class="btn btn-primary" type="submit" form="add" value="add">Product toevoegen</button>
                        </span>
                </div>
            </form>
        </div>
    </div>
</div>
<br />
<div class="container">
    <div class="row">
        <table class="table table-bordered table-striped">
            <tr>
                <th>Naam</th>
                <th>Code</th>
                <th>Aantal</th>
                <th>Voeg toe</th>
                <th>Trek af</th>
            </tr>
            <c:forEach items="${inventory}" var="current">
                <tr>
                    <td>${current.name}</td>
                    <td>${current.code}</td>
                    <td>${current.amount}</td>
                    <td>
                        <form action="/AddInventory" method="post" id="add_${current.code}">
                            <div class="row">
                                <div class="col-xs-6">
                                    <div class="input-group">
                                        <input type="hidden" name="name" value="${current.name}">
                                        <input type="hidden" name="code" value="${current.code}">
                                        <input type="number" class="form-control" name="amount" onkeypress="return isNumberKey(event)">
                                        <input type="hidden" name="addOrSubtract_Add">
                                        <span class="input-group-btn">
                                            <button type="submit" class="btn btn-secondary" form="add_${current.code}" value="Submit">Voeg toe</button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </td>
                    <td>
                        <form action="/AddInventory" method="post" id="subtract_${current.code}">
                            <div class="row">
                                <div class="col-xs-6">
                                    <div class="input-group">
                                        <input type="hidden" name="name" value="${current.name}">
                                        <input type="hidden" name="code" value="${current.code}">
                                        <input type="number" class="form-control" name="amount" onkeypress="return isNumberKey(event)">
                                        <input type="hidden" name="addOrSubtract_Subtract">
                                        <span class="input-group-btn">
                                            <button type="submit" class="btn btn-secondary" form="subtract_${current.code}" value="Submit">Trek af</button>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

<script type="text/javascript" src="assets/js/bootstrap.js"></script>
</body>
</html>
