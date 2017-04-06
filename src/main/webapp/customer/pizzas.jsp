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
        <link rel="stylesheet" href="./css/style.css">
        <title>Lista - Inicio</title>
    </head>
    <body>
        <nav id="main-menu">
            <ul class="nav-bar">
                <li><a href="#"><i class="icono-home"></i>Home</a></li>
                <li><a href=""><i class="icono-cross"></i>Log out</a></li>
            </ul>
        </nav>
        <div class="container">
            <h1 class="title">Las Destacas</h1>
            <c:forEach var="item" items="${listPizzas}">
                <div class="wrap">
                    <h1>Oferta: ${item.nombre}</h1>
                    <p>Precio: ${item.precioTotal}€</p>
                    <p><img src="${item.urlImagen}" /></p>

                    <div id="login">
                        <div class="form">
                            <form action="shoppingCart" method="post">

                                <input type="submit" value="Pedir" />
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
