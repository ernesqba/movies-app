package uah.es.securityapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uah.es.securityapi.dao.IRolesDAO;
import uah.es.securityapi.model.Role;

import java.util.List;

@Service
public class RolesServiceImpl implements IRolesService {
    @Autowired
    IRolesDAO rolesDAO;

    @Override
    public List<Role> findAll() {
        return rolesDAO.findAll();
    }

    @Override
    public Role findRoleById(Integer id) {
        return rolesDAO.findRoleById(id);
    }
}