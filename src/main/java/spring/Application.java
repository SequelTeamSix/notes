package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.model.Pokemon;
import spring.service.PokemonService;

import java.util.List;

public class Application {

    public static void main(String[] args){

        //extension of bean factory: applicationcontext allows for annotation
//        configuration and beanfactory does not
        /*this thing is kind of like the big container of all the potential objects
        that are beans
         */
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PokemonService pokeServ = context.getBean(PokemonService.class);
        PokemonService pokeServ2 = context.getBean(PokemonService.class);

        List<Pokemon> pokeList= pokeServ.getAllPokemon();

        for(Pokemon p : pokeList){
            System.out.println(p);
        }

        /*What is Spring?
           Spring is a Java development ECOSYSTEM
           It reduces a great amount of boiler plate code that is common in full-stack applications
           (or at least the backend part of it)

           Spring contains many many modules:
           Spring Core
           Spring MVC
           Spring Boot
           Spring AOP
           Spring Data
           Spring ORM

           The core of Spring revolves around something called dependency injection...
                Dependency injection is all about giving up instantation/control of dependencies
                to another entity
                    Dependencies?
                        In our case, consider that a Service layer may be dependedent on the existence
                            of a DAO layer

                    It manages this through something called the IOC container
                        IOC: Inversion of control
                            We no longer control the instantiation of object dependencies
                        IOC container: the part of our program where all of our beans
                            are stored: applicationcontext

                    How these are managed:
                        IOC container:
                            BeanFactory
                            ApplicationContext
                                extends BeanFactory, and instantiates all beans at startup rather than lazilly
                                also allows of AOP

                        What's a bean?
                            A Spring bean is just an object that's managed by Inversion of Control

                    OK..... how do I add my objects to Spring IOC
                    2 ways:
                        the old way: XML
                        the new way: Annotations
            Bean Scopes:
                Singleton : single bean shared within an IOC container
                Prototype : a new bean is generated whenever requested
                    (like how we usually think of java objects)

                Of these two, which one do you all think is default?

                Request : single bean per http request
                Session : single bean per http session
                GlobalSession : single bean per entire sessionFactory (for session scope)
                Websocket : lifecycle of a Websocket (don't worry about it)
                Application : used in web application (don't worry about it)

            In addition, there are different ways to inject:
                Constructor injection;
                Setter injection;
                Field inject

            There are different types of autowiring:
            no autowiring,
            by type,
            by name,
            by constructor

            we can use @Qualifier to identify a specific bean we'd like to use

            Is there manual wiring, too?
                yes... but at that point we're missing the point of IOC

            Component scanning?
            Spring can scan for components for us
            We intially enabled this in the xml file we used...
            to find classes that could potentially be beans

            Components will automatically know how they should be instantiated
            by the IOC container, but we can also manually designate the method
            that instantiates a bean with @Bean
         */
    }
}
