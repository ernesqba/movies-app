package uah.es.moviesapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uah.es.moviesapi.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public class MoviesDAOImpl implements IMoviesDAO {

    @Autowired
    IMoviesJPA moviesJPA;

    @Override
    public List<Movie> findAll() {
        return moviesJPA.findAll();
    }

    @Override
    public Movie findMovieById(Integer id) {
        Optional<Movie> optional = moviesJPA.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Movie> findMovieByTitle(String title) {
        return moviesJPA.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Movie> findMovieByGenre(String genre) {
        return moviesJPA.findByGenreContainingIgnoreCase(genre);
    }

    @Override
    public List<Movie> findMovieByActor(String actorName) {
        return moviesJPA.findByActorName(actorName);
    }

    @Override
    public void createMovie(Movie movie) {
        moviesJPA.save(movie);
    }

    @Override
    public void deleteMovie(Integer id) {
        moviesJPA.deleteById(id);
    }

    @Override
    public void updateMovie(Movie movie) {
        moviesJPA.save(movie);
    }
}
