package uah.es.moviesbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uah.es.moviesbackend.dao.IMoviesDAO;
import uah.es.moviesbackend.model.Movie;

import java.util.List;

@Service
public class MoviesServiceImpl implements IMoviesService {

    @Autowired
    IMoviesDAO moviesDAO;

    @Override
    public List<Movie> findAll() {
        return moviesDAO.findAll();
    }

    @Override
    public Movie findMovieById(Integer id) {
        return moviesDAO.findMovieById(id);
    }

    @Override
    public List<Movie> findMovieByTitle(String title) {
        return moviesDAO.findMovieByTitle(title);
    }

    @Override
    public List<Movie> findMovieByGenre(String genre) {
        return moviesDAO.findMovieByGenre(genre);
    }

    @Override
    public List<Movie> findMovieByActor(String actorName) {
    return moviesDAO.findMovieByActor(actorName);
    }

    @Override
    public void createMovie(Movie movie) {
        moviesDAO.createMovie(movie);
    }

    @Override
    public void updateMovie(Movie movie) {
        if (moviesDAO.findMovieById(movie.getId()) != null) {
            moviesDAO.updateMovie(movie);
        }
    }

    @Override
    public void deleteMovie(Integer idMovie) {
        if (moviesDAO.findMovieById(idMovie) != null) {
            moviesDAO.deleteMovie(idMovie);
        }
    }
}
