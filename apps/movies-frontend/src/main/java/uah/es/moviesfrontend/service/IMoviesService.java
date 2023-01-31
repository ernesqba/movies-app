package uah.es.moviesfrontend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uah.es.moviesfrontend.model.Movie;

public interface IMoviesService {

    Page<Movie> findAll(Pageable pageable);

    Movie findMovieById(Integer id);

    Page<Movie> findMoviesByTitle(String title, Pageable pageable);

    Page<Movie> findMoviesByGenre(String genre, Pageable pageable);

    Page<Movie> findMoviesByActor(String actorName, Pageable pageable);

    void createMovie(Movie movie);

    void deleteMovie(Integer idMovie);

    void updateMovie(Movie movie);

}
