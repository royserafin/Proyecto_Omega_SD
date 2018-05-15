/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservices;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
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
 * @author hca
 */
@Path("generic")
public class crear_DB {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of crear_DB
     */
    public crear_DB() {
    }

    /**
     * Retrieves representation of an instance of webservices.crear_DB
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml( @QueryParam("table_name")String name) {
        return "La información de la tabla: "+ name;
       }

    /**
     * PUT method for updating or creating an instance of crear_DB
     * @param content representation for the resource
     */
    @POST
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public String putHtml(@QueryParam("table_name")String name) {
        return "Se ha creado la nueva tabla con el nombre de: "+ name;
    }
    
    
    
   
    
    @DELETE
    @Consumes(MediaType.TEXT_HTML)
    @Produces(MediaType.TEXT_HTML)
    public String deleteHtml(@QueryParam("table_name")String name) {
        return "Se ha borrado la nueva tabla con el nombre de: "+ name;
    }
    
   
    
    
    
    
}
