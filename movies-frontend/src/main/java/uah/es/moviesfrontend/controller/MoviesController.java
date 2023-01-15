package uah.es.moviesfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uah.es.moviesfrontend.model.Movie;
import uah.es.moviesfrontend.paginator.PageRender;
import uah.es.moviesfrontend.service.IMoviesService;

@Controller
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    IMoviesService moviesService;

    @GetMapping("/new")
    public String nuevo(Model model) {
        model.addAttribute("title", "Nueva película");
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "movies/formMovie";
    }

    @GetMapping("/find")
    public String buscar(Model model) {
        return "movies/searchMovie";
    }

    @GetMapping("/list")
    public String findAll(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Movie> list = moviesService.findAll(pageable);
        PageRender<Movie> pageRender = new PageRender<Movie>("/movies/list", list);
        model.addAttribute("title", "Listado de todas las películas");
        model.addAttribute("movieList", list);
        model.addAttribute("page", pageRender);
        return "movies/listMovie";
    }

    @GetMapping("/details/{id}")
    public String findMovieById(Model model, @PathVariable("id") Integer id) {
        Movie movie = moviesService.findMovieById(id);
        System.out.println(movie.getImage());
        model.addAttribute("movie", movie);
        return "movies/detailsMovie";
    }

    @GetMapping("/name")
    public String findMoviesByTitle(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam("title") String title) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Movie> movieList;
        if (title.equals("")) {
            movieList = moviesService.findAll(pageable);
        } else {
            movieList = moviesService.findMoviesByTitle(title, pageable);
        }
        PageRender<Movie> pageRender = new PageRender<Movie>("/list", movieList);
        model.addAttribute("title", "Listado de películas por nombre");
        model.addAttribute("movieList", movieList);
        model.addAttribute("page", pageRender);
        return "movies/listMovie";
    }

    @GetMapping("/genre")
    public String findMoviesByGenre(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam("genre") String genre) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Movie> movieList = moviesService.findMoviesByGenre(genre, pageable);
        PageRender<Movie> pageRender = new PageRender<Movie>("/list", movieList);
        model.addAttribute("title", "Listado de películas por género");
        model.addAttribute("movieList", movieList);
        model.addAttribute("page", pageRender);
        return "movies/listMovie";
    }

    @GetMapping("/actor")
    public String findMoviesByActor(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam("actor") String actorName) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Movie> movieList;
        if (actorName.equals("")) {
            movieList = moviesService.findAll(pageable);
        } else {
            movieList = moviesService.findMoviesByActor(actorName, pageable);
        }
        PageRender<Movie> pageRender = new PageRender<Movie>("/list", movieList);
        model.addAttribute("title", "Listado de películas por actor");
        model.addAttribute("movieList", movieList);
        model.addAttribute("page", pageRender);
        return "movies/listMovie";
    }

    @PostMapping("/save")
    public String saveMovie(Model model, Movie movie, RedirectAttributes attributes) {
        if (movie.getId() == null)
            moviesService.createMovie(movie);
        else
            moviesService.updateMovie(movie);
        model.addAttribute("title", "Película guardada");
        attributes.addFlashAttribute("msg", "Los datos de la película fueron guardados!");
        return "redirect:/movies/list";
    }

    @GetMapping("/update/{id}")
    public String editarMovie(Model model, @PathVariable("id") Integer id) {
        Movie movie = moviesService.findMovieById(id);
        model.addAttribute("title", "Editar película");
        model.addAttribute("movie", movie);
        return "movies/formMovie";
    }

    @GetMapping("/delete/{id}")
    public String deleteMovie(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        moviesService.deleteMovie(id);
        attributes.addFlashAttribute("msg", "Los datos de la película fueron borrados!");
        return "redirect:/movies/list";
    }

}
