package it.unito.iumtweb.springboot.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Add custom query methods if required
    Optional<Movie> findByName(String name);

    List<Movie> findByNameContainingIgnoreCase(String keyword);
}
