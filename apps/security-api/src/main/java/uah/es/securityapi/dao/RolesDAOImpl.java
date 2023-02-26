package uah.es.securityapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uah.es.securityapi.model.Role;
import java.util.Optional;

@Repository
public class RolesDAOImpl implements IRolesDAO {

    @Autowired
    IRolesJPA rolesJPA;

    @Override
    public List<Role> findAll() {
        return rolesJPA.findAll();
    }

    @Override
    public Role findRoleById(Integer id) {
        Optional<Role> optional = rolesJPA.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }
}