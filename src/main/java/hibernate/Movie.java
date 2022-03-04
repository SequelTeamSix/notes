package hibernate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name="movie")
@JsonIdentityInfo(
        //this is to stop recursive hibernate joins
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Movie {
    @Id
    @Column
    private int movie_id;
    @Column
    private String title;
    @ManyToOne
    @JoinColumn(name = "director_id")
    @JsonIgnoreProperties(value = {"movies", "id"})
    public Director director;
    @Column(nullable = true)
    public int year;
    @Column(nullable = true)
    public String genre;
    @ManyToMany
    @JoinTable(name="Performance")
    public Actor actor;
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id=" + movie_id +
                ", title='" + title + '\'' +
                '}';
    }
}
