package it.unito.iumtweb.springboot.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Actor entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */
@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {

    /**
     * Retrieves a list of actors whose name matches the specified name, ignoring case.
     *
     * @param name The exact name of the actor(s) to find.
     * @return A list of actors with the specified name.
     */
    @Query("SELECT a FROM Actor a WHERE LOWER(a.name) = LOWER(:name)")
    List<Actor> findByName(String name);

    /**
     * Retrieves a list of actors whose names contain the specified keyword, ignoring case.
     *
     * @param keyword The keyword to search for within actor names.
     * @return A list of actors whose names contain the specified keyword.
     */
    @Query("SELECT a FROM Actor a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Actor> findByNameContainingIgnoreCase(String keyword);

}
