package uah.es.moviesbackend.dao;

import uah.es.moviesbackend.model.Actor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorsJPA extends JpaRepository<Actor, Integer> {

    List<Actor> findByNameContainingIgnoreCase(String name);

}
