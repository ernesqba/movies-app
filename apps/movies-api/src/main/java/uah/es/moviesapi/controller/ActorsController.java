package uah.es.moviesapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import uah.es.moviesapi.model.Actor;
import uah.es.moviesapi.service.IActorsService;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsController {

    @Autowired
    IActorsService actorsService;

    @GetMapping()
    public List<Actor> findAll() {
        return actorsService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findActorById(@PathVariable("id") Integer id) {
        return actorsService.findActorById(id);
    }

    @GetMapping("/name/{name}")
    public List<Actor> findActorByName(@PathVariable("name") String name) {
        return actorsService.findActorByName(name);
    }

    @PostMapping()
    public void createActor(@RequestBody Actor actor) {
        actorsService.createActor(actor);
    }

    @PutMapping()
    public void updateActor(@RequestBody Actor actor) {
        actorsService.updateActor(actor);
    }

    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable("id") Integer id) {
        actorsService.deleteActor(id);
    }

    @PostMapping("/cast/{ida}/{idm}")
    public void addActorToMovieCasting(@PathVariable("ida") Integer idActor, @PathVariable("idm") Integer idMovie) {
        actorsService.addActorToMovieCasting(idActor, idMovie);
    }

}
