package it.unito.iumtweb.springboot.release;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for managing Release entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface ReleaseRepository extends JpaRepository<Release, Long> {

    /**
     * Finds a list of releases by their exact name, ignoring case.
     *
     * @param name The exact name of the release to find.
     * @return A list of releases with the specified name.
     */    @Query("SELECT a FROM Release a WHERE LOWER(a.country) = LOWER(:name)")
    List<Release> findByName(String name);

    /**
     * Finds a list of releases whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in release names.
     * @return A list of releases whose names match the keyword.
     */
    @Query("SELECT a FROM Release a WHERE LOWER(a.country) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Release> findByNameContainingIgnoreCase(String keyword);

}
