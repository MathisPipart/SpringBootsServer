package it.unito.iumtweb.springboot.poster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface PosterRepository extends JpaRepository<Poster, Long> {
    // Add custom query methods if required
    @Query("SELECT a FROM Poster a WHERE LOWER(a.link) = LOWER(:name)")
    List<Poster> findByName(String name);

    @Query("SELECT a FROM Poster a WHERE LOWER(a.link) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Poster> findByNameContainingIgnoreCase(String keyword);

}
