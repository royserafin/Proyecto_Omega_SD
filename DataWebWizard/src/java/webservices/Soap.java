/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import static java.lang.System.out;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rodri
 */
@WebService(serviceName = "Soap")
@Stateless()
public class Soap {

    private Object[][] ResultSetToArray(ResultSet rs) {
        Object data[][] = null;
        try {
            rs.last();
            ResultSetMetaData rsmd = rs.getMetaData();
            int numCols = rsmd.getColumnCount();
            int numRows = rs.getRow();
            data = new Object[numRows][numCols];
            int j = 0;
            rs.beforeFirst();
            while (rs.next()) {
                for (int i = 0; i < numCols; i++) {
                    data[j][i] = rs.getObject(i + 1);
                }
                j++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return data;
    }

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "mostrarTablas")
    public String mostrarTablas(@WebParam(name = "idUsuario") String usuario) {
        boolean res = false;
        String resp="";
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Omega;create=true;",
                    "root", "root");
            Statement query = con.createStatement();
            String QueryString = "select nombre_tabla from tablas_usuarios where id_usuario = " + usuario;
            ResultSet rs = query.executeQuery(QueryString);
            out.println("<p>");
            while (rs.next()) {
                String tupla =rs.getString("nombre_tabla");
                resp=resp+"<option>"+tupla+"</option>";
                out.println("<br>" + tupla);
            }
            

            //TODO write your implementation code here:
            res = true;
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Soap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Soap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "crearTabla")
    public Boolean crearTabla(@WebParam(name = "nombre") String nombre, @WebParam(name = "idUsuario") String usuario) {
        boolean res = false;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Omega;create=true;",
                    "root", "root");
            Statement query = con.createStatement();
            String QueryString = "create table " + nombre + " (id int not null, primary key(id))";
            query.executeUpdate(QueryString);
            con.commit();
            QueryString = "insert into tablas_usuarios values (" + usuario + ", '" + nombre + "')";
            Statement query2 = con.createStatement();
            query2.executeUpdate(QueryString);
            con.commit();

            //TODO write your implementation code here:
            res = true;
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Soap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Soap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "borrarTabla")
    public Boolean borrarTabla(@WebParam(name = "idUsuario") String usuario, @WebParam(name = "nombreTabla") String nombre) {
        boolean res = false;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Omega;create=true;",
                    "root", "root");
            Statement query = con.createStatement();
            String QueryString = "drop table " + nombre;
            query.executeUpdate(QueryString);
            con.commit();
            QueryString = "delete from tablas_usuarios where id_usuario= " + usuario +" and nombre_tabla = '" + nombre + "'";
            Statement query2 = con.createStatement();
            query2.executeUpdate(QueryString);
            con.commit();

            //TODO write your implementation code here:
            res = true;
            con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Soap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Soap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
