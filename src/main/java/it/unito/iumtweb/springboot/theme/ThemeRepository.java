package it.unito.iumtweb.springboot.theme;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for managing Theme entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

    /**
     * Finds a list of themes by their exact name, ignoring case.
     *
     * @param name The exact name of the theme to find.
     * @return A list of themes with the specified name.
     */    @Query("SELECT a FROM Theme a WHERE LOWER(a.theme) = LOWER(:name)")
    List<Theme> findByName(String name);

    /**
     * Finds a list of themes whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in theme names.
     * @return A list of themes whose names match the keyword.
     */
    @Query("SELECT a FROM Theme a WHERE LOWER(a.theme) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Theme> findByNameContainingIgnoreCase(String keyword);

}
