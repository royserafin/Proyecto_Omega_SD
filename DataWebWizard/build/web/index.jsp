<%-- 
    Document   : index
    Created on : 17/05/2018, 01:05:08 PM
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="POST">
            <table  border="1">
                <tbody>
                    <tr>
                        <td>Usuario</td>
                        <td><input type="text" name="nombre" value="" /></td>
                    </tr>
                    <tr>
                        <td>Contraseña</td>
                        <td><input type="password" name="contrasena" value="" /></td>
                    </tr>
                </tbody>
            </table>
            <input class="btn btn-primary btn-lg btn-block" type="submit" value="Ingresar" />
        </form>
        <a href='registro.jsp'>Registrarse</a>
        
    </body>
</html>
