package uah.es.moviesapi.dao;

import java.util.List;

import uah.es.moviesapi.model.Movie;

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
