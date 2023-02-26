package uah.es.moviesapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import uah.es.moviesapi.model.Movie;
import uah.es.moviesapi.service.IMoviesService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    IMoviesService moviesService;

    @GetMapping()
    public List<Movie> findAll() {
        return moviesService.findAll();
    }

    @GetMapping("/{id}")
    public Movie findMovieById(@PathVariable("id") Integer id) {
        return moviesService.findMovieById(id);
    }

    @GetMapping("/name/{name}")
    public List<Movie> findMovieByTitle(@PathVariable("name") String name) {
        return moviesService.findMovieByTitle(name);
    }

    @GetMapping("/genre/{name}")
    public List<Movie> findMovieByGenre(@PathVariable("name") String genre) {
        return moviesService.findMovieByGenre(genre);
    }

    @GetMapping("/actor/{name}")
    public List<Movie> findMovieByActor(@PathVariable("name") String actorName) {
        return moviesService.findMovieByActor(actorName);
    }

    @PostMapping()
    public void createMovie(@RequestBody Movie movie) {
        moviesService.createMovie(movie);
    }

    @PutMapping()
    public void updateMovie(@RequestBody Movie movie) {
        moviesService.updateMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Integer id) {
        moviesService.deleteMovie(id);
    }

}
