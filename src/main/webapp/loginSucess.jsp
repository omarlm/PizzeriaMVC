<%-- 
    Document   : loginSuccess
    Created on : 03-abr-2017, 22:58:12
    Author     : omarl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="css/style.css">
        <title>Pizzeria - Inicio</title>
    </head>
    <body>
        <nav id="main-menu">
            <ul class="nav-bar">
                <li><a href="${pageContext.request.contextPath}/loginSucess.jsp"><i class="icono-home"></i>Home</a></li>
                <li><a href=""><i class="icono-cross"></i>Log out</a></li>
                <li><a href="${pageContext.request.contextPath}/insertOfer.jsp"><i class="icono-plusCircle"></i>Insert Orfer</a></li>
                <li style="text-align: right"><i class="icono-user"></i><c:out value="${PRINCIPAL.login}" /></li>
            </ul>
        </nav>
        <div id="login">
            <div class="form">
                <form action="pizzaSelector" method="post">

                    <input type="submit" value="Search Pizzas" />
                </form>
            </div>
        </div>
    </body>
</html>
