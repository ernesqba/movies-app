package uah.es.securityapi.service;

import java.util.List;

import uah.es.securityapi.model.User;

public interface IUsersService {
    List<User> findAll();

    User findUserById(Integer id);

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);

    void saveUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);
}