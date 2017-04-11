<%-- 
    Document   : insertOfer
    Created on : 10-abr-2017, 15:41:44
    Author     : omarl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="css/style.css">
        <title>Pizzeria - Insertar Oferta</title>
    </head>
    <body>
        <nav id="main-menu">
            <ul class="nav-bar">
                <li><a href="${pageContext.request.contextPath}/loginSucess.jsp"><i class="icono-home"></i>Home</a></li>
                <li><a href=""><i class="icono-cross"></i>Log out</a></li>
                <li><a href="${pageContext.request.contextPath}/insertOfer.jsp"><i class="icono-plusCircle"></i>Insert Orfer</a></li>
                <li style="text-align: right">Username: <c:out value="${PRINCIPAL.login}" /></li>
            </ul>
        </nav>
        <div class="register">
            <form action="" method="post">
                <label for="inputName">Nombre</label>
                <input type="text" id="inputName" name="pizzaName" required="required" />
                <label for="selBase">Tipo de base</label>
                <select id="selBase" name="selBase">
                    <!--Hacer foreach de para sacar la base de la base de datos -->
                </select>
                <br />
                <label>Ingredientes</label>
                <input id="chkIngredient1" type="checkbox" value="1" name="ingredients"/> Mozzarella
                <input id="chkIngredient2" type="checkbox" value="2" name="ingredients"/> Champiñones
                <input id="chkIngredient3" type="checkbox" value="3" name="ingredients"/> Bacon
                <input id="chkIngredient4" type="checkbox" value="4" name="ingredients" /> Atún
                <label for="inputPrice">Precio</label>
                <input id="inputPrice" type="text" name="inputPrice"/>
                <label for="urlImage">Url Imagen</label>
                <input id="urlImage" type="url" name="urlImage" />
                <input type="submit" value="Create" />
            </form>
        </div>
    </body>
</html>
