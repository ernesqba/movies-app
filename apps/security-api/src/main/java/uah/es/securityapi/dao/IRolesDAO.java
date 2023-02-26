package uah.es.securityapi.dao;

import java.util.List;

import uah.es.securityapi.model.Role;

public interface IRolesDAO {
    List<Role> findAll();

    Role findRoleById(Integer id);
}