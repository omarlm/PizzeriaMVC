<%-- 
    Document   : login
    Created on : 03-abr-2017, 20:02:05
    Author     : omarl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="http://icono-49d6.kxcdn.com/icono.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Work+Sans" >
        <link rel="stylesheet" href="css/style.css">
        <title>Pizzeria - Login</title>
    </head>
    <body>
        <header>
            <div class="container">
                <img src="${pageContext.request.contextPath}/images/pizza.png" alt="logo" class="logo"/>
            </div>
        </header>
        <div class="login-form">
            <h2>Login</h2>
            <form action="login" method="post">
                <label for="user">User</label>
                <input type="text" name="user" placeholder="user" required="required" />
                <label for="userpass">Password</label>
                <input type="password" name="userpass" placeholder="password" required="required" />
                <input type="submit" value="Login" />
            </form>
        </div>
    </body>
</html>
