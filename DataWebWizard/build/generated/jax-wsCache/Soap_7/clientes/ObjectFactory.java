
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

    private final static QName _BorrarTabla_QNAME = new QName("http://webservices/", "borrarTabla");
    private final static QName _BorrarTablaResponse_QNAME = new QName("http://webservices/", "borrarTablaResponse");
    private final static QName _CrearTabla_QNAME = new QName("http://webservices/", "crearTabla");
    private final static QName _CrearTablaResponse_QNAME = new QName("http://webservices/", "crearTablaResponse");
    private final static QName _Hello_QNAME = new QName("http://webservices/", "hello");
    private final static QName _HelloResponse_QNAME = new QName("http://webservices/", "helloResponse");
    private final static QName _MostrarTablas_QNAME = new QName("http://webservices/", "mostrarTablas");
    private final static QName _MostrarTablasResponse_QNAME = new QName("http://webservices/", "mostrarTablasResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: clientes
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BorrarTabla }
     * 
     */
    public BorrarTabla createBorrarTabla() {
        return new BorrarTabla();
    }

    /**
     * Create an instance of {@link BorrarTablaResponse }
     * 
     */
    public BorrarTablaResponse createBorrarTablaResponse() {
        return new BorrarTablaResponse();
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
     * Create an instance of {@link MostrarTablas }
     * 
     */
    public MostrarTablas createMostrarTablas() {
        return new MostrarTablas();
    }

    /**
     * Create an instance of {@link MostrarTablasResponse }
     * 
     */
    public MostrarTablasResponse createMostrarTablasResponse() {
        return new MostrarTablasResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BorrarTabla }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "borrarTabla")
    public JAXBElement<BorrarTabla> createBorrarTabla(BorrarTabla value) {
        return new JAXBElement<BorrarTabla>(_BorrarTabla_QNAME, BorrarTabla.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BorrarTablaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "borrarTablaResponse")
    public JAXBElement<BorrarTablaResponse> createBorrarTablaResponse(BorrarTablaResponse value) {
        return new JAXBElement<BorrarTablaResponse>(_BorrarTablaResponse_QNAME, BorrarTablaResponse.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MostrarTablas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "mostrarTablas")
    public JAXBElement<MostrarTablas> createMostrarTablas(MostrarTablas value) {
        return new JAXBElement<MostrarTablas>(_MostrarTablas_QNAME, MostrarTablas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MostrarTablasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices/", name = "mostrarTablasResponse")
    public JAXBElement<MostrarTablasResponse> createMostrarTablasResponse(MostrarTablasResponse value) {
        return new JAXBElement<MostrarTablasResponse>(_MostrarTablasResponse_QNAME, MostrarTablasResponse.class, null, value);
    }

}
