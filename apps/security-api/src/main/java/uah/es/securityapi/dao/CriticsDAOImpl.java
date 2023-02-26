package uah.es.securityapi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uah.es.securityapi.model.Critic;

import java.util.List;
import java.util.Optional;

@Repository
public class CriticsDAOImpl implements ICriticsDAO {
    @Autowired
    ICriticsJPA criticsJPA;

    @Override
    public List<Critic> findAll() {
        return criticsJPA.findAll();
    }

    @Override
    public List<Critic> findCriticsByMoviesId(Integer id) {
        return criticsJPA.findByMoviesId(id);
    }

    @Override
    public List<Critic> findCriticsByUserId(Integer id) {
        return criticsJPA.findByUser_Id(id);
    }

    @Override
    public Critic findCriticById(Integer id) {
        Optional<Critic> optional = criticsJPA.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void saveCritic(Critic critic) {
        criticsJPA.save(critic);
    }

    @Override
    public void deleteCritic(Integer id) {
        criticsJPA.deleteById(id);
    }

}
