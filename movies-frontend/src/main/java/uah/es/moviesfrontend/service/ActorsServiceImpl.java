package uah.es.moviesfrontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uah.es.moviesfrontend.model.Actor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ActorsServiceImpl implements IActorsService {

    @Autowired
    RestTemplate template;

    String url = "http://localhost:3000/actors";

    @Override
    public Page<Actor> findAll(Pageable pageable) {
        Actor[] actors = template.getForObject(url, Actor[].class);
        List<Actor> actorsList = Arrays.asList(actors);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Actor> list;

        if (actorsList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, actorsList.size());
            list = actorsList.subList(startItem, toIndex);
        }

        Page<Actor> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), actorsList.size());
        return page;
    }

    @Override
    public Actor findActorById(Integer idActor) {
        Actor actor = template.getForObject(url + "/" + idActor, Actor.class);
        return actor;
    }

    @Override
    public Page<Actor> findActorsByName(String actorName, Pageable pageable) {
        Actor[] actors = template.getForObject(url + "/name/" + actorName, Actor[].class);
        List<Actor> actorList = Arrays.asList(actors);
        Page<Actor> page = new PageImpl<>(actorList, pageable, actorList.size());
        return page;
    }

    @Override
    public void createActor(Actor actor) {
        template.postForObject(url, actor, String.class);
    }

    @Override
    public void updateActor(Actor actor) {
        template.put(url, actor);

    }

    @Override
    public void deleteActor(Integer id) {
        template.delete(url + "/" + id);
    }

    @Override
    public void addActorToMovieCasting(Integer idActor, Integer idMovie) {
        template.delete(url + "/" + idActor + "/" + idMovie);
    }
}
