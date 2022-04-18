package mx.uv.t4is.tareas;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class TareasConf {
    @Bean
    public XsdSchema tareasSchema() {
        return new SimpleXsdSchema(new ClassPathResource("todo.xsd"));
    }

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDistpatcheerServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name="tareas")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema tareas) {
        DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("tareasPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://t4is.uv.mx/todo");
        wsdl.setSchema(tareas);
        return wsdl;
    }
}
