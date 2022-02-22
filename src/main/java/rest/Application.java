package rest;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.servlet.ServletContainer;
import rest.config.RestConfig;

import java.io.File;

public class Application {
    public static void main(String[] args) throws LifecycleException , ServletException {
        /*
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        Context context = tomcat.addWebapp("/api", new File(".").getAbsolutePath());
        ServletContainer servletContainer = new ServletContainer(new RestConfig());
        //same as revpro example with adding a servlet mapping to XML
        tomcat.addServlet("/api", "restConfig", servletContainer);
        context.addServletMappingDecoded("/v1/*", "restConfig");
        tomcat.start();
        tomcat.getServer().await();
        */
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        Context context = tomcat.addWebapp("/api", new File(".").getAbsolutePath());
        ServletContainer servletContainer = new ServletContainer(new RestConfig());
        tomcat.addServlet("/api", "restConfig", (Servlet) servletContainer);
        context.addServletMappingDecoded("/v1/*", "restConfig");
        tomcat.start();
        tomcat.getServer().await();
    }
}
