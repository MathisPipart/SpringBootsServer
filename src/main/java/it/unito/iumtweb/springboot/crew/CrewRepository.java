package it.unito.iumtweb.springboot.crew;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Repository interface for managing Crew entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface CrewRepository extends JpaRepository<Crew, Long> {

    /**
     * Retrieves a list of crew members whose name matches the specified name, ignoring case.
     *
     * @param name The exact name of the crew member to find.
     * @return A list of crew members with the specified name.
     */
    @Query("SELECT a FROM Crew a WHERE LOWER(a.name) = LOWER(:name)")
    List<Crew> findByName(String name);

    /**
     * Retrieves a list of crew members whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for in crew member names.
     * @return A list of crew members whose names match the keyword.
     */
    @Query("SELECT a FROM Crew a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Crew> findByNameContainingIgnoreCase(String keyword);

}
