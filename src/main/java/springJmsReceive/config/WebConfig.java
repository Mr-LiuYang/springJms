package springJmsReceive.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by liuyang on 2017/6/27.
 */
public class WebConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();
        context.register(MvcConfiguration.class);
        context.register(ActiveMqConfig.class);
        context.register(ThreadConfig.class);
        context.setServletContext(servletContext);
        ServletRegistration.Dynamic dispatcher=servletContext.addServlet("diapatcher",new DispatcherServlet(context));
        dispatcher.addMapping("/");
        dispatcher.setLoadOnStartup(1);
    }
}
