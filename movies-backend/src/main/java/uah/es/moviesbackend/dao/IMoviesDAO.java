package uah.es.moviesbackend.dao;

import uah.es.moviesbackend.model.Movie;

import java.util.List;

public interface IMoviesDAO {

    List<Movie> findAll();

    Movie findMovieById(Integer id);

    List<Movie> findMovieByTitle(String title);

    List<Movie> findMovieByGenre(String title);

    List<Movie> findMovieByActor(String actorName);

    void createMovie(Movie movie);

    void deleteMovie(Integer idMovie);

    void updateMovie(Movie movie);

}
