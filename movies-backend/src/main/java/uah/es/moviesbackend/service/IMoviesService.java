package uah.es.moviesbackend.service;

import java.util.List;

import uah.es.moviesbackend.model.Movie;

public interface IMoviesService {

    List<Movie> findAll();

    Movie findMovieById(Integer id);

    List<Movie> findMovieByTitle(String title);

    List<Movie> findMovieByGenre(String genre);

    List<Movie> findMovieByActor(String actorName);

    void createMovie(Movie movie);

    void deleteMovie(Integer idMovie);

    void updateMovie(Movie movie);

}
