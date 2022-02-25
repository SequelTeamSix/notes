package hibernate;

import java.util.List;

public class MovieService {
    MovieRepository mr;
    public MovieService(){
        mr = new MovieRepository();
    }
    public List<Movie> getAllMovies(){
        return mr.getAllMovies();
    }
    public boolean addMovie(Movie m){
        if(mr.getMovie(m) == null) {
            return mr.addMovie(m);
        }
        return false;
    }
    public boolean updateMovie(Movie m){
        return mr.updateMovie(m);
    }
}
