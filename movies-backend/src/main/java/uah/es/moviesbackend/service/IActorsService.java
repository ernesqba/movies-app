package uah.es.moviesbackend.service;

import uah.es.moviesbackend.model.Actor;

import java.util.List;

public interface IActorsService {

    List<Actor> findAll();

    Actor findActorById(Integer id);

    List<Actor> findActorByName(String name);

    void createActor(Actor actor);

    void deleteActor(Integer idActor);

    void updateActor(Actor actor);

    void addActorToMovieCasting(Integer idActor, Integer idMovie);

}
