package uah.es.moviesfrontend.controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uah.es.moviesfrontend.model.Actor;
import uah.es.moviesfrontend.paginator.PageRender;
import uah.es.moviesfrontend.service.IActorsService;

@Controller
@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    IActorsService actorsService;

    @GetMapping("/new")
    public String nuevo(Model model) {
        model.addAttribute("title", "Nuevo actor");
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "actors/formActor";
    }

    @GetMapping("/find")
    public String buscar(Model model) {
        return "actors/searchActor";
    }

    @GetMapping("/list")
    public String findAll(Model model, @RequestParam(name = "page", defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Actor> list = actorsService.findAll(pageable);
        PageRender<Actor> pageRender = new PageRender<Actor>("/actors/list", list);
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        model.addAttribute("format", dt1);
        model.addAttribute("title", "Listado de todos los actores");
        model.addAttribute("actorList", list);
        model.addAttribute("page", pageRender);
        return "actors/listActor";
    }

    @GetMapping("/idactor/{id}")
    public String findActorById(Model model, @PathVariable("id") Integer id) {
        Actor actor = actorsService.findActorById(id);
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        model.addAttribute("format", dt1);
        model.addAttribute("actor", actor);
        return "actors/formActor";
    }

    @GetMapping("/name")
    public String findActorsByName(Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam("name") String name) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<Actor> actorList;
        if (name.equals("")) {
            actorList = actorsService.findAll(pageable);
        } else {
            actorList = actorsService.findActorsByName(name, pageable);
        }
        PageRender<Actor> pageRender = new PageRender<Actor>("/list", actorList);
        SimpleDateFormat dt1 = new SimpleDateFormat("dd-MM-yyyy");
        model.addAttribute("format", dt1);
        model.addAttribute("title", "Listado de actores por nombre");
        model.addAttribute("actorList", actorList);
        model.addAttribute("page", pageRender);
        return "actors/listActor";
    }

    @PostMapping("/save")
    public String saveActor(Model model, Actor actor, RedirectAttributes attributes) {
        if (actor.getId() == null)
            actorsService.createActor(actor);
        else
            actorsService.updateActor(actor);
        model.addAttribute("title", "Actor guardado");
        attributes.addFlashAttribute("msg", "Los datos del actor fueron guardados!");
        return "redirect:/actors/list";
    }

    @GetMapping("/update/{id}")
    public String editarActor(Model model, @PathVariable("id") Integer id) {
        Actor actor = actorsService.findActorById(id);
        model.addAttribute("title", "Editar actor");
        model.addAttribute("actor", actor);
        return "actors/formActor";
    }

    @GetMapping("/delete/{id}")
    public String deleteActor(Model model, @PathVariable("id") Integer id, RedirectAttributes attributes) {
        actorsService.deleteActor(id);
        attributes.addFlashAttribute("msg", "Los datos del actor fueron borrados!");
        return "redirect:/actors/list";
    }

}
