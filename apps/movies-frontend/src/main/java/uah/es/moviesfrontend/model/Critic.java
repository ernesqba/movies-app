package uah.es.moviesfrontend.model;

import java.sql.Date;

public class Critic {

    private Integer id;
    private Integer rating;
    private String opinion;
    private Date date;
    private Integer moviesId;
    private User user;
    private Movie movie;

    public Critic(Integer id, Integer rating, String opinion, Date date, Integer moviesId, User user) {
        this.id = id;
        this.rating = rating;
        this.opinion = opinion;
        this.date = date;
        this.moviesId = moviesId;
        this.user = user;
    }

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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
