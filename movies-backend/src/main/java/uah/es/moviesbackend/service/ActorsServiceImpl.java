package uah.es.moviesbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uah.es.moviesbackend.dao.IActorsDAO;
import uah.es.moviesbackend.model.Actor;

import java.util.List;

@Service
public class ActorsServiceImpl implements IActorsService {

    @Autowired
    IActorsDAO actorsDAO;

    @Override
    public List<Actor> findAll() {
        return actorsDAO.findAll();
    }

    @Override
    public Actor findActorById(Integer id) {
        return actorsDAO.findActorById(id);
    }

    @Override
    public List<Actor> findActorByName(String name) {
        return actorsDAO.findActorByName(name);
    }

    @Override
    public void createActor(Actor actor) {
        actorsDAO.createActor(actor);
    }

    @Override
    public void deleteActor(Integer id) {
        actorsDAO.deleteActor(id);
    }

    @Override
    public void updateActor(Actor actor) {
        actorsDAO.updateActor(actor);
    }

    @Override
    public void addActorToMovieCasting(Integer idActor, Integer idMovie) {
        actorsDAO.addActorToMovieCasting(idActor, idMovie);
    }

}
