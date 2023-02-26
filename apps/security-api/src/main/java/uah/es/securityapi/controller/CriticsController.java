package uah.es.securityapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import uah.es.securityapi.model.Critic;
import uah.es.securityapi.service.ICriticsService;

import java.util.List;

@RestController
public class CriticsController {
    @Autowired
    ICriticsService criticsService;

    @GetMapping("/critics")
    public List<Critic> findAll() {
        return criticsService.findAll();
    }

    @GetMapping("/critics/movie/{id}")
    public List<Critic> findCriticsByMoviesId(@PathVariable("id") Integer id) {
        return criticsService.findCriticsByMoviesId(id);
    }

    @GetMapping("/critics/user/{id}")
    public List<Critic> findCriticsByUserId(@PathVariable("id") Integer id) {
        return criticsService.findCriticsByUserId(id);
    }

    @GetMapping("/critics/{id}")
    public Critic findCriticById(@PathVariable("id") Integer id) {
        return criticsService.findCriticById(id);
    }

    @PostMapping("/critics")
    public void saveCritic(@RequestBody Critic critic) {
        criticsService.saveCritic(critic);
    }

    @DeleteMapping("/critics/{id}")
    public void deleteCritic(@PathVariable("id") Integer id) {
        criticsService.deleteCritic(id);
    }
}
