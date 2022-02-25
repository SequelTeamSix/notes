package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.io.IOException;
import java.util.List;

public class MovieRepository {

    public boolean addMovie(Movie m)  {
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.persist(m);
            transaction.commit();
            session.close();
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
    /*starting criteria API*/
    public List<Movie> getAllMovies() {
        try {
            Session session = HibernateUtil.getSession();
            List<Movie> movieList;
            movieList = session.createCriteria(Movie.class).list();
            return movieList;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public Movie getMovieByID(int id) {
        try {
            Session session = HibernateUtil.getSession();
            Movie m = (Movie) session.createCriteria(Movie.class)
                            .add(Restrictions.eq(("movie_id"), id))
                            .uniqueResult();
            return m;

        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public Movie getMovie(Movie m){
        try {
            Session session = HibernateUtil.getSession();
            return session.get(Movie.class, m.getMovie_id());
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean updateMovie(Movie m){
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.merge(m);
            transaction.commit();
            return true;
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
