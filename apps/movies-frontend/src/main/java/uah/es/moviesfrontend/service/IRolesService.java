package uah.es.moviesfrontend.service;

import java.util.List;
import uah.es.moviesfrontend.model.Role;

public interface IRolesService {

    List<Role> findAll();

    Role findRoleById(Integer id);
}
