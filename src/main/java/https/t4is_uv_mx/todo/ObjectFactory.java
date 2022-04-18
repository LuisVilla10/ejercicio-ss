//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.3.2 
// Visite <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2022.04.17 a las 10:18:22 AM CDT 
//


package https.t4is_uv_mx.todo;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the https.t4is_uv_mx.todo package. 
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

    private final static QName _ObtenerToDosRequest_QNAME = new QName("https://t4is.uv.mx/todo", "ObtenerToDosRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: https.t4is_uv_mx.todo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AgregarToDoRequest }
     * 
     */
    public AgregarToDoRequest createAgregarToDoRequest() {
        return new AgregarToDoRequest();
    }

    /**
     * Create an instance of {@link ObtenerToDosResponse }
     * 
     */
    public ObtenerToDosResponse createObtenerToDosResponse() {
        return new ObtenerToDosResponse();
    }

    /**
     * Create an instance of {@link AgregarToDoRequest.ToDo }
     * 
     */
    public AgregarToDoRequest.ToDo createAgregarToDoRequestToDo() {
        return new AgregarToDoRequest.ToDo();
    }

    /**
     * Create an instance of {@link AgregarToDoResponse }
     * 
     */
    public AgregarToDoResponse createAgregarToDoResponse() {
        return new AgregarToDoResponse();
    }

    /**
     * Create an instance of {@link ObtenerToDosResponse.ToDo }
     * 
     */
    public ObtenerToDosResponse.ToDo createObtenerToDosResponseToDo() {
        return new ObtenerToDosResponse.ToDo();
    }

    /**
     * Create an instance of {@link EliminarToDoRequest }
     * 
     */
    public EliminarToDoRequest createEliminarToDoRequest() {
        return new EliminarToDoRequest();
    }

    /**
     * Create an instance of {@link EliminarToDoResponse }
     * 
     */
    public EliminarToDoResponse createEliminarToDoResponse() {
        return new EliminarToDoResponse();
    }

    /**
     * Create an instance of {@link ModificarToDoRequest }
     * 
     */
    public ModificarToDoRequest createModificarToDoRequest() {
        return new ModificarToDoRequest();
    }

    /**
     * Create an instance of {@link ModificarToDoResponse }
     * 
     */
    public ModificarToDoResponse createModificarToDoResponse() {
        return new ModificarToDoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "https://t4is.uv.mx/todo", name = "ObtenerToDosRequest")
    public JAXBElement<Object> createObtenerToDosRequest(Object value) {
        return new JAXBElement<Object>(_ObtenerToDosRequest_QNAME, Object.class, null, value);
    }

}
