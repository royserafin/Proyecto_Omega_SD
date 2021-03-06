
package clientes;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "Soap", targetNamespace = "http://webservices/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Soap {


    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://webservices/", className = "clientes.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://webservices/", className = "clientes.HelloResponse")
    @Action(input = "http://webservices/Soap/helloRequest", output = "http://webservices/Soap/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

    /**
     * 
     * @param nombre
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "crearTabla", targetNamespace = "http://webservices/", className = "clientes.CrearTabla")
    @ResponseWrapper(localName = "crearTablaResponse", targetNamespace = "http://webservices/", className = "clientes.CrearTablaResponse")
    @Action(input = "http://webservices/Soap/crearTablaRequest", output = "http://webservices/Soap/crearTablaResponse")
    public Boolean crearTabla(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre);

}
