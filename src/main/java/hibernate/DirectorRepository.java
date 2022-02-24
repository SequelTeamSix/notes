package hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;

public class DirectorRepository {
    public boolean addDirector(Director d){
        try {
            Session session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            if(getDirectorById(d.getId())==null) {
                session.persist(d);
                transaction.commit();
                session.close();
                return true;
            }

        }catch(HibernateException | IOException e){
            //e.printStackTrace();
        }
        return false;
    }
    public List<Director> getAllDirectors(){
        try {
            Session session = HibernateUtil.getSession();
            List<Director> directorList = session.createQuery("FROM Director", Director.class).list();
            session.close();
            return directorList;
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return null;
    }

    public Director getDirectorById(int id){
        try {
            Session session = HibernateUtil.getSession();
            Query query = session.createQuery("FROM Director WHERE director_id = :id", Director.class);
            query.setParameter("id", id);
            List<Director> directorList = query.list();
            session.close();
            if(directorList.size()==1){
                return directorList.get(0);
            }else{
                return null;
            }
        }catch(HibernateException | IOException e){
            e.printStackTrace();
        }finally{
        }
        return null;
    }
}
