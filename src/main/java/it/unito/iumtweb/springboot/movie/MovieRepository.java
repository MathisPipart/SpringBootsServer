package it.unito.iumtweb.springboot.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Add custom query methods if required
    Optional<Movie> findByName(String name);

    @Query("SELECT m FROM Movie m WHERE UPPER(m.name) LIKE UPPER(:keyword)")
    List<Movie> findMoviesByNameKeyword(@Param("keyword") String keyword);

    @Query(nativeQuery = true, value = " SELECT m.id AS movie_id, m.name AS movie_name, m.date AS movie_date, m.description AS movie_description, m.minute AS movie_duration, m.rating AS movie_rating, m.tagline AS movie_tagline, a.name AS actor_name, a.role AS actor_role FROM movie m LEFT JOIN actor a ON m.id = a.id WHERE LOWER(m.name) = LOWER(:movieName)")
    List<Object[]> findMovieWithActorsByName(@Param("movieName") String movieName);

}
