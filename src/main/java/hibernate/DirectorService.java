package hibernate;

import org.hibernate.Session;

import java.util.List;

public class DirectorService {
    DirectorRepository dr;
    public DirectorService(){
        dr = new DirectorRepository();
    }
    public List<Director> getAllDirectors(){
        return dr.getAllDirectors();
    }
    public Director getDirectorById(int id){
        return dr.getDirectorById(id);
    }
    public boolean addDirector(Director d){
        if(dr.getDirectorById(d.getId()) == null){
            return dr.addDirector(d);
        }else{
            return false;
        }
    }
    public List<Movie> getAllDirectorsMovies(Director director, Session session){
        return dr.getAllDirectorsMovies(director, session);
    }
}
