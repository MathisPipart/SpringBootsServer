package it.unito.iumtweb.springboot.studio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for managing Studio entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface StudioRepository extends JpaRepository<Studio, Long> {

    /**
     * Finds a list of studios by their exact name, ignoring case.
     *
     * @param name The exact name of the studio to find.
     * @return A list of studios with the specified name.
     */
    @Query("SELECT a FROM Studio a WHERE LOWER(a.studio) = LOWER(:name)")
    List<Studio> findByName(String name);

    /**
     * Finds a list of studios whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in studio names.
     * @return A list of studios whose names match the keyword.
     */
    @Query("SELECT a FROM Studio a WHERE LOWER(a.studio) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Studio> findByNameContainingIgnoreCase(String keyword);

}
