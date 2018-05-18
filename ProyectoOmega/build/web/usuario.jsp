<%-- 
    Document   : usuario
    Created on : 13/05/2018, 02:51:49 PM
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
        <%
            HttpSession mySession=request.getSession();
            if(mySession.getAttribute("nombre")!=null && mySession.getAttribute("contrasena")!= null){
                out.print("<h1>Bienvenido "+ mySession.getAttribute("nombre") + "</h1><br>");
            } else{
                out.print("Usuario o contraseña incorrectos, por favor vuelve a intentar");
                out.print("<a href='index.jsp'>Iniciar sesión</a>");
            }
            
        %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
        function callRESTfulWebService(id, method, target, msg) {
        var ajaxRequest;
        if (window.XMLHttpRequest){
        ajaxRequest=new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
        } else {
        ajaxRequest=new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
        }
        ajaxRequest.onreadystatechange = function(){
        window.alert(ajaxRequest.readyState + " " + ajaxRequest.status + " " + target);
        if (ajaxRequest.readyState==4 &&
        (ajaxRequest.status==200 || ajaxRequest.status==204)){
        document.getElementById(id).innerHTML=ajaxRequest.responseText;
        
        }
        }
        target = target + "?" + "table_name=" + document.getElementById("table_name").value;
        ajaxRequest.open(method, target, true /*async*/);
        ajaxRequest.setRequestHeader("Content-Type", "text/html");
        ajaxRequest.send(msg);
        }
        
        
        
        // Añadir campo con jquery
        function add_field(){
            $(document).ready(function() {
            var max_fields = 20; //maximum input boxes allowed
            var wrapper = $("#fields_wrapper"); //Fields wrapper           
            var x = 1; //initlal text box count
            out.print("Entra funcion")
            if(x < max_fields){ //max input box allowed
            x++; //text box increment
            out.print("Entra if");
            $(wrapper).append('
                <td>Nombre campo<input id="field_name" type="text" name="nombre_tabla  " value="" /></td>
            '); //add input box
            }
        }
        
    </script>
    
        <h2>Tus tablas</h2>
        <%-- Mostrar tablas --%>
        <h2>Crea una nueva tabla</h2>
    <tr>
        <td>Nombre tabla:  <input id="table_name" type="text" name="nombre_tabla" value="tabla" /></td>
    </tr>           
            <table border="1">
                <tbody>
                    <tr id="fields_wrapper">
                        <td>Nombre campo<input id="field_name" type="text" name="nombre_tabla  " value="" /></td>
                        <td>Tipo <select name="type">
                                <option>Varchar</option>
                                <option>Integer</option>
                                <option>Double</option>
                                <option>String</option>
                            </select></td>
                    </tr>
                </tbody>
            </table>
            
            <input type="submit" value="Añadir campo" onclick="add_field()"/>

            <input type="submit" value="Crear tabla" onclick="callRESTfulWebService(
             'result',
             'POST',
             'http://localhost:8080/ProyectoOmega/webresources/generic','')"/>
    <div id="result"></div>
    <div id="user_tables">
    <table border="1">
        <tbody>
            <h2>Tus tablas</h2>
            <tr>
                <td><select name="table_dropdown">
                        <option></option>
                        <option></option>
                        <option></option>
                        <option></option>
                        <option></option>
                        <option></option>
                    </select></td>
                    <td><input type="submit" value="Ver Tabla" name="ver" /></td>
                    <td><input type="submit" value="Editar Tabla" name="editar" /></td>
                    <td><input type="submit" value="Borrar Tabla" name="borrar" /></td>
            </tr>
        </tbody>
    </table>
    </div>
    <div id="selected_table">
        
    </div>
    <div id="selected_table">
        
    </div>
    </body>
</html>
