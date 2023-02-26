package uah.es.securityapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import uah.es.securityapi.model.User;

public interface IUsersJPA extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByEmail(String email);

    User findUserByEmailAndPassword(String email, String password);
}