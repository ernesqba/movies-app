package uah.es.moviesfrontend.model;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Actor {
    private Integer id;
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;
    private String birthCountry;
    private List<Movie> movies;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        if (movie != null) {
            getMovies().add(movie);
        }
    }

    public void removeMovie(Movie movie) {
        if (movie != null) {
            getMovies().remove(movie);
        }
    }
}
