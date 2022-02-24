package hibernate;

import javax.persistence.*;

@Entity
@Table(name="movie")
public class Movie {
    @Id
    @Column(name="movie_id")
    private int movie_id;
    @Column
    private String title;
    @ManyToOne
    @JoinColumn(name = "director_id")
    public Director director;

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
