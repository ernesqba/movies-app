package uah.es.securityapi.dao;

import java.util.List;

import uah.es.securityapi.model.User;

public interface IUsersDAO {
    List<User> findAll();

    User findUserById(Integer id);

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);

    void saveUser(User user);

    void deleteUser(Integer id);

    void updateUser(User user);
}