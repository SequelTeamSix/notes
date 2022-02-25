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
    @Column(name="director_id")
    private int id;

    //we don't actually need the column annotations - hibernate will imply from the names of variable
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "director", fetch=FetchType.EAGER)
    @JsonIgnoreProperties(value="director")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
