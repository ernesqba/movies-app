package uah.es.moviesapi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uah.es.moviesapi.model.Actor;

public interface IActorsJPA extends JpaRepository<Actor, Integer> {

    List<Actor> findByNameContainingIgnoreCase(String name);

}
