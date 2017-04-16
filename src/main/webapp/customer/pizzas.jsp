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
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Work+Sans" >
        <link rel="stylesheet" href="css/style.css">
        <title>Pizzeria - Lista</title>
    </head>
    <body>
        <header>
            <div class="container">
                <img src="${pageContext.request.contextPath}/images/pizza.png" alt="logo" class="logo"/>
                <nav>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/loginSucess.jsp">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/insertOfer.jsp">Insert Orfer</a></li>
                        <li><a href="">Log out</a></li>
                        <li><c:out value="${PRINCIPAL.login}" /></li>
                        <li><i class="icono-cart"></i> <c:out value="${SHOPPING_CART.items}" /></li>
                    </ul>
                </nav>
            </div>
        </header>
        <div class="container-list">
            <h1>Las Destacas</h1>
            <c:forEach var="item" items="${listPizzas}">
                <div class="container-pizzas">
                    <h2>Oferta: ${item.nombre}</h2>
                    <p>Precio: ${item.precioTotal}€</p>
                    <p><img src="${item.urlImagen}" /></p>
                    <p>Cantidad: <input type="number"></p>
                    <form action="shoppingCart" method="post">
                        <input value="${item.idOfertas}" name="idPedido" type="submit"/>
                    </form>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
