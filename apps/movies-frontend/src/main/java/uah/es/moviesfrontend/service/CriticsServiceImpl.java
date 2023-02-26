package uah.es.moviesfrontend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import uah.es.moviesfrontend.model.Critic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CriticsServiceImpl implements ICriticsService {

    @Autowired
    RestTemplate template;

    String url = System.getenv("SECURITY_API_URL") + "/critics";

    @Override
    public Page<Critic> findAll(Pageable pageable) {
        Critic[] critics = template.getForObject(url, Critic[].class);
        List<Critic> criticsList = Arrays.asList(critics);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Critic> list;

        if (criticsList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, criticsList.size());
            list = criticsList.subList(startItem, toIndex);
        }

        Page<Critic> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), criticsList.size());
        return page;
    }

    @Override
    public Critic findCriticById(Integer id) {
        Critic critic = template.getForObject(url + "/" + id, Critic.class);
        return critic;
    }

    public Critic[] findCriticsByUserId(Integer id) {
        Critic critic[] = template.getForObject(url + "/user/" + id, Critic[].class);
        return critic;
    }

    @Override
    public Page<Critic> findCriticsByUserId(Integer id, Pageable pageable) {
        Critic critics[] = this.findCriticsByUserId(id);
        List<Critic> criticsList = Arrays.asList(critics);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Critic> list;

        if (criticsList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, criticsList.size());
            list = criticsList.subList(startItem, toIndex);
        }

        Page<Critic> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), criticsList.size());
        return page;
    }

    public Critic[] findCriticsByMovieId(Integer id) {
        Critic critic[] = template.getForObject(url + "/movie/" + id, Critic[].class);
        return critic;
    }

    @Override
    public Page<Critic> findCriticsByMovieId(Integer id, Pageable pageable) {
        Critic[] critics = this.findCriticsByMovieId(id);
        List<Critic> criticsList = Arrays.asList(critics);

        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Critic> list;

        if (criticsList.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, criticsList.size());
            list = criticsList.subList(startItem, toIndex);
        }

        Page<Critic> page = new PageImpl<>(list, PageRequest.of(currentPage, pageSize), criticsList.size());
        return page;
    }

    @Override
    public void saveCritic(Critic critic) {
        if (critic.getId() != null && critic.getId() > 0) {
            template.put(url, critic);
        } else {
            critic.setId(0);
            template.postForObject(url, critic, String.class);
        }
    }

    @Override
    public void deleteCritic(Integer id) {
        template.delete(url + "/" + id);
    }

}
