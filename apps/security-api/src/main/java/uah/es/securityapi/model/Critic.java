package uah.es.securityapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "critics", schema = "usersdbsec")
public class Critic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "opinion")
    private String opinion;

    @Column(name = "date", insertable = false, updatable = false)
    private Date date;

    @Column(name = "movies_id")
    private Integer moviesId;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("critics")
    private User user;

    public Critic() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getMoviesId() {
        return moviesId;
    }

    public void setMoviesId(Integer moviesId) {
        this.moviesId = moviesId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Critic))
            return false;
        Critic critic = (Critic) o;
        return Objects.equals(id, critic.id)
                && Objects.equals(rating, critic.rating)
                && Objects.equals(opinion, critic.opinion)
                && Objects.equals(moviesId, critic.moviesId)
                && Objects.equals(user,
                        critic.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, opinion, user, moviesId);
    }
}