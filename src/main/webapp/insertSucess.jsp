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
        <nav id="main-menu">
            <ul class="nav-bar">
                <li><a href="${pageContext.request.contextPath}/loginSucess.jsp"><i class="icono-home"></i>Home</a></li>
                <li><a href=""><i class="icono-cross"></i>Log out</a></li>
                <li><a href="${pageContext.request.contextPath}/insertOfer.jsp"><i class="icono-plusCircle"></i>Insert Orfer</a></li>
                <li style="text-align: right">Username: <c:out value="${PRINCIPAL.login}" /></li>
            </ul>
        </nav>
    <body>
        <div class="register">
            <h1>Ofer inserted</h1>
            <a href="${pageContext.request.contextPath}/loginSucess.jsp"></i>Atrás</a>
        </div>
    </body>
</html>
