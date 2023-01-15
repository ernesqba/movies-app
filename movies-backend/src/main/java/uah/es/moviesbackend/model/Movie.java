package uah.es.moviesbackend.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "movies", schema = "movies_db", catalog = "")
public class Movie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "year")
    private Integer year;
    @Basic
    @Column(name = "length")
    private Integer length;
    @Basic
    @Column(name = "country")
    private String country;
    @Basic
    @Column(name = "directed_by")
    private String directedBy;
    @Basic
    @Column(name = "genre")
    private String genre;
    @Basic
    @Column(name = "synopsis")
    private String synopsis;
    @Basic
    @Column(name = "image")
    private String image;

    @ManyToMany(mappedBy = "movies")
    @JsonIgnoreProperties("movies")
    private List<Actor> actors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDirectedBy() {
        return directedBy;
    }

    public void setDirectedBy(String directedBy) {
        this.directedBy = directedBy;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void addActor(Actor actor) {
        if (actor != null) {
            getActors().add(actor);
        }
    }

    public void removeActor(Actor actor) {
        if (actor != null) {
            getActors().remove(actor);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Movie curso = (Movie) o;
        return Objects.equals(id, curso.id) && Objects.equals(title, curso.title)
                && Objects.equals(year, curso.year) && Objects.equals(length, curso.length)
                && Objects.equals(country, curso.country) && Objects.equals(directedBy, curso.directedBy)
                && Objects.equals(genre, curso.genre)
                && Objects.equals(synopsis, curso.synopsis)
                && Objects.equals(image, curso.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, year, length, country, directedBy, genre, synopsis, image);
    }
}
