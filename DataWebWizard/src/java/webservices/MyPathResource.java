/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author rodri
 */
@Path("MyPath")
public class MyPathResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MyPathResource
     */
    public MyPathResource() {
    }

    /**
     * Retrieves representation of an instance of webservices.MyPathResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml( @QueryParam("idUsuario")String usuario) {
        String res =mostrarTablas(usuario);
        if(res.equals(""))
            return "No hay tablas";
        else
            return res;
       }

    /**
     * PUT method for updating or creating an instance of MyPathResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes("text/html")
    public String putHtml(@QueryParam("table_name")String name, @QueryParam("idUsuario")String usuario) {
        Boolean res=false;
        res = crearTabla(name, usuario);
        if(res)
        return "Se ha creado la nueva tabla con el nombre de: "+ name;
        else return "No se pudo crear la tabla" + usuario ;
    }
    
    @DELETE
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public String deleteHtml(@QueryParam("idUsuario")String usuario,@QueryParam("nombreTabla")String tabla) {
        Boolean res=false;
        res = borrarTabla(usuario, tabla);
        if(res)
        return "Se ha borrado la tabla con el nombre de: "+ tabla;
        else return "No se pudo borrar la tabla " + tabla ;
    }

    private static Boolean crearTabla(java.lang.String nombre, java.lang.String idUsuario) {
        clientes.Soap_Service service = new clientes.Soap_Service();
        clientes.Soap port = service.getSoapPort();
        return port.crearTabla(nombre, idUsuario);
    }

    private static String mostrarTablas(java.lang.String idUsuario) {
        clientes.Soap_Service service = new clientes.Soap_Service();
        clientes.Soap port = service.getSoapPort();
        return port.mostrarTablas(idUsuario);
    }

    private static Boolean borrarTabla(java.lang.String idUsuario, java.lang.String nombreTabla) {
        clientes.Soap_Service service = new clientes.Soap_Service();
        clientes.Soap port = service.getSoapPort();
        return port.borrarTabla(idUsuario, nombreTabla);
    }


    
    


    

    

    
}
