package frontControllerDesignPattern;

import com.revature.model.Painting;

import java.util.ArrayList;
import java.util.List;

public class PaintingRepository {

    List<Painting> as= new ArrayList<Painting>();
    public PaintingRepository() {
        as.add(new Painting(1, "Composition", null, "Abstract", 0));
        as.add(new Painting(2, "Magic Fishes", null, "Abstract", 0));
        as.add(new Painting(3, "Garden of Love", null, "Surrealist", 0));
    }

    public Painting getPainting(int num){
        return as.get(num);
    }
    public List<Painting> getAllPaintings(){
        return as;
    }
}
