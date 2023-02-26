package uah.es.moviesfrontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uah.es.moviesfrontend.model.Role;

import java.util.Arrays;
import java.util.List;

@Service
public class RolesServiceImpl implements IRolesService {

    @Autowired
    RestTemplate template;

    String url = System.getenv("SECURITY_API_URL") + "/users/roles";

    @Override
    public List<Role> findAll() {
        Role[] roles = template.getForObject(url, Role[].class);
        return Arrays.asList(roles);
    }

    @Override
    public Role findRoleById(Integer id) {
        Role role = template.getForObject(url + "/" + id, Role.class);
        return role;
    }
}
