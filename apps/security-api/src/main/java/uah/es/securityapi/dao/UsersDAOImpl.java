package uah.es.securityapi.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import uah.es.securityapi.model.User;
import java.util.Optional;

@Repository
public class UsersDAOImpl implements IUsersDAO {

    @Autowired
    IUsersJPA usersJPA;

    @Override
    public List<User> findAll() {
        return usersJPA.findAll();
    }

    @Override
    public User findUserById(Integer id) {
        Optional<User> optional = usersJPA.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public User findUserByUsername(String username) {
        Optional<User> optional = Optional.ofNullable(usersJPA.findByUsername(username));
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
        
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> optional = Optional.ofNullable(usersJPA.findByEmail(email));
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        Optional<User> optional = Optional.ofNullable(usersJPA.findUserByEmailAndPassword(email, password));
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        usersJPA.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        usersJPA.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        usersJPA.save(user);
    }
}