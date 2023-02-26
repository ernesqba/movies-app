package uah.es.moviesapi.service;

import java.util.List;

import uah.es.moviesapi.model.Actor;

public interface IActorsService {

    List<Actor> findAll();

    Actor findActorById(Integer id);

    List<Actor> findActorByName(String name);

    void createActor(Actor actor);

    void deleteActor(Integer idActor);

    void updateActor(Actor actor);

    void addActorToMovieCasting(Integer idActor, Integer idMovie);

}
