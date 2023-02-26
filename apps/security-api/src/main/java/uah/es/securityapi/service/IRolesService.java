package uah.es.securityapi.service;

import java.util.List;

import uah.es.securityapi.model.Role;

public interface IRolesService {
    List<Role> findAll();

    Role findRoleById(Integer id);
}