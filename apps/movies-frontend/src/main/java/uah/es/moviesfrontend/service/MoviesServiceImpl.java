package uah.es.moviesfrontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uah.es.moviesfrontend.model.Movie;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class MoviesServiceImpl implements IMoviesService {

    @Autowired
    RestTemplate template;

    String url = System.getenv("BACKEND_URL") + "/movies";

    @Override
    public Page<Movie> findAll(Pageable pageable) {
        Movie[] movies = template.getForObject(url, Movie[].class);
        List<Movie> moviesList = Arrays.asList(movies);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Movie> list;

        if (moviesList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, moviesList.size());
            list = moviesList.subList(startItem, toIndex);
        }

        Page<Movie> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), moviesList.size());
        return page;
    }

    @Override
    public Movie findMovieById(Integer idMovie) {
        Movie movie = template.getForObject(url + "/" + idMovie, Movie.class);
        return movie;
    }

    @Override
    public Page<Movie> findMoviesByTitle(String title, Pageable pageable) {
        Movie[] movies = template.getForObject(url + "/name/" + title, Movie[].class);
        List<Movie> movieList = Arrays.asList(movies);
        Page<Movie> page = new PageImpl<>(movieList, pageable, movieList.size());
        return page;
    }

    @Override
    public Page<Movie> findMoviesByGenre(String genre, Pageable pageable) {
        Movie[] movies = template.getForObject(url + "/genre/" + genre, Movie[].class);
        List<Movie> movieList = Arrays.asList(movies);
        Page<Movie> page = new PageImpl<>(movieList, pageable, movieList.size());
        return page;
    }

    @Override
    public Page<Movie> findMoviesByActor(String actorName, Pageable pageable) {
        Movie[] movies = template.getForObject(url + "/actor/" + actorName, Movie[].class);
        List<Movie> movieList = Arrays.asList(movies);
        Page<Movie> page = new PageImpl<>(movieList, pageable, movieList.size());
        return page;
    }

    @Override
    public void createMovie(Movie movie) {
        template.postForObject(url, movie, String.class);
    }

    @Override
    public void updateMovie(Movie movie) {
        template.put(url, movie);

    }

    @Override
    public void deleteMovie(Integer id) {
        template.delete(url + "/" + id);
    }
}
