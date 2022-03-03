package hibernate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="director")

@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
    generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Director {
    @Id
    private int director_id;

    //we don't actually need the column annotations - hibernate will imply from the names of variable
    @Column
    private String name;

    @OneToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="director_id")
    @JsonIgnoreProperties(value="director")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getId() {
        return director_id;
    }

    public void setId(int id) {
        this.director_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + director_id +
                ", name='" + name + '\'' +
                '}';
    }
}
