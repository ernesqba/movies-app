package uah.es.securityapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uah.es.securityapi.dao.ICriticsDAO;
import uah.es.securityapi.model.Critic;

import java.util.List;

@Service
public class CriticsServiceImpl implements ICriticsService {
    @Autowired
    ICriticsDAO criticsDAO;

    @Override
    public List<Critic> findAll() {
        return criticsDAO.findAll();
    }

    @Override
    public List<Critic> findCriticsByMoviesId(Integer id) {
        return criticsDAO.findCriticsByMoviesId(id);
    }

    @Override
    public List<Critic> findCriticsByUserId(Integer id) {
        return criticsDAO.findCriticsByUserId(id);
    }

    @Override
    public Critic findCriticById(Integer id) {
        return criticsDAO.findCriticById(id);
    }

    @Override
    public void saveCritic(Critic critic) {
        criticsDAO.saveCritic(critic);
    }

    @Override
    public void deleteCritic(Integer id) {
        criticsDAO.deleteCritic(id);
    }
}
