package uah.es.moviesfrontend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import uah.es.moviesfrontend.model.User;

public interface IUsersService {

    Page<User> findAll(Pageable pageable);

    User findUserById(Integer id);

    User findUserByUsername(String username);

    Page<User> findUserByUsername(String username, Pageable pageable);

    User findUserByEmail(String email);

    Page<User> findUserByEmail(String email, Pageable pageable);

    User login(String email, String password);

    void saveUser(User user);

    void deleteUser(Integer id);

}
