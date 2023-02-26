package uah.es.moviesfrontend.controller;

import uah.es.moviesfrontend.model.User;
import uah.es.moviesfrontend.model.Critic;
import uah.es.moviesfrontend.model.Movie;
import uah.es.moviesfrontend.paginator.PageRender;
import uah.es.moviesfrontend.service.IUsersService;
import uah.es.moviesfrontend.service.ICriticsService;
import uah.es.moviesfrontend.service.IMoviesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/critics")
public class CriticsController {
    @Autowired
    ICriticsService criticsService;

    @Autowired
    IUsersService usersService;

    @Autowired
    IMoviesService moviesService;

    @GetMapping("/find")
    public String buscar(Model model) {
        Movie movies[] = moviesService.findAll();
        model.addAttribute("movies", movies);
        return "critics/searchCritic";
    }

    @GetMapping("/list")
    public String listCritic(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Critic> list = criticsService.findAll(pageable);
        list.stream().forEach(critic -> {
            Movie movie = moviesService.findMovieById(critic.getMoviesId());
            critic.setMovie(movie);
        });
        PageRender<Critic> pageRender = new PageRender<Critic>("/critics/list", list);
        model.addAttribute("title", "Listado de todas las críticas");
        model.addAttribute("criticList", list);
        model.addAttribute("page", pageRender);
        return "critics/listCritic";
    }

    @GetMapping("/user")
    public String findCriticsByUserId(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam("username") String username) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Critic> criticList;
        User user = null;

        if (username.equals("")) {
            criticList = criticsService.findAll(pageable);
        } else {
            user = usersService.findUserByUsername(username);
            criticList = criticsService.findCriticsByUserId(user.getId(), pageable);
        }
        criticList.stream().forEach(critic -> {
            Movie tempMovie = moviesService.findMovieById(critic.getMoviesId());
            critic.setMovie(tempMovie);
        });
        PageRender<Critic> pageRender = new PageRender<Critic>("/list", criticList);
        String title = "Listado de todas las críticas";
        if (user.getId() != null)
            title = "Listado de críticas para usuario: " + user.getUsername();
        model.addAttribute("title", title);
        model.addAttribute("criticList", criticList);
        model.addAttribute("page", pageRender);
        return "critics/listCritic";
    }

    @GetMapping("/movie")
    public String findCriticsByMovieId(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam("moviesId") Integer moviesId) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Critic> criticList;

        Movie movie = moviesService.findMovieById(moviesId);
        criticList = criticsService.findCriticsByMovieId(moviesId, pageable);
        criticList.stream().forEach(critic -> {
            Movie tempMovie = moviesService.findMovieById(critic.getMoviesId());
            critic.setMovie(tempMovie);
        });
        PageRender<Critic> pageRender = new PageRender<Critic>("/list", criticList);
        model.addAttribute("title", "Listado de críticas para la película: " + movie.getTitle());
        model.addAttribute("criticList", criticList);
        model.addAttribute("page", pageRender);
        return "critics/listCritic";
    }

    @GetMapping("/new")
    public String newCritic(Model model) {
        Movie movies[] = moviesService.findAll();
        model.addAttribute("title", "Nueva crítica");
        model.addAttribute("movies", movies);
        Critic critic = new Critic();
        model.addAttribute("critic", critic);
        return "critics/formCritic";
    }

    @PostMapping("/save")
    public String saveCritic(Model model, Critic critic, RedirectAttributes attributes) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = ((UserDetails) principal).getUsername();
        Critic critics[] = criticsService.findCriticsByMovieId(critic.getMoviesId());
        critic.setUser(usersService.findUserByEmail(email));
        if (critic.getId() == null && critics != null
                && Arrays.asList(critics).stream().anyMatch(x -> x.getUser().getId() == critic.getUser().getId())) {
            attributes.addFlashAttribute("msga",
                    "Error al guardar, ya existe una critica de este usuario para esta película!");
            return "redirect:/critics/list";
        }
        criticsService.saveCritic(critic);
        model.addAttribute("title", "Nueva crítica");
        attributes.addFlashAttribute("msg", "Los datos de la crítica fueron guardados!");
        return "redirect:/critics/list";
    }

    @GetMapping("/edit/{id}")
    public String editCritic(Model model, @PathVariable("id") Integer id) {
        Critic critic = criticsService.findCriticById(id);
        model.addAttribute("title", "Editar critic");
        model.addAttribute("critic", critic);
        return "critics/formCritic";
    }

    @GetMapping("/delete/{id}")
    public String deleteCritic(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        Critic critic = criticsService.findCriticById(id);
        if (critic != null) {
            criticsService.deleteCritic(id);
            attributes.addFlashAttribute("msg", "Los datos de la crítica fueron borrados!");
        } else {
            attributes.addFlashAttribute("msg", "Crítica no encontrada!");
        }

        return "redirect:/critics/list";
    }

}
