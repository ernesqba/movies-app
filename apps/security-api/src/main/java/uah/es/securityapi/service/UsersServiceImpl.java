package uah.es.securityapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uah.es.securityapi.dao.IUsersDAO;
import uah.es.securityapi.model.User;

import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService {
    @Autowired
    IUsersDAO usersDAO;

    @Override
    public List<User> findAll() {
        System.out.println("null");
        return usersDAO.findAll();
    }

    @Override
    public User findUserByUsername(String username) {
        return usersDAO.findUserByUsername(username);
    }

    @Override
    public User findUserById(Integer id) {
        return usersDAO.findUserById(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return usersDAO.findUserByEmail(email);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return usersDAO.findUserByEmailAndPassword(email, password);
    }

    @Override
    public void saveUser(User user) {
        usersDAO.saveUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        usersDAO.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        usersDAO.updateUser(user);
    }
}