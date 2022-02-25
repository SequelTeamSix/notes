package hibernate;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;

public class driver {
    public static void main(String[] args) {
        /*native sql hibernate query
        basically, this is bad
        it's bad especially because this isn't dialect agnostic
        if we need to switch between dialects of sql, native sql will have to be changed
        for instance from azure sql to postgres
         */

        /*

         */

        /*there are two forms of adding objects via hibernate:
        session.persist(object)
            inserts object at the commit of transaction
            more acid compliant
        session.save(object)
            inserts object immediately
         */
        /*HQL
        * hibernate query language
        * it's a query language similar to sql, but it's
        * dialect agnostic
        * so we can switch between whatever dialect was designated in the properties file
        * */

        DirectorService ds = new DirectorService();
        MovieService ms = new MovieService();

        Director d1 = new Director();
        d1.setId(1);
        d1.setName("Tarkovsky");
        Director d2 = new Director();
        d2.setId(2);
        d2.setName("Cronenberg");
        ds.addDirector(d1);
        ds.addDirector(d2);

        List<Director> directors= ds.getAllDirectors();
        for(Director d : directors){
            System.out.println(d);
        }
        //Transient state
        //we have a java object, but that java object has not been persisted to the database yet
        Movie m1 = new Movie();
        m1.setMovie_id(1);
        m1.setTitle("Solaris");
        m1.setDirector(d1);
        //Persistent object
        //we have a java object that is currently being persisted into the database
        ms.addMovie(m1);

        m1.setYear(1970);
        m1.setGenre("Romance");
        ms.updateMovie(m1);
        List<Movie> myMovies = ms.getAllMovies();
        for(Movie m : myMovies){
            System.out.println(m);
        }

        //Detached state
        //we have a java object that has been detached from its session
        //so changes in the object are not reflected in the database any more, nor are changes in the
        //database reflected in the object
        //we can force an object into the detached state by using session.evict(object)

        /*for making queries in hibernate, we could also use the criteria API:
        the criteria api works such that we are no longer writing any sort of string statement,
        rather we are getting all the data we need using methods
        which allows for compile time checking
         */

        /*for multiplicity:
        how do we handle it?
        we need additional annotations in our model classes.....
        @OneToMany
        @ManyToOne
        @ManyToMany
        @OneToOne
         */

        /*an advantage to using Object relational mapping:
        if we want to perform a CRUD operation,
        we often have multiple ways to do this
        (I suppose using native SQL is an option, but this defeats the purpose of using hibernate)

        CREATE:
        save(object) - immediately inserts an object to the database
        persist(object) - inserts the object at the end of transaction

        UPDATE:
        merge() - used to send back into persistence an object which we've already detached
        (detached review - detached means that either the object has been .evict() or the session it belonged
        to has closed)
        if merge used with transient object, it will persist it
        update()
        may only be used on a persisted or detached object

        READ:
        load()
        returns a proxy (reference) of an object from persistence
        if no matches in database: return null
        get()
        immediately returns a mapped object
        if no matches: throw an error

        DELETE:
        delete() a persisted object

         */

        /*lazy vs eager fetching:
        lazy: entries received from joins are fetched from the database only when they are requested
        eager: entries received from joins are fetched together with the object
        it's a performance thing

        two issues with this:
        1: what if we try to lazily fetch from a detached object?
        lazy initialization error: in order to lazily fetch, our objects should be persisted

        BUT:
        2: what if we have both objects in a join eagerly fetched,
        wouldn't they just fall into a loop of fetching each other?
        in the case of creating json/string representations of the objects, yes!
        so, if you get a stackoverflow error with hibernate, this is likely why
         */

    }
}
