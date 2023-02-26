package uah.es.securityapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import uah.es.securityapi.model.Role;
import uah.es.securityapi.model.User;
import uah.es.securityapi.service.IRolesService;
import uah.es.securityapi.service.IUsersService;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    IUsersService usersService;

    @Autowired
    IRolesService rolesService;

    @GetMapping("/users")
    public List<User> findAllUsers() {
        System.out.println("HEREEE");
        return usersService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return usersService.findUserById(id);
    }

    @GetMapping("/users/email/{email}")
    public User findUserByEmail(@PathVariable("email") String email) {
        return usersService.findUserByEmail(email);
    }

    @GetMapping("/users/username/{username}")
    public User findUserByUsername(@PathVariable("username") String username) {
        return usersService.findUserByUsername(username);
    }

    @GetMapping("/users/login/{email}/{password}")
    public User login(@PathVariable("email") String email,
            @PathVariable("password") String password) {
        return usersService.findUserByEmailAndPassword(email, password);
    }

    @GetMapping("/users/roles")
    public List<Role> findAllRoles() {
        return rolesService.findAll();
    }

    @GetMapping("/users/roles/{id}")
    public Role findRoleById(@PathVariable("id") Integer id) {
        return rolesService.findRoleById(id);
    }

    @PostMapping("/users")
    public void saveUser(@RequestBody User user) {
        usersService.saveUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user) {
        usersService.updateUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        usersService.deleteUser(id);
    }
}