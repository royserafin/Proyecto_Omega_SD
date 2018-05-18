<%-- 
    Document   : usuario
    Created on : 17/05/2018, 01:22:32 PM
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body class="container">
        <%
            HttpSession mySession = request.getSession();
            if (mySession.getAttribute("nombre") != null && mySession.getAttribute("contrasena") != null) {
                out.print("<h1>Bienvenido " + mySession.getAttribute("nombre") + "</h1><br>");
                String usuario = mySession.getAttribute("idUsuario").toString();

            } else {

                out.print("Sesión no iniciada");
                out.print("<a href='index.jsp'>Iniciar sesión</a>");

            }

        %>



        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>



            function callRESTfulWebService(id, method, target, msg) {
                var ajaxRequest;
                if (window.XMLHttpRequest) {
                    ajaxRequest = new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
                } else {
                    ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
                }
                ajaxRequest.onreadystatechange = function () {
                    window.alert(ajaxRequest.readyState + " " + ajaxRequest.status + " " + target);
                    if (ajaxRequest.readyState == 4 &&
                            (ajaxRequest.status == 200 || ajaxRequest.status == 204)) {
                        document.getElementById(id).innerHTML = ajaxRequest.responseText;
                    }
                }
                target = target + "?" + "table_name=" + document.getElementById("table_name").value +
                        "&" + "idUsuario=" + document.getElementById("idUsuario").innerHTML;
                ajaxRequest.open(method, target, true /*async*/);
                ajaxRequest.setRequestHeader("Content-Type", "text/html");
                ajaxRequest.send(msg);
            }

            function callRESTfulWebServiceGET(id, method, target, msg) {
                var ajaxRequest;
                if (window.XMLHttpRequest) {
                    ajaxRequest = new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
                } else {
                    ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
                }
                ajaxRequest.onreadystatechange = function () {
                    window.alert(ajaxRequest.readyState + " " + ajaxRequest.status + " " + target);
                    if (ajaxRequest.readyState == 4 &&
                            (ajaxRequest.status == 200 || ajaxRequest.status == 204)) {
                        document.getElementById(id).innerHTML = ajaxRequest.responseText;
                    }
                }
                target = target + "?" + "idUsuario=" + document.getElementById("idUsuario").innerHTML;
                ajaxRequest.open(method, target, true /*async*/);
                ajaxRequest.setRequestHeader("Content-Type", "text/html");
                ajaxRequest.send(msg);
            }

            function callRESTfulWebServiceDELETE(id, method, target, msg) {
                var ajaxRequest;
                if (window.XMLHttpRequest) {
                    ajaxRequest = new XMLHttpRequest(); // IE7+, Firefox, Chrome, Opera, Safari
                } else {
                    ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP"); // IE6, IE5
                }
                ajaxRequest.onreadystatechange = function () {
                    window.alert(ajaxRequest.readyState + " " + ajaxRequest.status + " " + target);
                    if (ajaxRequest.readyState == 4 &&
                            (ajaxRequest.status == 200 || ajaxRequest.status == 204)) {
                        document.getElementById(id).innerHTML = ajaxRequest.responseText;
                    }
                }
                target = target + "?" + "idUsuario=" + document.getElementById("idUsuario").innerHTML +
                        "&" + "nombreTabla=" + document.getElementById("tablas").value;
                ajaxRequest.open(method, target, true /*async*/);
                ajaxRequest.setRequestHeader("Content-Type", "text/html");
                ajaxRequest.send(msg);
            }

            $(document).ready(function () {
                callRESTfulWebServiceGET("tablas", "GET", "http://localhost:8080/DataWebWizard/webresources/MyPath", "");
            })


        </script>
        <script>
            var req;
            function creaCadena() {
                req = "";
                var i;
                var val = "val";
                for (i = 0; i < document.getElementById("nuevosCampos").childElementCount; i++) {
                    val = "val" + (i + 1);
                    window.alert(val);
                    req += "&campo" + i + "=" + document.getElementById("nuevosCampos").innerHTML;
                    window.alert(req);
                }


            }
        </script>

        <div id="idUsuario"><%=mySession.getAttribute("idUsuario")%></div>

        <%-- Mostrar tablas --%>
        <h2>Crea una nueva tabla</h2>

        Nombre tabla:  
        <br>
        <input id="table_name" type="text" name="nombre_tabla" />
        <br>

        <br>
        <br>
        Nombre y tipo de campo (Se agregará primary key id por default):
        <br>
        <br>

        <table>
            <tr>
                <td valign=top>
                    <div id="nuevosCampos">
                        <div id="val1" class="feed">
                            Nombre campo:<input type="text" name="campos" value="">
                            Tipo:<select name="tipos">
                                <option>boolean</option>
                                <option>varchar</option>
                                <option>double</option>
                                <option>int</option>
                                <option>real</option>
                                <option>char</option>
                            </select>
                            <br>
                        </div>                           
                    </div>
                </td>
            </tr>
        </table>
        <p id="addnew">
            <a href="javascript:add_feed()">Agregar campo</a>
            <a href="javascript:delete_feed()">Remover campo</a>
        </p>

        <br>
        <br>

        <input  class="btn btn-primary btn-lg btn-block" type="submit" value="Crear tabla" onclick="creaCadena();callRESTfulWebService('result', 'PUT', 'http://localhost:8080/DataWebWizard/webresources/MyPath', '')"/>

        <!-- Template. This whole data will be added directly to working form above -->
        <div id="nuevoCampo" style="display:none">
            Nombre campo:<input type="text" name="campos" value="">
            Tipo:<select name="tipos" >
                <option>boolean</option>
                <option>varchar</option>
                <option>double</option>
                <option>int</option>
                <option>real</option>
                <option>char</option>
            </select>
            <br>
        </div>

        <script>
            var ct = 1;


            function add_feed()
            {
                ct++;
                var div1 = document.createElement('div');
                div1.id = "val" + ct;
                div1.class = "feed";
                // Get template data
                div1.innerHTML = document.getElementById('nuevoCampo').innerHTML;

                // append to our form, so that template data
                //become part of form
                document.getElementById('nuevosCampos').appendChild(div1);
            }
            function delete_feed()
            {
                if (ct > 1) {
                    d = document;
                    var ele = d.getElementById("val" + ct);
                    ct--;
                    var parentEle = d.getElementById('nuevosCampos');
                    parentEle.removeChild(ele);
                } else {
                    alert("Insertar al menos un campo");
                }

            }
        </script>

        <div id="result"></div>
        <div id="result2"></div>
        <div id="user_tables">

            <table border="1">
                <tbody>
                <h2>Tus tablas</h2>
                <tr>
                    <td><select  id="tablas" name="table_dropdown"  >
                            <option ></option>
                            <option></option>
                            <option></option>
                            <option></option>
                            <option></option>
                            <option></option>
                        </select></td>
                    <td><input  class="btn btn-primary" type="submit" value="Ver Tabla" name="ver" /></td>
                    <td><input  class="btn btn-primary" type="submit" value="Editar Tabla" name="editar" /></td>
                    <td><input  class="btn btn-primary" type="submit" value="Borrar Tabla" name="borrar" onclick="callRESTfulWebServiceDELETE('result2', 'DELETE', 'http://localhost:8080/DataWebWizard/webresources/MyPath', '')"/></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div id="selected_table">

        </div>
        
    </body>
</html>
