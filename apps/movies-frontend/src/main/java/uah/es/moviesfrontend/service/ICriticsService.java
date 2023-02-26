package uah.es.moviesfrontend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uah.es.moviesfrontend.model.Critic;

public interface ICriticsService {

    Page<Critic> findAll(Pageable pageable);

    Critic findCriticById(Integer id);

    Critic[] findCriticsByUserId(Integer id);

    Page<Critic> findCriticsByUserId(Integer id, Pageable pageable);

    Critic[] findCriticsByMovieId(Integer id);

    Page<Critic> findCriticsByMovieId(Integer id, Pageable pageable);

    void saveCritic(Critic critic);

    void deleteCritic(Integer id);

}
