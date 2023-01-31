package uah.es.moviesfrontend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uah.es.moviesfrontend.model.Actor;

public interface IActorsService {

    Page<Actor> findAll(Pageable pageable);

    Actor findActorById(Integer id);

    Page<Actor> findActorsByName(String title, Pageable pageable);

    void createActor(Actor actor);

    void deleteActor(Integer idActor);

    void updateActor(Actor actor);

    void addActorToMovieCasting(Integer idActor, Integer idMovie);
}
