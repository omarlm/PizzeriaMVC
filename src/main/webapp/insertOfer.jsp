<%-- 
    Document   : insertOfer
    Created on : 10-abr-2017, 15:41:44
    Author     : omarl
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Work+Sans" >
        <link rel="stylesheet" href="css/style.css">
        <title>Pizzeria - Insertar Oferta</title>
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
        <div class="container-register">
            <h1>Registro de oferta</h1>
            <form action="insertPizzas" method="post">
                <label for="inputName">Nombre:
                    <input type="text" id="inputName" name="namePizza" required="required" />
                </label>
                <label for="selBase">Tipo de base:
                    <select id="selBase" name="selBase">
                        <option value="EXTRAQ">Extra Queso</option>
                        <option value="3PISOS">3 pisos</option>
                        <option value="EXTRAC">Extra Carne</option>
                    </select>
                </label>
                <label>Ingredientes:
                    <input id="chkIngredient1" type="checkbox" value="1" name="ingredients"/> Mozzarella
                    <input id="chkIngredient2" type="checkbox" value="2" name="ingredients"/> Champiñones
                    <input id="chkIngredient3" type="checkbox" value="3" name="ingredients"/> Bacon
                    <input id="chkIngredient4" type="checkbox" value="4" name="ingredients" /> Peperoni
                </label>
                <label for="inputPrice">Precio:
                    <input id="inputPrice" type="text" name="inputPrice"/>
                </label>
                <label for="urlImage">Url Imagen:
                    <input id="urlImage" type="url" name="urlImage" />
                </label>
                <input type="submit" value="Create" />
            </form>
        </div>
    </body>
</html>
