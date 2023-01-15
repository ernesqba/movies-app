package uah.es.moviesbackend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uah.es.moviesbackend.model.Actor;
import uah.es.moviesbackend.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public class ActorsDAOImpl implements IActorsDAO {

    @Autowired
    IActorsJPA actorsJPA;

    @Autowired
    IMoviesJPA moviesJPA;

    @Override
    public List<Actor> findAll() {
        return actorsJPA.findAll();
    }

    @Override
    public Actor findActorById(Integer id) {
        Optional<Actor> optional = actorsJPA.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Actor> findActorByName(String name) {
        return actorsJPA.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void createActor(Actor actor) {
        actorsJPA.save(actor);
    }

    @Override
    public void updateActor(Actor actor) {
        actorsJPA.save(actor);
    }

    @Override
    public void deleteActor(Integer id) {
        Optional<Actor> optional = actorsJPA.findById(id);
        if (optional.isPresent()) {
            Actor actor = optional.get();
            List<Movie> movies = actor.getMovies();
            for (Movie movie : movies) {
                movies.remove(movie);
            }
        }
        actorsJPA.deleteById(id);
    }

    @Override
    public void addActorToMovieCasting(Integer idActor, Integer idMovie) {
        Optional<Actor> optionalActor = actorsJPA.findById(idActor);
        if (optionalActor.isPresent()) {
            Actor actor = optionalActor.get();
            Optional<Movie> optionalMovie = moviesJPA.findById(idMovie);
            if (optionalMovie.isPresent()) {
                actor.addMovie(optionalMovie.get());
                actorsJPA.save(actor);
            }
        }
    }

}
