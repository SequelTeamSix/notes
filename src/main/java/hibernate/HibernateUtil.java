package hibernate;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


// TODO: Implement me
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static Session getSession() throws IOException {
        if(sessionFactory == null) {
            Configuration configuration = new Configuration();
            Properties props = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            props.load(loader.getResourceAsStream("hibernate.properties"));

            // Add properties to our configuration
            configuration.setProperties(props);
            // ONE ADDITIONAL STEP I NEED TO INCLUDE
            /*
            configuration.addAnnotatedClass(Artist.class);
            configuration.addAnnotatedClass(Painting.class);
*/
            configuration.addAnnotatedClass(Director.class);
            configuration.addAnnotatedClass(Movie.class);

            // ServiceRegistry
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

            return sessionFactory.openSession();
        }



}