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

        DirectorRepository dr = new DirectorRepository();
        MovieRepository mr = new MovieRepository();

        Director d1 = new Director();
        d1.setId(1);
        d1.setName("Tarkovsky");
        Director d2 = new Director();
        d2.setId(2);
        d2.setName("Cronenberg");
        dr.addDirector(d1);
        dr.addDirector(d2);

        List<Director> directors= dr.getAllDirectors();
        for(Director d : directors){
            System.out.println(d);
        }
        //Transient state
        //we have a java object, but that java object has not been persisted to the database yet
        Movie m = new Movie();
        m.setMovie_id(1);
        m.setTitle("Solaris");
        m.setDirector(d1);
        //Persistent object
        //we have a java object that is currently being persisted into the database
        mr.addMovie(m);
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














        /*
        String sql = "Select * from Artist";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        List<Object[]> artistList= (List<Object[]>) sqlQuery.list();
        List<Artist> artistList2= (List<Artist>) sqlQuery.list();
        System.out.println(artistList.size());

        List<Artist> artistList3= session.createCriteria(Artist.class).list();

        List<Artist> artistList4= session.createQuery("FROM Artist", Artist.class).list();

        for(int i = 0; i < artistList.size(); i++){
            System.out.println(artistList.get(i)[1]);
        }
        for(int i = 0; i < artistList2.size(); i++){
            System.out.println(artistList2.get(i));
        }
        for(int i = 0; i < artistList3.size(); i++){
            System.out.println(artistList3.get(i));
        }
        for(int i = 0; i < artistList4.size(); i++){
            System.out.println(artistList4.get(i));
        }*/
        /*
        Artist a1 = new Artist();
        a1.setName("Kandinsky");
        a1.setArtist_id(1);
        Artist a2 = new Artist();
        a2.setName("Klee");
        a2.setArtist_id(2);
        Transaction tr = session.beginTransaction();
        //session.save(a1);
        session.persist(a2);
        tr.commit();
        session.close();
        */

    }
}
