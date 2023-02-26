package uah.es.moviesfrontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uah.es.moviesfrontend.model.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService {

    @Autowired
    RestTemplate template;

    String url = System.getenv("SECURITY_API_URL") + "/users";
    

    @Override
    public Page<User> findAll(Pageable pageable) {
        User[] users = template.getForObject(url, User[].class);
        List<User> usersList = Arrays.asList(users);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<User> list;

        if (usersList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, usersList.size());
            list = usersList.subList(startItem, toIndex);
        }

        Page<User> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), usersList.size());
        return page;
    }

    @Override
    public User findUserById(Integer id) {
        User user = template.getForObject(url + "/" + id, User.class);
        return user;
    }

    @Override
    public User findUserByUsername(String username) {
        User user = template.getForObject(url + "/username/" + username, User.class);
        return user;
    }

    @Override
    public Page<User> findUserByUsername(String username, Pageable pageable) {
        User user = this.findUserByUsername(username);
        List<User> usersList = new LinkedList<User>();

        if(user != null) 
            usersList.add(user);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<User> list;

        if (usersList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, usersList.size());
            list = usersList.subList(startItem, toIndex);
        }

        Page<User> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), usersList.size());
        return page;
    }

    @Override
    public User findUserByEmail(String email) {
        User user = template.getForObject(url + "/email/" + email, User.class);
        return user;
    }

    @Override
    public Page<User> findUserByEmail(String email, Pageable pageable) {
        User user = this.findUserByEmail(email);
        List<User> usersList = new LinkedList<User>();

        if(user != null) 
            usersList.add(user);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<User> list;

        if (usersList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, usersList.size());
            list = usersList.subList(startItem, toIndex);
        }

        Page<User> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), usersList.size());
        return page;
    }

    @Override
    public User login(String email, String password) {
        User user = template.getForObject(url + "/login/" + email + "/" + password, User.class);
        return user;

    }

    @Override
    public void saveUser(User user) {
        if (user.getId() != null && user.getId() > 0) {
            template.put(url, user);
        } else {
            user.setId(0);
            template.postForObject(url, user, String.class);
        }
    }

    @Override
    public void deleteUser(Integer id) {
        template.delete(url + "/" + id);
    }

}
