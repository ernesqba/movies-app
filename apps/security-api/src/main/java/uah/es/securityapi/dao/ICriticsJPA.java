package uah.es.securityapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import uah.es.securityapi.model.Critic;

import java.util.List;

public interface ICriticsJPA extends JpaRepository<Critic, Integer> {
    List<Critic> findByMoviesId(int id);

    List<Critic> findByUser_Id(int id);
}
