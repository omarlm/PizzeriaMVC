<%-- 
    Document   : insertSucess
    Created on : 14-abr-2017, 11:26:08
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
        <header>
            <div class="container">
                <img src="${pageContext.request.contextPath}/images/pizza.png" alt="logo" class="logo"/>
                <nav>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/loginSucess.jsp">Home</a></li>
                        <li><a href="">Log out</a></li>
                        <li><a href="${pageContext.request.contextPath}/insertOfer.jsp">Insert Orfer</a></li>
                        <li><c:out value="${PRINCIPAL.login}" /></li>
                    </ul>
                </nav>
            </div>
        </header>
    <body>
        <div class="register">
            <h1>Ofer inserted</h1>
            <a href="${pageContext.request.contextPath}/loginSucess.jsp"></i>Atrás</a>
        </div>
    </body>
</html>
