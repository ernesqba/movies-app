package uah.es.securityapi.dao;

import java.util.List;

import uah.es.securityapi.model.Critic;

public interface ICriticsDAO {
    List<Critic> findAll();

    List<Critic> findCriticsByMoviesId(Integer id);

    List<Critic> findCriticsByUserId(Integer id);

    Critic findCriticById(Integer id);

    void saveCritic(Critic critic);

    void deleteCritic(Integer idCritic);
}
