
package clientes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the clientes package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CrearTabla_QNAME = new QName("http://webservices/", "crearTabla");
    private final static QName _CrearTablaResponse_QNAME = new QName("http://webservices/", "crearTablaResponse");
    private final static QName _Hello_QNAME = new QName("http://webservices/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://webservices/", "helloResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CrearTabla }
     * 
     */
    public CrearTabla createCrearTabla() {
        return new CrearTabla();
    }

    /**
     * Create an instance of {@link CrearTablaResponse }
     * 
     */
    public CrearTablaResponse createCrearTablaResponse() {
        return new CrearTablaResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearTabla }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "crearTabla")
    public JAXBElement<CrearTabla> createCrearTabla(CrearTabla value) {
        return new JAXBElement<CrearTabla>(_CrearTabla_QNAME, CrearTabla.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearTablaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "crearTablaResponse")
    public JAXBElement<CrearTablaResponse> createCrearTablaResponse(CrearTablaResponse value) {
        return new JAXBElement<CrearTablaResponse>(_CrearTablaResponse_QNAME, CrearTablaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

}
