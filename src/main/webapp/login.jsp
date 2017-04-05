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
        <link rel="stylesheet" href="css/style.css">
        <title>Pizzeria - Login</title>
    </head>
    <body>
        <div id="login">
            <div class="form">
                <form action="login" method="post">
                    <span class="fontawesome-user"></span><input type="text" name="user" required="required" />
                    <span class="fontawesome-lock"></span><input type="password" name="userpass" required="required" />
                    <input type="submit" value="Login" />
                </form>
            </div>
        </div>
    </body>
</html>
