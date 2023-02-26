package uah.es.moviesapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uah.es.moviesapi.model.Movie;

import java.util.List;

public interface IMoviesJPA extends JpaRepository<Movie, Integer> {

    List<Movie> findByTitleContainingIgnoreCase(String title);

    List<Movie> findByGenreContainingIgnoreCase(String genre);

    @Query(value = "select mo.* from movies mo inner join movie_casting mc on mc.movie_id = mo.id inner join actors ac on ac.id = mc.actor_id where ac.name like %:actorName%", nativeQuery = true)
    List<Movie> findByActorName(@Param("actorName") String actorName);

}
