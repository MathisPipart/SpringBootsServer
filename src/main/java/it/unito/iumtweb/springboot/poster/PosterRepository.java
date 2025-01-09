package it.unito.iumtweb.springboot.poster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for managing Poster entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface PosterRepository extends JpaRepository<Poster, Long> {

    /**
     * Finds a list of posters by their exact name, ignoring case.
     *
     * @param name The exact name of the poster to find.
     * @return A list of posters with the specified name.
     */    @Query("SELECT a FROM Poster a WHERE LOWER(a.link) = LOWER(:name)")
    List<Poster> findByName(String name);

    /**
     * Finds a list of posters whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in poster names.
     * @return A list of posters whose names match the keyword.
     */
    @Query("SELECT a FROM Poster a WHERE LOWER(a.link) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Poster> findByNameContainingIgnoreCase(String keyword);

}
