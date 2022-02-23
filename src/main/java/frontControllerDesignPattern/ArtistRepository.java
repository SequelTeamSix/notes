package frontControllerDesignPattern;

import com.revature.model.Artist;

import java.util.ArrayList;
import java.util.List;

public class ArtistRepository {

    List<Artist> as= new ArrayList<Artist>();
    public ArtistRepository() {
        as.add(new Artist("Kandinsky", 1));
        as.add(new Artist("Klee", 1));
        as.add(new Artist("Varo", 1));
    }

    public Artist getArtist(int num){
        return as.get(num);
    }
    public List<Artist> getAllArtists(){
        return as;
    }
}
