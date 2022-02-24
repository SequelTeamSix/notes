package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class MovieRepository {

    public void addMovie(Movie m)  {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(m);
            transaction.commit();
            session.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
