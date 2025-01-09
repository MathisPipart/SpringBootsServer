package it.unito.iumtweb.springboot.genre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for managing Genre entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    /**
     * Finds a list of genres by their exact name, ignoring case.
     *
     * @param name The exact name of the genre to find.
     * @return A list of genres with the specified name.
     */
    @Query("SELECT a FROM Genre a WHERE LOWER(a.genre) = LOWER(:name)")
    List<Genre> findByName(String name);

    /**
     * Finds a list of genres whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in genre names.
     * @return A list of genres whose names match the keyword.
     */
    @Query("SELECT a FROM Genre a WHERE LOWER(a.genre) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Genre> findByNameContainingIgnoreCase(String keyword);

    /**
     * Finds a list of distinct genre names.
     *
     * @return A list of unique genre names.
     */
    @Query("SELECT DISTINCT g.genre FROM Genre g")
    List<String> findDistinctGenres();
}
