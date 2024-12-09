package it.unito.iumtweb.springboot.genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    // Add custom query methods if required
    @Query("SELECT a FROM Genre a WHERE LOWER(a.genre) = LOWER(:name)")
    List<Genre> findByName(String name);

    @Query("SELECT a FROM Genre a WHERE LOWER(a.genre) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Genre> findByNameContainingIgnoreCase(String keyword);

}
