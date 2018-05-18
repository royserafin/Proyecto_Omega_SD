/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
    @WebMethod(operationName = "crearTabla")
    public Boolean crearTabla(@WebParam(name = "nombre") String nombre) {
        boolean res = false;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Omega;create=true;",
                    "root", "root");
            Statement query = con.createStatement();
            String QueryString = "create table " + nombre + "(id int not null, primary key(id))";
            //TODO write your implementation code here:
            res=true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Soap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Soap.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }
}
