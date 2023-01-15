package uah.es.moviesbackend.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "actors", schema = "movies_db", catalog = "")
public class Actor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "birth_date")
    private Date birthDate;
    @Basic
    @Column(name = "birth_country")
    private String birthCountry;

    @ManyToMany
    @JoinTable(name = "movie_casting", joinColumns = {
            @JoinColumn(name = "movie_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "actor_id", referencedColumnName = "id") })

    @JsonIgnoreProperties("actors")
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Actor curso = (Actor) o;
        return Objects.equals(id, curso.id) && Objects.equals(name, curso.name)
                && Objects.equals(birthDate, curso.birthDate)
                && Objects.equals(birthCountry, curso.birthCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, birthCountry);
    }
}
